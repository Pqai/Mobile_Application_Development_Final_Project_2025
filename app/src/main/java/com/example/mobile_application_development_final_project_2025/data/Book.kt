package com.example.mobile_application_development_final_project_2025.data

data class Book(
    val key: String,
    val title: String,
    val author_name: List<String>?,
    /*val rating: Double,*/
    val cover_i: Int?,
){
    val cleanId: String
        get() = key.removePrefix("/works/")
}