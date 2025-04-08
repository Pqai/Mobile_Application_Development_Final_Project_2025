package com.example.mobile_application_development_final_project_2025.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_application_development_final_project_2025.data.Book
import com.example.mobile_application_development_final_project_2025.network.LibraryApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel : ViewModel(){
    private val _uiState = MutableStateFlow<BookUiState>(BookUiState.Loading)
    val uiState: StateFlow<BookUiState> = _uiState
    //

    fun loadBookDetails(bookId: String){
        viewModelScope.launch {
            _uiState.value = BookUiState.Loading

            try {
              val response = LibraryApiService.api.searchBooks(bookId)
              val book = response.docs.firstOrNull()
                  ?: throw Exception("Book not found")

                _uiState.value = BookUiState.Success(book)
            } catch (e: Exception){
                _uiState.value = BookUiState.Error(
                    message = "Failed to load book: ${e.message ?: "Unknown error"}"
                )
            }
            //bookDetails.value = LibraryApiService.api.getBookDetails(bookId)
        }
    }
    //private val _bookDetails = mutableStateOf<Book?>(null)
    //val bookDetails: StateFlow<Book?> = _bookDetails
    /*fun loadBookDetails(bookId: String){
        viewModelScope.launch {
            bookDetails.value = LibraryApiService.api.getBookDetails(bookId)
        }
    }*/

    fun searchBooks(query: String){
        viewModelScope.launch{
            try {
                val response = LibraryApiService.api.searchBooks(query)
            }catch(e: Exception){

            }
        }
    }
}


/*private fun getBooksPhotos() {
    viewModelScope.launch {
        val listResult = LibraryApi.retrofitService.getPhotos()
    }
}
*/
