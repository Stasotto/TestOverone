package com.example.domain.usecase

import com.example.domain.models.PointDomain
import com.example.domain.repository.Repository

class SavePointToDBUseCase(private val repository: Repository) {

    suspend fun execute(point: PointDomain) {
        repository.saveInDB(point)
    }
}