package com.example.cocktailroomkoin.presentation.add

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailroomkoin.domain.models.Cocktail
import com.example.cocktailroomkoin.domain.use_cases.AddNewCocktailUseCase
import com.example.cocktailroomkoin.domain.use_cases.EditCocktailUseCase
import com.example.cocktailroomkoin.domain.use_cases.GetCocktailUseCase
import kotlinx.coroutines.launch

class AddCocktailViewModel(
    private val addNewCocktailUseCase: AddNewCocktailUseCase,
    private val editCocktailUseCase: EditCocktailUseCase,
    private val getCocktailUseCase: GetCocktailUseCase
) : ViewModel() {

    private val _cocktail = MutableLiveData<Cocktail>()
    val cocktail: LiveData<Cocktail> = _cocktail
    var uri : String = ""
    private fun insertNewCocktail(cocktail: Cocktail) {
        viewModelScope.launch {
            addNewCocktailUseCase.execute(cocktail)
        }
    }

    fun addNewCocktail(
        name: String,
        description: String,
        ingredients: String,
        recipe: String,
        uri : String
    ) {
        val newCocktail = Cocktail(
            id = 0,
            name = name,
            description = description,
            ingredients = ingredients,
            imageSrc = uri,
            recipe = recipe
        )
        insertNewCocktail(newCocktail)
    }

    fun isInputIsValid(
        name: String,
        ingredients: String,
    ) = (name.isNotBlank() && ingredients.isNotBlank())


    fun getCocktail(id: Int) {
        viewModelScope.launch {
            _cocktail.value = getCocktailUseCase.execute(id)
        }
    }

    private fun updateCocktail(cocktail: Cocktail) {
        viewModelScope.launch {
            editCocktailUseCase.execute(cocktail)
        }
    }

    fun editCocktail(
        id: Int,
        name: String,
        description: String,
        ingredients: String,
        recipe: String,
        uri : String
    ) {
        val editedCocktail = Cocktail(
            id = id,
            name = name,
            description = description,
            ingredients = ingredients,
            imageSrc = uri,
            recipe = recipe
        )
        updateCocktail(editedCocktail)
    }

    fun saveUri(it: Uri) {
        _cocktail.value

    }

}