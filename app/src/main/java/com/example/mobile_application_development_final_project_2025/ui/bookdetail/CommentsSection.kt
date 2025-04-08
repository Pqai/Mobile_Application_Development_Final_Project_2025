package com.example.mobile_application_development_final_project_2025.ui.bookdetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile_application_development_final_project_2025.R
import com.example.mobile_application_development_final_project_2025.data.Comment

@Composable
fun CommentsSection(
    comments: List<Comment>,
    modifier: Modifier = Modifier
){
    //the place where you can view others comments or
    Card(
        modifier = modifier.fillMaxSize(),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        
    }

    LazyColumn {
        items(placeholderComments){ comment ->
            CommentItem(comment = comment)
        }
    }
}

@Composable
fun CommentItem(comment: Comment){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        //Profile Picture
        AsyncImage(
            model = comment.profilePicture ?: "https://placeholdeer",
            contentDesription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        /*Image(
            painter = painterResource(id = R.drawable.profile_placeholder),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(8.dp))*/

        //Username and Comment
        Column {
            Text(
                text = comment.user,
                fontWeight =  FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
                //style = make the themes and colors later
                //color = something
            )
            Text(
                text = comment.text,
                style = MaterialTheme.typography.bodyMedium
                //style = make the themes and colors later
                //color = something
            )
        }
    }
}

private fun getSampleComments(): List<Comment>{
    return listOf(
        Comment(
            id = "1",
            user = "BookLover42",
            text = "The book is soo good",
            profilePicture = "https://randomuser.me/api/portraits/women/43.jpg"
        ),
        Comment(
            id = "2",
            user = "BURHSAUIHU",
            text = "The book is soo gooddsadasdadasdw",
            profilePicture = "https://randomuser.me/api/portraits/men/32.jpg"
        )
    )
}

@Preview
@Composable
fun CommentsSectionPreview(){
    MaterialTheme{
        CommentsSection(comments = getSampleComments())
    }
}