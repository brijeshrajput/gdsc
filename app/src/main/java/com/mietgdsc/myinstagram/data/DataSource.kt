package com.mietgdsc.myinstagram.data

import com.mietgdsc.myinstagram.R
import com.mietgdsc.myinstagram.model.Notifications
import com.mietgdsc.myinstagram.model.Reels
import com.mietgdsc.myinstagram.model.Users

class DataSource {
    fun loadstories(): List<Users> {
        return listOf(
            Users("gdsc_miet", R.drawable.gdsc_pic, "GDSC MIET", "Miet Meerut", R.drawable.post1, 123, 17,"Keep learning"),
            Users("satakshi_jain_", R.drawable.post2, "Satakshi Jain", "Meerut", R.drawable.post2, 183, 16,"nice"),
            Users("swati_palliwal", R.drawable.post3, "Swati Palliwal", "Miet Meerut", R.drawable.post3, 113, 15,"great"),
            Users("its_brijesh_rajput", R.drawable.post4, "Bunty Rajput", "Modipuram", R.drawable.post4, 163, 18,"Nice Pic"),
            Users("gdsc_miet", R.drawable.gdsc_pic, "GDSC MIET", "Miet Meerut", R.drawable.post5, 16, 30,"Keep connected"),
            Users("gdsc_miet", R.drawable.gdsc_pic, "GDSC MIET", "Miet Meerut", R.drawable.gdsc_pic, 95, 45,"Hello Folks"),
            Users("dhruv_6514", R.drawable.post6, "Dhruv", "Kankarkhera", R.drawable.post6, 143, 8,"Bro.."),
            Users("gdsc_miet", R.drawable.gdsc_pic, "GDSC MIET", "Miet Meerut", R.drawable.post7, 18, 18,"Thank You GDSC"),
            Users("gdsc_miet", R.drawable.gdsc_pic, "GDSC MIET", "Miet Meerut", R.drawable.post8, 135, 10,"Orientation"),
        )
    }

    fun loadNotifications(): List<Notifications>{
        return listOf(
            Notifications(R.drawable.post4,"its_brijesh_rajput","liked your\npost.", R.drawable.post1),
            Notifications(R.drawable.post2,"satakshi.jain","liked your reply.", R.drawable.post6),
            Notifications(R.drawable.post3,"its.swati","liked your\npost.", R.drawable.post4),
            Notifications(R.drawable.post4,"its_brijesh_rajput","liked your\ncomment.", R.drawable.post3),
            Notifications(R.drawable.post4,"its_brijesh_rajput","liked your\npost.", R.drawable.post5)
        )
    }

    fun loadReels() : List<Reels>{
        return listOf(
            Reels("gdsc_miet", R.drawable.gdsc_pic, R.drawable.reel1, "Keep Learning!!", "As It Was", "500k", "10k"),
            Reels("satakshi.jain", R.drawable.post2, R.drawable.reel2, "Wow!!", "Believer", "123", "500"),
            Reels("dhruv_6514", R.drawable.post6, R.drawable.reel3, "", "", "", ""),
            Reels("gdsc_miet", R.drawable.gdsc_pic, R.drawable.reel4, "", "", "250k", "10k"),
            Reels("gdsc_miet", R.drawable.gdsc_pic, R.drawable.reel5, "", "", "100k", "50k"),
        )
    }
}