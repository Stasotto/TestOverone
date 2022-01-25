package com.example.domain.usecase

import com.example.domain.repository.Repository

class DeleteAllFromDBUseCase(private val repository: Repository) {

    suspend fun execute() {
        repository.deleteFromDB()
    }
}