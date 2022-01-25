package com.example.domain.usecase

import com.example.domain.models.PointDomain
import com.example.domain.repository.Repository

class GetDataFromJsonUseCase(private val repository: Repository) {

    suspend fun execute(): List<PointDomain> {
        return repository.getAllData()
    }
}