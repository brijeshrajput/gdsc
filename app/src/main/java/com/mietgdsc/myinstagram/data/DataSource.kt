package com.mietgdsc.myinstagram.data

import com.mietgdsc.myinstagram.R
import com.mietgdsc.myinstagram.model.Users

class DataSource {
    fun loadstories(): List<Users> {
        return listOf<Users>(
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
}