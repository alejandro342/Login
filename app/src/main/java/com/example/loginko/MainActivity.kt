package com.example.loginko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginko.adapater.UsersAdapter
import com.example.loginko.databinding.ActivityMainBinding
import com.example.loginko.login.model.UsersItem
import com.example.loginko.service.WebServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var listUser = ArrayList<UsersItem>()
    lateinit var adapter:UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerUsers.adapter = UsersAdapter(this,listUser)
        binding.recyclerUsers.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        getUser()
    }

   private fun getUser(){
       val call: Call<List<UsersItem>> =WebServices.getUsers.usersList()
       call.enqueue(object : Callback<List<UsersItem>>{
           override fun onResponse(
               call: Call<List<UsersItem>>,
               response: Response<List<UsersItem>>
           ) {
              listUser.addAll(response.body()!!)
               binding.recyclerUsers.adapter?.notifyDataSetChanged()
           }

           override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {
               TODO("Not yet implemented")
           }

       })
    }
}