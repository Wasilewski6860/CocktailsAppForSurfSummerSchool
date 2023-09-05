package com.example.cocktailroomkoin.data.repositories

import com.example.cocktailroomkoin.data.db.CocktailStorage
import com.example.cocktailroomkoin.data.db.dto.CocktailDto
import com.example.cocktailroomkoin.domain.models.Cocktail
import com.example.cocktailroomkoin.domain.repositories.CocktailRepository

class CocktailRepositoryImpl(private val cocktailStorage: CocktailStorage) : CocktailRepository {


    override suspend fun addNewCocktail(cocktail: Cocktail) {
        val mappedCocktail = mapToData(cocktail)
        cocktailStorage.addNewCocktail(mappedCocktail)
    }

    override suspend fun deleteCocktail(cocktail: Cocktail) {
        val mappedCocktail = mapToData(cocktail)
        cocktailStorage.deleteCocktail(mappedCocktail)
    }

    override suspend fun getAllCocktails(): List<Cocktail> {
        val resultFromData = cocktailStorage.getAllCocktails()
        return resultFromData.map { cocktailDto ->
            mapToDomain(cocktailDto)
        }
    }

    override suspend fun getCocktail(id: Int): Cocktail {
        val resultFromData = cocktailStorage.getCocktail(id)
        return mapToDomain(resultFromData)
    }

    override suspend fun editCocktail(cocktail: Cocktail) {
        val mappedCocktail = mapToData(cocktail)
        cocktailStorage.editCocktail(mappedCocktail)
    }

    private fun mapToData(cocktail: Cocktail): CocktailDto {
        with(cocktail) {
            return CocktailDto(
                id = id,
                imageSrc = imageSrc,
                name = name,
                description = description,
                recipe = recipe,
                ingredients = ingredients,
            )
        }
    }

    private fun mapToDomain(cocktailDto: CocktailDto): Cocktail {
        with(cocktailDto) {
            return Cocktail(
                id = id,
                imageSrc = imageSrc,
                name = name,
                description = description,
                recipe = recipe,
                ingredients = ingredients,
            )
        }
    }

}