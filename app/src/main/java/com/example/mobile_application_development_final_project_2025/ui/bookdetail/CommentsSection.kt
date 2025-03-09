package com.example.mobile_application_development_final_project_2025.ui.bookdetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mobile_application_development_final_project_2025.R
import com.example.mobile_application_development_final_project_2025.data.Comment

@Composable
fun CommentsSection(){
    //the place where you can view others comments or
    val placeholderComments = listOf(
        Comment(
            id ="1",
            text  = "Comments Example!",
            user = "User12345",
            profilePicture = "fillLater"
            ),
        Comment(
            id ="2",
            text  = "Comments!",
            user = "User12",
            profilePicture = "fillLater"
        ),
    )

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
            .padding(8.dp)
    ){
        //Profile Picture
        Image(
            painter = painterResource(id = R.drawable.profile_placeholder),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(8.dp))

        //Username and Comment
        Column {
            Text(
                text = comment.user,
                //style = make the themes and colors later
                //color = something
            )
            Text(
                text = comment.text,
                //style = make the themes and colors later
                //color = something
            )
        }
    }
}