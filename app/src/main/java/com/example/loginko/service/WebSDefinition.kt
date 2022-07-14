package com.example.loginko.service

import com.example.loginko.login.model.UsersItem
import com.example.loginko.login.request.LoginRequets
import com.example.loginko.login.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field

import retrofit2.http.GET
import retrofit2.http.POST

interface WebSDefinition {

    @GET("users")
    fun usersList(): Call<List<UsersItem>>

    @POST("users")
    fun loginUsers(@Body loginRequets: LoginRequets) : Call<LoginResponse>

}