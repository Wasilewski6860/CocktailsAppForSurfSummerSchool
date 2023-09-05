package com.example.cocktailroomkoin.presentation.add

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.cocktailroomkoin.R
import com.example.cocktailroomkoin.databinding.FragmentAddCocktailBinding
import com.example.cocktailroomkoin.domain.models.Cocktail
import com.google.android.material.textfield.TextInputEditText
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddCocktailFragment : Fragment() {

    private var _binding: FragmentAddCocktailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddCocktailViewModel by viewModel()
    private var cocktailId = -1
    private var uri : String = ""
    private lateinit var cocktail: Cocktail



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cocktailId = it.getInt(ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddCocktailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (cocktailId > 0) {
            viewModel.getCocktail(cocktailId)
            viewModel.cocktail.observe(viewLifecycleOwner) {
                bindViews(it)
            }
            binding.buttonSave.setOnClickListener { saveCocktail(cocktailId) }

        } else {
            binding.buttonSave.setOnClickListener { saveCocktail(cocktailId) }
        }

        val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()){
            var requestOptions = RequestOptions()
            requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(54))

            Glide.with(requireContext())
                .load(it)
                .apply(requestOptions)
                .into(binding.imageButton)
            if (it != null){
                viewModel.saveUri(it)
                uri = it.toString()
            }
        }

        binding.imageButton.setOnClickListener {
            pickImage.launch("image/*")
        }

        binding.buttonCancel.setOnClickListener { findNavController().navigateUp() }

        clearErrorMessage(binding.editCocktailIngredients)
        clearErrorMessage(binding.editCocktailName)

    }

    private fun isInputValid(): Boolean {
        return viewModel.isInputIsValid(
            name = binding.editCocktailName.text.toString(),
            ingredients = binding.editCocktailIngredients.text.toString()
        )
    }

    private fun hideKeyboard() {
        val inputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.scrollView.windowToken, 0)
    }

    private fun showErrorMessage(view: TextInputEditText) {

        if (view.text?.isBlank() == true) {
            when (view) {
                binding.editCocktailName -> binding.layoutCocktailName.error =
                    getString(R.string.add_title)

                else -> binding.layoutCocktailIngredients.error = getString(R.string.add_title)
            }
            binding.scrollView.smoothScrollTo(0, 0)
            hideKeyboard()
        }
    }

    private fun clearErrorMessage(view: TextInputEditText) {

        view.addTextChangedListener {
            if (it?.isNotBlank() == true) {
                when (view) {
                    binding.editCocktailName -> binding.layoutCocktailName.error = null
                    else -> binding.layoutCocktailIngredients.error = null
                }
            }
        }
    }

    private fun bindViews(cocktail: Cocktail) {

        binding.apply {
            editCocktailName.setText(cocktail.name, TextView.BufferType.SPANNABLE)
            editCocktailDescription.setText(cocktail.description, TextView.BufferType.SPANNABLE)
            editCocktailIngredients.setText(cocktail.ingredients, TextView.BufferType.SPANNABLE)
            editCocktailRecipe.setText(cocktail.recipe)

            var requestOptions = RequestOptions()
            requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(54))

            Glide.with(requireContext())
                .load(cocktail.imageSrc)
                .apply(requestOptions)
                .into(imageButton)
        }
        uri = cocktail.imageSrc
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ID = "id"
    }

    private fun saveCocktail(cocktailId: Int) {

        if (isInputValid()) {

            if (cocktailId > 0) {
                viewModel.editCocktail(
                    id = cocktailId,
                    name = binding.editCocktailName.text.toString(),
                    description = binding.editCocktailDescription.text.toString(),
                    ingredients = binding.editCocktailIngredients.text.toString(),
                    recipe = binding.editCocktailRecipe.text.toString(),
                    uri = uri
                )

                cocktail = Cocktail(
                    id = cocktailId,
                    name = binding.editCocktailName.text.toString(),
                    description = binding.editCocktailDescription.text.toString(),
                    ingredients = binding.editCocktailIngredients.text.toString(),
                    recipe = binding.editCocktailRecipe.text.toString(),
                    imageSrc = uri
                )

                val action =
                    AddCocktailFragmentDirections.actionAddCocktailFragmentToDetailsFragment(cocktail)
                findNavController().navigate(action)

            } else {
                viewModel.addNewCocktail(
                    name = binding.editCocktailName.text.toString(),
                    description = binding.editCocktailDescription.text.toString(),
                    ingredients = binding.editCocktailIngredients.text.toString(),
                    recipe = binding.editCocktailRecipe.text.toString(),
                    uri = uri
                )
                val action = AddCocktailFragmentDirections.actionAddCocktailFragmentToCocktailsFragment()
                findNavController().navigate(action)
            }


        } else {
            showErrorMessage(binding.editCocktailName)
            showErrorMessage(binding.editCocktailIngredients)

        }

    }

}