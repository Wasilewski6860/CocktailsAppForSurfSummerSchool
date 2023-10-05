package com.example.cocktailroomkoin.data.db.impl

import com.example.cocktailroomkoin.data.db.CocktailStorage
import com.example.cocktailroomkoin.data.db.CocktailsDatabase
import com.example.cocktailroomkoin.data.db.dto.CocktailDto
import com.example.cocktailroomkoin.data.network.CocktailApi
import com.example.cocktailroomkoin.data.network.CocktailNetwork


class CocktailStorageImpl(cocktailsDatabase: CocktailsDatabase,private val cocktailsApi: CocktailApi): CocktailStorage {

    private val cocktailsDao = cocktailsDatabase.cocktailDao()

    override suspend fun addNewCocktail(cocktailDto: CocktailDto) {
        cocktailsDao.addNewItem(cocktailDto)
    }

    override suspend fun deleteCocktail(cocktailDto: CocktailDto) {
        cocktailsDao.deleteItem(cocktailDto)
    }

    override suspend fun getAllCocktails(): List<CocktailDto>  = cocktailsDao.getAllCocktails()

    override suspend fun getCocktail(id: Int): CocktailDto = cocktailsDao.getCocktail(id)

    override suspend fun editCocktail(cocktailDto: CocktailDto) {
        cocktailsDao.editItem(cocktailDto)
    }

    override suspend fun getCocktailNetwork(): CocktailNetwork  {
        var cocktail = cocktailsApi.getCocktail()
        return cocktail.drinks.get(0)
    }
}