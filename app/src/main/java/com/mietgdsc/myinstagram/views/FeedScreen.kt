package com.mietgdsc.myinstagram.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mietgdsc.myinstagram.R
import com.mietgdsc.myinstagram.data.DataSource
import com.mietgdsc.myinstagram.model.Users
import com.mietgdsc.myinstagram.ui.theme.MyInstagramTheme

@Composable
fun FeedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        val lst = DataSource().loadstories()
        LazyColumn(modifier = Modifier.padding(1.dp)){
            item {
                LazyRow(){
                    items(lst){ u->
                        StoryCard(users = u)
                    }
                }
            }
            item { Divider() }
            items(lst){ u->
                PostCard(users = u)
            }
        }
    }
}

@Composable
fun StoryCard(users: Users){
    Box(contentAlignment = Alignment.TopCenter,
    modifier = Modifier.padding(8.dp)){
        Canvas(modifier = Modifier.size(70.dp)){
            drawCircle(
                brush = Brush.linearGradient(listOf(Color.Yellow, Color.Red, Color.Magenta)),
                style= Stroke(width = 15f)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = users.profilePic), contentDescription = users.username,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(
                    width = 3.dp,
                    color = Color.White,
                    shape = CircleShape
                ),
            contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = users.username, color = Color.DarkGray,
            fontSize = 12.sp)
        }
    }
}

@Composable
fun PostCard(users: Users){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = users.profilePic), contentDescription = users.username)
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text(text = users.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = users.location, fontSize = 12.sp, color = Color.DarkGray)
                }
            }


        }
        Image(modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = users.post), contentDescription = "user post")
        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_like_outline), contentDescription = "Like",
                        tint = Color.Black,
                        modifier = Modifier.size(25.dp))
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_comment), contentDescription = "Comment",
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp))
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_send), contentDescription = "Share",
                        tint = Color.Black,
                        modifier = Modifier.size(23.dp))
                }

            }
            Row() {
                IconButton(onClick = {}){
                    Icon(painter = painterResource(id = R.drawable.ic_save), contentDescription = "Save",
                    tint = Color.Black,
                    modifier = Modifier.size(28.dp))
                }
            }

        }
        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
            Text(text = "${users.likes} likes")
            Text(text = buildAnnotatedString {
                append(
                    AnnotatedString(
                        text = "${users.username} ",
                        spanStyle = SpanStyle(fontWeight = FontWeight.Bold)
                    )
                )
                append(users.capt)
            })
            Text(text = "View all ${users.commentcount} comments",
            color = Color.DarkGray, fontSize = 15.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyInstagramTheme {
        //StoryCard(Users("its_brijesh_rajput", R.drawable.ic_launcher_foreground, "Bunty Rajput", "Meerut", androidx.core.R.drawable.notification_bg, 163, 15, "great")
        PostCard(Users("its_brijesh_rajput", R.drawable.ic_launcher_foreground, "Bunty Rajput", "Meerut", R.drawable.ic_save, 163, 15,"nice pic"))
    }
}