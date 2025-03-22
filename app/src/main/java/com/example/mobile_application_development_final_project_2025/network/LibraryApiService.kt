package com.example.mobile_application_development_final_project_2025.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

/*object LibraryApiService{
    private const val BASE_URL =
        "https://openlibrary.org"
}*/

private const val BASE_URL =
    "https://openlibrary.org"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface LibraryApiService {
    @GET ("")//finish this later
    suspend fun getPhotos() : String
}
