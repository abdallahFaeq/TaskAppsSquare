package com.training.appssquaretaskone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.appssquaretaskone.model.LoginResponse
import com.training.appssquaretaskone.model.RegisterResponse
import com.training.appssquaretaskone.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository:LoginRepository
) :ViewModel(){
    private var _loginState = MutableStateFlow<Result<LoginResponse>?>(null)
    val loginState = _loginState.asStateFlow()

    fun loginUser(
        email:String,
        password:String
    ){
        viewModelScope.launch {
            val result = loginRepository.loginUser(
                email, password
            )
            _loginState.emit(result)
        }

    }

    fun resetLoginState(){
        _loginState.value = null
    }
}