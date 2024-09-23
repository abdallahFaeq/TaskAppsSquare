package com.training.appssquaretaskone.utils

import android.util.Patterns

object Validation {
    fun isNameValid(
        name:String
    ):Boolean{
        // name shouldn't be empty
        return if (name.trim().isEmpty()) false else true
    }

    fun isEmailValid(
        email:String
    ):Boolean{
        // email should matches formatted email
        // email shoudn't be empty
       return if (email.trim().isEmpty() ||
           !Patterns.EMAIL_ADDRESS.matcher(email).matches()) false else true
    }

    fun isPasswordValid(
        password:String
    ):Boolean{
        // password should be greater than or equal to 6 numbers or characters
        return if (password.trim().isEmpty() || password.trim().length<6) false else true
    }
}