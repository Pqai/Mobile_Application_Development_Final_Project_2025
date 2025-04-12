package com.example.mobile_application_development_final_project_2025.data.di

import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLibraryApi(): LibraryApi {

    }
}