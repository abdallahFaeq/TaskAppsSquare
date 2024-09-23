package com.training.appssquaretaskone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.appssquaretaskone.model.RegisterResponse
import com.training.appssquaretaskone.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
  private val registerRepository:RegisterRepository
):ViewModel(){
    private var _registerState = MutableStateFlow<Result<RegisterResponse>?>(null)
    val registerState = _registerState.asStateFlow()

    fun registerUser(
      name:String,
      email:String,
      password:String
    ){
      viewModelScope.launch {
        val result = registerRepository.registerUser(
          name, email, password
        )

        _registerState.emit(result)
      }
    }

    fun resetRegisterState(){
        _registerState.value = null
    }
}