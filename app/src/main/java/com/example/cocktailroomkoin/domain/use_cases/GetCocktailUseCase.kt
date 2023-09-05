package com.example.cocktailroomkoin.domain.use_cases

import com.example.cocktailroomkoin.domain.models.Cocktail
import com.example.cocktailroomkoin.domain.repositories.CocktailRepository

class GetCocktailUseCase(private val storageRepository: CocktailRepository)  {

    suspend fun execute(id: Int): Cocktail = storageRepository.getCocktail(id)
}