package com.example.cocktailroomkoin.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailroomkoin.domain.models.Cocktail
import com.example.cocktailroomkoin.domain.use_cases.DeleteCocktailUseCase
import kotlinx.coroutines.launch

class DetailsViewModel(

    private val deleteCocktailUseCase: DeleteCocktailUseCase

): ViewModel() {


    fun deleteCocktail(cocktail: Cocktail){
        viewModelScope.launch {
            deleteCocktailUseCase.execute(cocktail)
        }
    }

}