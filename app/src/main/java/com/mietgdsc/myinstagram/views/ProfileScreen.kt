package com.mietgdsc.myinstagram.views

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mietgdsc.myinstagram.R
import com.mietgdsc.myinstagram.data.DataSource
import com.mietgdsc.myinstagram.model.Users
import com.mietgdsc.myinstagram.ui.theme.MyInstagramTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(){
    val lst = DataSource().loadstories()
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround) {
            Image(painter = painterResource(id = R.drawable.gdsc_pic), contentDescription = "Profile Pic",
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = CircleShape
                    ),
                contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(5.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "15", textAlign = TextAlign.Center, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Posts")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "150", textAlign = TextAlign.Center, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Followers")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "200", textAlign = TextAlign.Center, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Following")
                }

        }
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = "GDSC MIET", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = "Community of Student Developers aims at helping students bridge the gap between theory and practice")
            Text(text = buildAnnotatedString {
                append("Connect | Learn | Grow")
            })
        }
        
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ),
            shape = RoundedCornerShape(8.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                modifier = Modifier.width(300.dp).height(35.dp)
            ) {
                Text(text = "Edit Profile", fontSize = 10.sp)
            }
            Spacer(modifier = Modifier.size(5.dp))
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ),
            shape = RoundedCornerShape(8.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                modifier = Modifier.height(35.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_save), contentDescription = "add", modifier = Modifier.size(30.dp))
            }
        }
        Spacer(modifier = Modifier.size(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ){
            LazyRow(){
                    items(lst){ u->
                        StoryProfileCard(users = u)
                    }
                }
            Spacer(modifier = Modifier.size(10.dp))
            Divider()
        }
            LazyVerticalGrid(cells = GridCells.Fixed(3),
                content ={
                    items(8){ i->
                        Box(modifier = Modifier
                            .padding(8.dp)
                            .aspectRatio(1f)){
                            Image(painter = painterResource(id = lst.get(i).post), contentDescription = "Post")
                        }
                    }
                })
        }

    }

@Composable
fun StoryProfileCard(users: Users){
    Box(contentAlignment = Alignment.TopCenter,
        modifier = Modifier.padding(8.dp)){
        Canvas(modifier = Modifier.size(70.dp)){
            drawCircle(
                brush = Brush.linearGradient(listOf(Color.White, Color.LightGray, Color.White)),
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyInstagramTheme {
        ProfileScreen()
    }
}