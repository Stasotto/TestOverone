package com.example.data

import com.example.data.models.Pin
import com.example.data.models.PointEntity
import com.example.domain.models.PointDomain

fun Pin.toPointEntity() = PointEntity(
    index = id,
    lat = coordinates.lat,
    lan = coordinates.lng
)

fun PointEntity.toPointDomain() = PointDomain(
    id = index,
    lat = lat,
    lan = lan,
    isChecked = isChecked
)

fun PointDomain.toPointEntity() = PointEntity(
    index = id,
    lat = lat,
    lan = lan,
    isChecked = isChecked
)