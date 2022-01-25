package com.example.testoverone.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.DeleteAllFromDBUseCase
import kotlinx.coroutines.launch

class MapActivityViewModel(
    private val deleteAllFromDBUseCase: DeleteAllFromDBUseCase
) : ViewModel() {
    
    fun deletePoint() {
        viewModelScope.launch {
            deleteAllFromDBUseCase.execute()
        }
    }
}