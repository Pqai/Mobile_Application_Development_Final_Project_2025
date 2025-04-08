package com.example.mobile_application_development_final_project_2025.network

import com.example.mobile_application_development_final_project_2025.data.BookResponse
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object LibraryApiService{
    private const val BASE_URL = "https://openlibrary.org"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    val api: :LibraryApi by lazy{ retrofit.create(LibraryApi::class.java)}
}
