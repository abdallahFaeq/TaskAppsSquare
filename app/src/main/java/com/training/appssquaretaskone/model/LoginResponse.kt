package com.training.appssquaretaskone.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Boolean,

	@field:SerializedName("token")
	val token: String
)

