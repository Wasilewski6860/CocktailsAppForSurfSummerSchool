package com.example.cocktailroomkoin.data.db

import com.example.cocktailroomkoin.data.db.dto.CocktailDto


interface CocktailStorage {

    suspend fun addNewCocktail(cocktailDto: CocktailDto)
    suspend fun deleteCocktail(cocktailDto: CocktailDto)
    suspend fun getAllCocktails(): List<CocktailDto>
    suspend fun getCocktail(id: Int): CocktailDto
    suspend fun editCocktail(cocktailDto: CocktailDto)
}