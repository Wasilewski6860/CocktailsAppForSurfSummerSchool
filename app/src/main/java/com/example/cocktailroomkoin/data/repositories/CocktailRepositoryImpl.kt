package com.example.cocktailroomkoin.data.repositories

import com.example.cocktailroomkoin.data.db.CocktailStorage
import com.example.cocktailroomkoin.data.db.dto.CocktailDto
import com.example.cocktailroomkoin.data.network.CocktailNetwork
import com.example.cocktailroomkoin.data.network.ingridientsToString
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

    override suspend fun getCocktailNetwork(): Cocktail =mapToDomain(cocktailStorage.getCocktailNetwork())


    private fun mapToDomain(cocktailNetwork: CocktailNetwork) : Cocktail{
        with(cocktailNetwork){
            return Cocktail(
                id = idDrink.toInt() ?: 0,
                imageSrc = strDrinkThumb,
                name = strDrink,
                description = strAlcoholic,
                recipe = strInstructions.toString() ?: "" ,
                ingredients = cocktailNetwork.ingridientsToString()
//                        (strIngredient1.toString() ?: "") + (strIngredient2.toString() ?: "")
//                        + (strIngredient3.toString() ?: "") + (strIngredient4.toString() ?: "")
//                        + (strIngredient5.toString() ?: "") + (strIngredient6.toString() ?: "")
//                        + (strIngredient7.toString() ?: "") + (strIngredient8.toString() ?: "")
//                        + (strIngredient9.toString() ?: "") + (strIngredient10.toString() ?: "")
//                        + (strIngredient11.toString() ?: "") + (strIngredient12.toString() ?: "")
//                        + (strIngredient13.toString() ?: "") + (strIngredient14.toString() ?: "")
//                        + (strIngredient15.toString() ?: "")
            )
        }
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