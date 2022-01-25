package com.example.testoverone.presentation

import android.app.Application
import com.example.data.di.dataModule
import com.example.testoverone.presentation.di.domainModule
import com.example.testoverone.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestOveroneApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@TestOveroneApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}