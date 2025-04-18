package com.example.mobile_application_development_final_project_2025.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobile_application_development_final_project_2025.ui.bookdetail.BookDetailPage
import com.example.mobile_application_development_final_project_2025.ui.components.ErrorScreen
import com.example.mobile_application_development_final_project_2025.ui.components.FullScreenLoading
import com.example.mobile_application_development_final_project_2025.ui.home.HomeScreen
import com.example.mobile_application_development_final_project_2025.viewmodel.BookUiState
import com.example.mobile_application_development_final_project_2025.viewmodel.BookViewModel

@Composable
fun NavGraph(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){

            val viewModel: BookViewModel = hiltViewModel()
            val books by viewModel.books.collectAsState()
            HomeScreen(onBookClick = {navController.navigate("book_detail/$it")})
        }

        composable("book_detail/{bookId}"){navBackStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId") ?: ""
            val viewModel: BookViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()

            LaunchedEffect(bookId) {
                viewModel.loadBookDetails(bookId)
            }

            when (uiState){
                is BookUiState.Loading -> FullScreenLoading()
                is BookUiState.Error -> ErrorScreen((uiState as BookUiState.Error).message) { viewModel.loadBooks() }
                is BookUiState.Success -> BookDetailPage(
                    book = (uiState as BookUiState.Success).book,
                    onBackClick =  {navController.popBackStack() }
                )
            }
        }
    }
}