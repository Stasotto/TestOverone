package com.example.domain.repository

import com.example.domain.models.PointDomain

interface Repository {

    suspend fun getAllData(): List<PointDomain>

    suspend fun getAllFromDB(): List<PointDomain>

    suspend fun deleteFromDB()

    suspend fun saveInDB(pointDomain: PointDomain)
}