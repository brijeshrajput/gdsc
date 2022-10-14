package com.mietgdsc.myinstagram.model

data class Users(
    val username:String,
    val profilePic:Int,
    val name:String,
    val location:String,
    val post:Int,
    val likes:Int,
    val commentcount:Int,
    val capt:String
)
