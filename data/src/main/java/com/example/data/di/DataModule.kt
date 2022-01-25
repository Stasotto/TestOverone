package com.example.data.di

import androidx.room.Room
import com.example.data.storage.AssetsStorage
import com.example.data.storage.AssetsStorageImpl
import com.example.data.storage.RoomStorage
import com.example.data.storage.RoomStorageImpl
import com.example.data.storage.room.AppDatabase
import org.koin.dsl.module

val dataModule = module {

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "points"
        ).build()
    }
    single {
        get<AppDatabase>().getDao()

    }

    single<RoomStorage> {
        RoomStorageImpl(dao = get())

    }
    single<AssetsStorage> {
        AssetsStorageImpl(context = get())
    }
}