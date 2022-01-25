package com.example.data.storage

import com.example.data.models.JsonToKotlin

interface AssetsStorage {

    suspend fun getAll(): JsonToKotlin
}