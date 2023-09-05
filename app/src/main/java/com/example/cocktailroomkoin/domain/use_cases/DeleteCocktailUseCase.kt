package com.example.cocktailroomkoin.domain.use_cases

import com.example.cocktailroomkoin.domain.models.Cocktail
import com.example.cocktailroomkoin.domain.repositories.CocktailRepository

class DeleteCocktailUseCase(private val storageRepository: CocktailRepository)  {

    suspend fun execute(cocktail: Cocktail) = storageRepository.deleteCocktail(cocktail)
}