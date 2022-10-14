package com.mietgdsc.myinstagram.views.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar(
    val route:String,
    val title:String,
    val icon:ImageVector
){
    object Feed: BottomBar(
        route = "feed",
        title = "Feed",
        icon = Icons.Default.Home
    )
    object Search: BottomBar(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )
    object Reels: BottomBar(
        route = "reels",
        title = "Reels",
        icon = Icons.Default.Person
    )
    object Notification: BottomBar(
        route = "notification",
        title = "n",
        icon = Icons.Default.Notifications
    )
    object Profile: BottomBar(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}
