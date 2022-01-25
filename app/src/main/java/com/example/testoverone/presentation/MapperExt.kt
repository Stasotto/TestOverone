package com.example.testoverone.presentation

import com.example.domain.models.PointDomain
import com.example.testoverone.presentation.models.Point

fun PointDomain.toPoint() = Point(
    id = id,
    lat = lat,
    lan = lan,
    isChecked = isChecked
)

fun Point.toPointDomain() = PointDomain(
    id = id,
    lat = lat,
    lan = lan,
    isChecked = true


)