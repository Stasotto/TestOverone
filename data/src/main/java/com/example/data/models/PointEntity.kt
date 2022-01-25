package com.example.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "points")
data class PointEntity(
    @ColumnInfo(name = "index")
    val index: Int,
    @ColumnInfo(name = "lat")
    val lat: Double,
    @ColumnInfo(name = "lan")
    val lan: Double,
    @ColumnInfo(name = "isChecked")
    val isChecked: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

