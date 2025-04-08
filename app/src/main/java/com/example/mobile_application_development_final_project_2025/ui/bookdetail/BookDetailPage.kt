package com.example.mobile_application_development_final_project_2025.ui.bookdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_application_development_final_project_2025.ui.bookdetail.CommentsSection
import com.example.mobile_application_development_final_project_2025.data.Book

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailPage(
    book: Book,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
){
    //The page that appears when you click on a book that shows the full cover of the book, author description and a button to bookmark or unbookmark the book and see the comment section below
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Book Details")},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ){
        paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ){
            val coverUrl = "https://covers.openlibrary.org/b/id/${book.cover}-L.jpp"

            Image(
                painter = rememberImagePainter(coverUrl),
                contentDescription = "Book Cover",
                modifier = Modifier
                    .height(300.dp)
                    .fillMaxSize()
                    .align(Alignment.Start),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(24.dp))

            //book title
            Text(
                text = book.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            //author names
            book.author_name?.let { authors ->
                Text(
                    text = "By ${authors.joinToString()}",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            //description
            Text(
                text =
            )

            CommentsSection()
        }

    }
}

@Preview
@Composable
fun BookDetailPagePreview(){
    MaterialTheme{
        BookDetailPage(
            book = book(
                key = "",
                title = "",
                author_name = "",
                cover_i = 1234567
            ),
            onBackClick = {}
        )
    }
}