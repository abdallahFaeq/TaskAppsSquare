package com.training.appssquaretaskone.model

import com.google.gson.annotations.SerializedName

data class Data(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("email")
    val email: String
)
