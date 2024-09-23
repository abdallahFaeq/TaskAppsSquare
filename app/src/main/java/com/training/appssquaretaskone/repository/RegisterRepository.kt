package com.training.appssquaretaskone.repository

import com.training.appssquaretaskone.data.remote.ApiService
import com.training.appssquaretaskone.model.RegisterResponse
import java.io.IOException
import javax.inject.Inject

class RegisterRepository @Inject constructor(
    private val apiService : ApiService
) {
    suspend fun registerUser(
        name:String,
        email:String,
        password:String
    ):Result<RegisterResponse>{
        return try {
            val response = apiService.registerUser(
                name, email, password
            )
            if (response.isSuccessful){
                response.body()?.let {
                    Result.success(it)
                }?:Result.failure(Throwable("Registeration failed: Empty response"))
            }else{
                Result.failure(Throwable("Error: ${response.code()} - ${response.message()}\""))
            }
        }catch (e:Exception){
            Result.failure(Throwable("Exception : ${e.localizedMessage}"))
        }
    }
}