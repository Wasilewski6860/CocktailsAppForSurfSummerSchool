package com.example.cocktailroomkoin.domain.use_cases

import com.example.cocktailroomkoin.domain.models.Cocktail
import com.example.cocktailroomkoin.domain.repositories.CocktailRepository

class GetAllCocktailsUseCase(private val storageRepository: CocktailRepository)  {

    suspend fun execute(): List<Cocktail> = storageRepository.getAllCocktails()
}