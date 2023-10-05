package com.example.cocktailroomkoin.di

import com.example.cocktailroomkoin.presentation.add.AddCocktailViewModel
import com.example.cocktailroomkoin.presentation.cocktails.CocktailsViewModel
import com.example.cocktailroomkoin.presentation.details.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<CocktailsViewModel> {
        CocktailsViewModel(
            getAllCocktailsUseCase = get()
        )
    }

    viewModel<AddCocktailViewModel> {
        AddCocktailViewModel(
            getCocktailUseCase = get(),
            addNewCocktailUseCase = get(),
            editCocktailUseCase = get(),
            getNetworkCocktailUseCase = get()
        )
    }

    viewModel<DetailsViewModel> { DetailsViewModel(deleteCocktailUseCase = get()) }
}