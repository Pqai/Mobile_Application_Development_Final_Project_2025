package com.example.mobile_application_development_final_project_2025.network

import com.example.mobile_application_development_final_project_2025.data.BookResponse
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import retrofit2.http.Query


/*object LibraryApiService{
    private const val BASE_URL =
        "https://openlibrary.org"
}*/

object LibraryApiService{
    private const val BASE_URL = "https://openlibrary.org"

    private val retrofit = RetroFit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
}

/*
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()*/

/*interface LibraryApi {
    @GET("search.json")//finish this later
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("page") page: Int = 1
    ): BookResponse
    //@Query getBooks() query : String,
}*/
