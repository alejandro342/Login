package com.example.loginko.login.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.loginko.MainActivity
import com.example.loginko.databinding.ActivityLoginBinding
import com.example.loginko.login.model.LoginInteractorL
import com.example.loginko.login.presenter.LoginPresenter
import com.example.loginko.login.presenter.LoginPresenterL
import com.example.loginko.login.request.LoginRequets
import com.example.loginko.login.response.LoginResponse
import com.example.loginko.service.WebServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() , LoginViewInterface, View.OnClickListener{

    private lateinit var mPresenter : LoginPresenter
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener (this)

        mPresenter = LoginPresenterL(this, LoginInteractorL())
    }

     override fun onDestroy(){
        mPresenter.onDestroy()
        super.onDestroy()

    }

    override fun onClick(p0: View?) {
       if (TextUtils.isEmpty(binding.textUser.text.toString()) || TextUtils.isEmpty(binding.textPassword.text.toString())){
           setUserNameError()
           setPasswordError()
       }else{
           loginU()
       }
    }

    fun loginU(){
        val loginrequets = LoginRequets()
        loginrequets.email.toString()
        loginrequets.username.toString()

        val loginResponseCall: Call<LoginResponse> = WebServices.getUsers.loginUsers(loginrequets)
        loginResponseCall.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                if (response.isSuccessful){
                    showProgress()
                    goHome()
                }
                else{
                    setUserNameError()
                    setPasswordError()
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    override fun showProgress() {
        binding.progressBar.setVisibility(View.VISIBLE)
        binding.button.setVisibility(View.GONE)
    }

    override fun hideProgress() {
        binding.progressBar.setVisibility(View.GONE)
        binding.button.setVisibility(View.VISIBLE)
    }

    override fun setUserNameError() {
       binding.textUser.setError("Error de usuario")
    }

    override fun setPasswordError() {
        binding.textPassword.setError("Error de contraseña")
    }

    override fun goHome() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

}