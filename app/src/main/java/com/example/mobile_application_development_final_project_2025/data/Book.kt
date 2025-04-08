package com.example.mobile_application_development_final_project_2025.data

data class Book(
    val id: String,
    val title: String,
    val author: List<String>,
    val rating: Double,
    val cover: Int
)