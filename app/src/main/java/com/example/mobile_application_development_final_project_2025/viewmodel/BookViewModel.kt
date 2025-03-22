package com.example.mobile_application_development_final_project_2025.viewmodel

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_application_development_final_project_2025.LibraryApi
import kotlinx.coroutines.launch


private fun getBooksPhotos() {
    viewModelScope.launch {
        val listResult = LibraryApi.retrofitService.getPhotos()
    }
}

