package com.example.cocktailroomkoin.domain.repositories

import com.example.cocktailroomkoin.domain.models.Cocktail


interface CocktailRepository {

    suspend fun addNewCocktail(cocktail: Cocktail)
    suspend fun deleteCocktail(cocktail: Cocktail)
    suspend fun getAllCocktails(): List<Cocktail>
    suspend fun getCocktail(id: Int): Cocktail
    suspend fun editCocktail(cocktail: Cocktail)
}