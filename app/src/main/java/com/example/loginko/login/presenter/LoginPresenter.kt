package com.example.loginko.login.presenter

interface LoginPresenter {

    fun validateUsers(email: String?, username: String?)
    fun onDestroy()

}