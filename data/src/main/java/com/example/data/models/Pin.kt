package com.example.data.models

import com.example.data.models.Coordinates

data class Pin(
    val coordinates: Coordinates,
    var id: Int,
    val redundantField: String,
    val service: String
)