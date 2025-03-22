package com.example.mobile_application_development_final_project_2025

import com.example.mobile_application_development_final_project_2025.network.LibraryApiService
//import com.example.mobile_application_development_final_project_2025.network.LibraryApiService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object LibraryApi {
    val retrofitService: LibraryApiService by lazy {

        retrofit.create(LibraryApiService::class.java)

    }

}