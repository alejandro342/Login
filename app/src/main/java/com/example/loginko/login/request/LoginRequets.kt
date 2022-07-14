package com.example.loginko.login.request

import com.google.gson.annotations.SerializedName

class LoginRequets {

    @SerializedName("email")
    var email : String? = null
    @SerializedName("username")
    var username : String? = null
}