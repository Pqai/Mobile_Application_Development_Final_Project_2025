package com.example.mobile_application_development_final_project_2025.network

import com.example.mobile_application_development_final_project_2025.data.BookResponse
//import com.example.mobile_application_development_final_project_2025.network.LibraryApiService
import retrofit2.http.GET
import retrofit2.http.Query

interface LibraryApi {
    @GET("search.json")//finish this later
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("page") page: Int = 1
    ): BookResponse
    //@Query getBooks() query : String,
}