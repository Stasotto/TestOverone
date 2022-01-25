package com.example.domain.models

data class PointDomain(
    val id: Int,
    val lat: Double,
    val lan: Double,
    val isChecked: Boolean = false
)