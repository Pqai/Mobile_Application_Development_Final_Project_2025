package com.example.mobile_application_development_final_project_2025.data.di

import com.example.mobile_application_development_final_project_2025.network.LibraryApi
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import dagger.hilt.components.SingletonComponent
import dagger.hilt.InstallIn
import retrofit2.Retrofit



@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLibraryApi(): LibraryApi {
        return Retrofit.Builder()
            .baseUrl("https://openlibrary.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LibraryApi::class.java)
    }
}