package com.mietgdsc.myinstagram.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mietgdsc.myinstagram.R
import com.mietgdsc.myinstagram.data.DataSource
import com.mietgdsc.myinstagram.ui.theme.MyInstagramTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen() {
    var ilist = DataSource().loadstories()
    ilist = ilist + ilist + ilist
    var srch by remember { mutableStateOf("Search") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            OutlinedTextField(value = srch, onValueChange = { srch = it},
            enabled = true,
            singleLine = true,
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search",
                    modifier = Modifier.size(20.dp))
            },
            modifier = Modifier.fillMaxWidth())

            LazyVerticalGrid(cells = GridCells.Fixed(3),
                content ={
                    items(23){ i->
                        Box(modifier = Modifier
                            .padding(8.dp)
                            .aspectRatio(1f)){
                            Image(painter = painterResource(id = ilist.get(i).post), contentDescription = "Images")
                        }
                    }
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyInstagramTheme {
        SearchScreen()
    }
}