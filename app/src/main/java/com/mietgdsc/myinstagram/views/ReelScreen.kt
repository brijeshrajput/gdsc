package com.mietgdsc.myinstagram.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mietgdsc.myinstagram.R
import com.mietgdsc.myinstagram.data.DataSource
import com.mietgdsc.myinstagram.model.Reels

@Composable
fun ReelScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){
        val lst = DataSource().loadReels()
        LazyColumn(modifier = Modifier.padding(1.dp)) {
            item { Divider() }
            items(lst){r->
                ReelCard(reels = r)
            }
        }
    }
}

@Composable
fun ReelCard(reels : Reels) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White), contentAlignment = Alignment.Center){

        Image(painter = painterResource(id = reels.post), contentDescription = "", modifier = Modifier.fillMaxHeight())
        Column(modifier = Modifier.align(Alignment.BottomEnd)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_like_outline), contentDescription = "", tint = Color.White, modifier = Modifier.size(40.dp))


            }
            Text(text = "${reels.likeCount}")

            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_comment), contentDescription = "", tint = Color.White, modifier = Modifier.size(40.dp))

            }
            Text(text = "${reels.commentCount}")
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_save), contentDescription = "", tint = Color.White, modifier = Modifier.size(40.dp))
            }

        }

        Column(modifier = Modifier.align(Alignment.BottomStart)) {
            Row {
                Image(painter = painterResource(id = reels.profilePic), contentDescription = "", modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .size(50.dp), contentScale = ContentScale.Crop)
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "${reels.userName}")
            }
            Text(text = "${reels.caption}")
            Text(text = "${reels.songName}")
        }

    }

}