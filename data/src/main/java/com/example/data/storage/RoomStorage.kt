package com.example.data.storage

import com.example.data.models.PointEntity

interface RoomStorage {

    suspend fun getAll(): List<PointEntity>

    suspend fun delete()

    suspend fun save(point: PointEntity)
}