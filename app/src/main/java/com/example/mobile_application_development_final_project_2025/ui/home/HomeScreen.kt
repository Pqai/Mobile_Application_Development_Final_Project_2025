package com.example.mobile_application_development_final_project_2025.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mobile_application_development_final_project_2025.BookItTopBar
import com.example.mobile_application_development_final_project_2025.R
import com.example.mobile_application_development_final_project_2025.data.Book
import com.example.mobile_application_development_final_project_2025.ui.components.ErrorScreen
import com.example.mobile_application_development_final_project_2025.ui.components.FullScreenLoading
import com.example.mobile_application_development_final_project_2025.viewmodel.BookUiState
import com.example.mobile_application_development_final_project_2025.viewmodel.BookViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: BookViewModel = hiltViewModel()
    ){

    val uiState by viewModel.uiState.collectAsState()
    val books by viewModel.books.collectAsState()

    //when you search for a book the logo disappears and the search bar gets pushed up to the top
    Scaffold(
        topBar = { BookItTopBar() },
        content = {padding ->
            when (uiState){
                is BookUiState.Loading -> FullScreenLoading(modifier = Modifier.padding(padding))

                is BookUiState.Error -> ErrorScreen(
                    message = (uiState as BookUiState.Error).message,
                    modifier = Modifier.padding(padding),
                    onRetry = {viewModel.loadBooks()}
                )
                is BookUiState.Success -> {
                    if (books.isEmpty()){
                        EmptyBookList(modifier = Modifier.padding(padding))
                    } else {
                        BookList(
                            books = books,
                            onBookClick = { bookId ->
                                navController.navigate("book_detail/$bookId")
                            },
                            modifier = Modifier.padding(padding),
                            padding = padding,
                            navController = NavController
                        )
                    }
                }
            }
            //BookList(padding = padding, navController = navController)
        }
    )
    //BookDisplay()
}

@Composable
fun EmptyBookList(modifier: Modifier = Modifier){
    Box(
        modifer = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("No books found", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun BookList(
    books: List<Book>,
    onBookClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    padding: PaddingValues,
    navController: NavController.Companion
){
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(books) { book ->
            BookListItem(
                book = book,
                onClick = { navController.navigate("book_detail/${book.key}")}
            )
        }
    }
}

@Composable
fun BookListItem(
    book: Book,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            val imageModel = book.cover_i?.let { coverId ->
                "https://covers.openlibrary.org/b/id/${coverId}-M.jpg"
            } ?: R.drawable.ic_book_placeholder

            AsyncImage(
                model = imageModel,
                contentDescription = "Book Cover",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop,
            )

            Spacer(Modifier.width(16.dp))

            Column(Modifier.weight(1f)){
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                book.author_name?.takeIf { it.isNotEmpty() }?.let { authors ->
                    Text(
                        text = "By ${authors.joinToString()}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    ) ?: Text(
                        text = "Unknown author",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(aplha = 0.5f)
                    )

                }
            }
        }
    }
}