package com.example.domain.usecase

import com.example.domain.models.PointDomain
import com.example.domain.repository.Repository

class GetAllPointsFromDBUseCase(private val repository: Repository) {

    suspend fun execute(): List<PointDomain> {
        return repository.getAllFromDB()
    }
}