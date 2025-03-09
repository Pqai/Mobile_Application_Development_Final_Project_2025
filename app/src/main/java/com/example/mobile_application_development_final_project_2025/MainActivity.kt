package com.example.mobile_application_development_final_project_2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_application_development_final_project_2025.data.Comment
import com.example.mobile_application_development_final_project_2025.ui.theme.Mobile_Application_Development_Final_Project_2025Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookItApp()
        }
    }
}

@Composable
fun BookItApp() {
//where you put every function to make the complete app
}

/*@Composable
fun HomePage() {
                    //This has been moved to HomeScreen.kt delete later
    BookDisplay()
}*/

@Composable
fun BookPreview(){

}

@Composable
fun BookPage(){
    //the code for the books own page displaying title, description, ratings, comment section

}

@Composable
fun YourListUI(){
    //Changing how the book list looks

}

@Composable
fun YourListFunctions(){
    //code to make the list work
    //adding and removing books from your list by pressing a bookmark button
    //or on the books page bookmark/ unbookmark button
}

@Composable
fun BookItTopBar(){
    //The top bar of the app where logo, search bar and profile button go

    SearchBar()
}

@Composable
fun SearchBar(){
    //Searchbar to search by title, author ratings etc
    //Contains the button to your profile and depending on page a search button or a bookmark button
}

@Composable
fun BookDisplay(){
    //how the books will appear in the app showing a glimpse of the cover title author ratings and th general layout when searching through books like amazon
}

/*@Composable
fun BookDetailPage(){
    //The page that appears when you click on a book that shows the full cover of the book, author description and a button to bookmark or unbookmark the book and see the comment section below
    //This has been moved to BookDetailPage.kt
    CommentsSection()
}*/

@Composable
fun BookmarkButtonFunction(){
    //The bookmarks functionality of adding or removing the book from your list
}

@Composable
fun BookmarkButton(){
    //the bookmarks ui
}

@Composable
fun AlternateBookmarkButton(){
    //the bookmark ui specifically for the bookdetailpage that is larger
}

@Composable
fun CommentsSection(){
    //the place where you can view others comments or
}

@Composable
fun CommentUi(){
    Card(){
        Column() {
            ProfileIcon()
            Text(/*user name*/)
            Text(/*actual comment*/)
        }
    }
}

@Composable
fun CommentFunctions(){
    //make code to create delete and edit your own comments
}

@Composable
fun CommentDelete(){

}

@Composable
fun CommentEdit(){

}

@Composable
fun DataBookRatingUi(){
    //display the  books ratings
}

@Composable
fun AdminCommentFunctions(){
    //make code to delete any comments but not ale to edit their comments
}

@Composable
fun LogInFunction(){

}

/*@Composable
fun LoginInPage(){
                 //Moved to LoginPage.kt

}*/

@Composable
fun LogOutFunction(){

}

@Composable
fun SignUpFunction(){

}

/*@Composable
fun SignUpPage(){
                //Moved to SignupPae.kt
}*/

@Composable
fun ProfileIcon(){

}

@Composable
fun ProfileIconUI(){

}

@Composable
fun ProfileIconFunctions(){

}

/*@Composable
fun ProfilePage(){
                    //Moved to ProfilePage.kt
}*/


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mobile_Application_Development_Final_Project_2025Theme {
        BookItApp()
    }
}