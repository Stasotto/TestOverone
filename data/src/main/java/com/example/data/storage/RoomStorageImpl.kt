package com.example.data.storage

import com.example.data.models.PointEntity
import com.example.data.storage.room.Dao

class RoomStorageImpl(private val dao: Dao) : RoomStorage {

    override suspend fun getAll(): List<PointEntity> {
        return dao.getAll()
    }

    override suspend fun delete() {
        dao.delete()
    }

    override suspend fun save(point: PointEntity) {
        dao.save(point)
    }
}