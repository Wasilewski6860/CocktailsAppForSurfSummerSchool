package com.example.cocktailroomkoin.di

import com.example.cocktailroomkoin.data.db.CocktailStorage
import com.example.cocktailroomkoin.data.db.CocktailsDatabase
import com.example.cocktailroomkoin.data.db.impl.CocktailStorageImpl
import com.example.cocktailroomkoin.data.repositories.CocktailRepositoryImpl
import com.example.cocktailroomkoin.domain.repositories.CocktailRepository
import org.koin.dsl.module

val dataModule = module {

    single<CocktailStorage> { CocktailStorageImpl(cocktailsDatabase = get()) }

    single<CocktailRepository> { CocktailRepositoryImpl(cocktailStorage = get()) }

    single<CocktailsDatabase> { CocktailsDatabase.getDataBase(context = get()) }
}