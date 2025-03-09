package com.example.mobile_application_development_final_project_2025.navigation

sealed class Screen(val route: String){
    object Home: Screen("home")
    object BookDetail: Screen("book_detail")
    object Login: Screen("login")
    object Profile: Screen("profile")
    object Signup: Screen("signup")

}