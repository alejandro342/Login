package com.example.loginko.login.model

class UserDataC : ArrayList<UsersItem>()

data class UsersItem(
    val company: Company,
    val id: String,
    val username: String,
    val name: String,
    val email: String,
    val adress: Adress,
    val phone: String,
    val website: String

)

data class Adress(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)

data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

data class Geo(
    val lat: String,
    val lng: String
)
