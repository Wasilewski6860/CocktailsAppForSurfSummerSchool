package com.example.cocktailroomkoin.di

import com.example.cocktailroomkoin.domain.use_cases.AddNewCocktailUseCase
import com.example.cocktailroomkoin.domain.use_cases.DeleteCocktailUseCase
import com.example.cocktailroomkoin.domain.use_cases.EditCocktailUseCase
import com.example.cocktailroomkoin.domain.use_cases.GetAllCocktailsUseCase
import com.example.cocktailroomkoin.domain.use_cases.GetCocktailUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<AddNewCocktailUseCase> { AddNewCocktailUseCase(storageRepository = get()) }
    factory<DeleteCocktailUseCase> { DeleteCocktailUseCase(storageRepository = get()) }
    factory<EditCocktailUseCase> { EditCocktailUseCase(storageRepository = get()) }
    factory<GetAllCocktailsUseCase> { GetAllCocktailsUseCase(storageRepository = get()) }
    factory<GetCocktailUseCase> { GetCocktailUseCase(storageRepository = get()) }
}