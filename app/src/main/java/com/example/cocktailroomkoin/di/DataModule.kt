package com.example.cocktailroomkoin.di

import com.example.cocktailroomkoin.data.db.CocktailStorage
import com.example.cocktailroomkoin.data.db.CocktailsDatabase
import com.example.cocktailroomkoin.data.db.impl.CocktailStorageImpl
import com.example.cocktailroomkoin.data.network.CocktailApi
import com.example.cocktailroomkoin.data.repositories.CocktailRepositoryImpl
import com.example.cocktailroomkoin.domain.repositories.CocktailRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://thecocktaildb.com/api/json/"

val dataModule = module {

    single<CocktailStorage> { CocktailStorageImpl(cocktailsDatabase = get(), cocktailsApi = get()) }

    single<CocktailRepository> { CocktailRepositoryImpl(cocktailStorage = get()) }

    single<CocktailApi> {
        Retrofit.Builder()
            .baseUrl(BASE_URL).client(
                OkHttpClient.Builder()
                .build())
            .addConverterFactory(GsonConverterFactory.create()).build().create(CocktailApi::class.java)
    }

    single<CocktailsDatabase> { CocktailsDatabase.getDataBase(context = get()) }
}