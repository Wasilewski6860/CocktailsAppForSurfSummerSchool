package com.example.cocktailroomkoin.presentation.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cocktailroomkoin.R
import com.example.cocktailroomkoin.presentation.cocktails.CocktailsFragmentDirections

class SplashFragment : Fragment() {



    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        Toast.makeText(requireContext(),"Splash",Toast.LENGTH_SHORT).show()
        Handler().postDelayed({

            openMainScreen()

        }, 3000)
    }

    private fun openMainScreen() {
        val action = SplashFragmentDirections.actionSplashFragmentToCocktailsFragment()
        findNavController().navigate(action)
    }

}