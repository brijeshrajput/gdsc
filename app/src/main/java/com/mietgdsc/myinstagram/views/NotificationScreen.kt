package com.mietgdsc.myinstagram.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mietgdsc.myinstagram.R
import com.mietgdsc.myinstagram.data.DataSource
import com.mietgdsc.myinstagram.model.Notifications
import com.mietgdsc.myinstagram.ui.theme.MyInstagramTheme

@Composable
fun NotificationScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ){


            val nlst = DataSource().loadNotifications()
            LazyColumn(modifier = Modifier.padding(10.dp)){
                item {
                    Text(text = "Notifications",
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                }
                items(nlst){ n->
                    Notiitem(notifications = n)
                }
                
            }

    }
}

@Composable
fun Notiitem(notifications: Notifications){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
    horizontalArrangement = Arrangement.SpaceBetween) {
        Row(modifier = Modifier.padding(1.dp),
        verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = notifications.profile), contentDescription = "Profile Pic",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.size(12.dp))
            Text(text = buildAnnotatedString {
                append(
                    AnnotatedString(
                        text = "${notifications.username} ",
                        spanStyle = SpanStyle(fontWeight = FontWeight.Bold)
                    )
                )
                append(notifications.msg)
            })
        }
        Row(modifier = Modifier.padding(5.dp)) {
            Image(painter = painterResource(id = notifications.photo), contentDescription = "Profile Pic",
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Black
                    ),
                contentScale = ContentScale.FillBounds)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyInstagramTheme {
//        NotificationScreen()
//        //Notiitem(notifications = Notifications(R.drawable.post4, "bunty","liked your post", R.drawable.post1))
//    }
//}