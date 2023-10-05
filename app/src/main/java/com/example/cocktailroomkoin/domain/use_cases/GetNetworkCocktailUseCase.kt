package com.example.cocktailroomkoin.domain.use_cases

import com.example.cocktailroomkoin.domain.models.Cocktail
import com.example.cocktailroomkoin.domain.repositories.CocktailRepository

class GetNetworkCocktailUseCase(private val cocktailRepository: CocktailRepository)  {

    suspend fun execute(): Cocktail = cocktailRepository.getCocktailNetwork()
}