package com.mietgdsc.myinstagram.views.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mietgdsc.myinstagram.views.*

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = BottomBar.Feed.route){
        composable(route = BottomBar.Feed.route){
            FeedScreen()
        }
        composable(route = BottomBar.Search.route){
            SearchScreen()
        }
        composable(route = BottomBar.Reels.route){
            ReelScreen()
        }
        composable(route = BottomBar.Notification.route){
            NotificationScreen()
        }
        composable(route = BottomBar.Profile.route){
            ProfileScreen()
        }
    }
}