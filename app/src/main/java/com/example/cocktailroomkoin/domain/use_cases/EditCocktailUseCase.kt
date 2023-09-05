package com.example.cocktailroomkoin.domain.use_cases

import com.example.cocktailroomkoin.domain.models.Cocktail
import com.example.cocktailroomkoin.domain.repositories.CocktailRepository

class EditCocktailUseCase(private val storageRepository: CocktailRepository)  {

    suspend fun execute(cocktail: Cocktail) = storageRepository.editCocktail(cocktail)
}