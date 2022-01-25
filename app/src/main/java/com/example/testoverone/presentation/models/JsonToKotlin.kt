package com.example.testoverone.presentation.models

import com.example.data.models.Pin

data class JsonToKotlin(
    val pins: List<Pin>,
    val services: List<String>
)