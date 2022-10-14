package com.mietgdsc.myinstagram.views.bottomnav

import com.mietgdsc.myinstagram.R

sealed class BottomBar(
    val route:String,
    val title:String,
    val icon:Int
){
    object Feed: BottomBar(
        route = "feed",
        title = "Feed",
        icon = R.drawable.ic_home_filled
    )
    object Search: BottomBar(
        route = "search",
        title = "Search",
        icon = R.drawable.ic_search
    )
    object Reels: BottomBar(
        route = "reels",
        title = "Reels",
        icon = R.drawable.ic_reels_outline
    )
    object Notification: BottomBar(
        route = "notification",
        title = "Notif..",
        icon = R.drawable.ic_like_outline
    )
    object Profile: BottomBar(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_baseline_person
    )
}
