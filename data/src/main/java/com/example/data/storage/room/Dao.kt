package com.example.data.storage.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data.models.PointEntity

@Dao
interface Dao {

    @Query("SELECT * FROM points")
    fun getAll(): List<PointEntity>

    @Query("DELETE FROM points")
    fun delete()

    @Insert
    fun save(point: PointEntity)
}