package com.example.testoverone.presentation.di

import com.example.data.RepositoryImpl
import com.example.domain.repository.Repository
import com.example.domain.usecase.DeleteAllFromDBUseCase
import com.example.domain.usecase.GetAllPointsFromDBUseCase
import com.example.domain.usecase.GetDataFromJsonUseCase
import com.example.domain.usecase.SavePointToDBUseCase
import org.koin.dsl.module

val domainModule = module {

    single<Repository> {
        RepositoryImpl(
            assetsStorage = get(),
            roomStorage = get()
        )

    }
    single {
        GetDataFromJsonUseCase(repository = get())
    }

    single {
        SavePointToDBUseCase(repository = get())
    }

    single {
        DeleteAllFromDBUseCase(repository = get())
    }

    single {
        GetAllPointsFromDBUseCase(repository = get())
    }
}