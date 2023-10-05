package com.example.cocktailroomkoin.data.network

import retrofit2.http.GET

interface CocktailApi {
    @GET("v1/1/random.php")
    suspend fun getCocktail(): CocktailsResponse

}