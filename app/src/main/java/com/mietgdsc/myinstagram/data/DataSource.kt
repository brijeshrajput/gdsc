package com.mietgdsc.myinstagram.data

import com.mietgdsc.myinstagram.R
import com.mietgdsc.myinstagram.model.Users

class DataSource {
    fun loadstories(): List<Users> {
        return listOf<Users>(
            Users("its_brijesh_rajput", R.drawable.ic_save, "Bunty Rajput", "Meerut", R.drawable.ic_add, 163, 15,"Nice"),
            Users("its_brijesh_rajput", R.drawable.ic_send, "Bunty Rajput", "Meerut", R.drawable.ic_like_outline, 163, 15,"Great"),

        )
    }
}