package com.mietgdsc.myinstagram.views

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mietgdsc.myinstagram.R
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mietgdsc.myinstagram.views.bottomnav.BottomBar
import com.mietgdsc.myinstagram.views.bottomnav.BottomNavGraph

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController = navController)}
    ){
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun TopBar(){
    TopAppBar(title = { Text(text = "Instagram", fontFamily = FontFamily(Font(R.font.insta_logo)),
    fontSize = 35.sp, textAlign = TextAlign.Center,
    modifier = Modifier.padding(7.dp))},
    backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 8.dp,
        actions = {
            IconButton(onClick = {
//                val i = Intent(context, MessageScreen::class.java)
//                context.startActivity(i)
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Message Button")
            }
            IconButton(onClick = {
//                val i = Intent(context, MessageScreen::class.java)
//                context.startActivity(i)
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_send), contentDescription = "Message Button")
            }
        }
    )
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBar.Feed,
        BottomBar.Search,
        BottomBar.Reels,
        BottomBar.Notification,
        BottomBar.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(backgroundColor = Color.White,
    contentColor = Color.Black){
        screens.forEach{ s->
            AddItem(screen = s, currentDestination = currentDestination, navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen:BottomBar,
    currentDestination:NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem(
        label = {
                Text(text = screen.title)
        },
        icon = {
               Icon(imageVector = screen.icon, contentDescription = "nav icon")
        },
        selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }, alwaysShowLabel = false)
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyInstagramTheme {
//        MainScreen()
//    }
//}