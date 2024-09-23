package com.training.appssquaretaskone.data.remote

import com.training.appssquaretaskone.model.LoginResponse
import com.training.appssquaretaskone.model.RegisterResponse
import com.training.appssquaretaskone.utils.ApiUtils
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST(ApiUtils.REGISTER_END_POITN)
    suspend fun registerUser(
     @Field("name") name:String,
     @Field("email") email:String,
     @Field("password") password:String
    ):Response<RegisterResponse>

    @FormUrlEncoded
    @POST(ApiUtils.LOGIN_END_POINT)
    suspend fun loginUser(
        @Field("email") name:String,
        @Field("password") password:String
    ):Response<LoginResponse>
}