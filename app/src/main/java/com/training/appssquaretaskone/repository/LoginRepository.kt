package com.training.appssquaretaskone.repository

import com.training.appssquaretaskone.data.remote.ApiService
import com.training.appssquaretaskone.model.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun loginUser(
        email: String,
        password: String
    ): Result<LoginResponse>? {
        return try {
            val response = apiService.loginUser(
                email, password
            )
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Throwable("Registeration failed: Empty response"))
            } else {
                Result.failure(Throwable("Error: ${response.code()} - ${response.message()}\""))
            }
        } catch (e: Exception) {
            Result.failure(Throwable("Exception : ${e.localizedMessage}"))
        }
    }
}
