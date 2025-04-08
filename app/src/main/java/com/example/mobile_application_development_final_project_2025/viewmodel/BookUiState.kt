package com.example.mobile_application_development_final_project_2025.viewmodel

import com.example.mobile_application_development_final_project_2025.data.Book

sealed class BookUiState{
    object Loading: BookUiState()
    data class Success(val book: Book) :BookUiState()
    data class Error(val message: String) : BookUiState()
}