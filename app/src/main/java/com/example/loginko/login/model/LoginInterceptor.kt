package com.example.loginko.login.model


interface LoginInterceptor {

    interface OnLogin{
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }

    fun login(email: String?, username: String?, listener: OnLogin?)
}