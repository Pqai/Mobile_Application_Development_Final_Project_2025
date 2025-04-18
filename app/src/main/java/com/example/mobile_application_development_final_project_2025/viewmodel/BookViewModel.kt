package com.example.mobile_application_development_final_project_2025.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_application_development_final_project_2025.data.Book
import com.example.mobile_application_development_final_project_2025.network.LibraryApi
import com.example.mobile_application_development_final_project_2025.network.LibraryApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val api: LibraryApi
): ViewModel(){
    private val _uiState = MutableStateFlow<BookUiState>(BookUiState.Loading)
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val uiState: StateFlow<BookUiState> = _uiState.asStateFlow()
    val books: StateFlow<List<Book>> = _books.asStateFlow()
    //

    fun loadBooks(query: String = ""){
        viewModelScope.launch {
            _uiState.value = BookUiState.Loading
            try {
                val response = api.searchBooks(query)
                _books.value = response.docs.map { doc ->
                    Book(
                        key = doc.key,
                        title = doc.title,
                        author_name = doc.author_name,
                        cover_i = doc.cover_i
                    )
                }
                _uiState.value = BookUiState.Success
            } catch (e: Exception) {
                _uiState.value = BookUiState.Error("Failed to load books ${e.localizedMessage ?: "Unknown error"}")
            }
        }
    }

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
        }
    }

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
