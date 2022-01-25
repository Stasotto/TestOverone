package com.example.testoverone.presentation.di

import com.example.testoverone.presentation.viewmodel.FilterActivityViewModel
import com.example.testoverone.presentation.viewmodel.MapActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        FilterActivityViewModel(
            useCase = get(),
            getAllDataFromDB = get(),
            deletePointFromDB = get(),
            savePointToDb = get()
        )
    }

    viewModel {
        MapActivityViewModel(deleteAllFromDBUseCase = get())
    }
}