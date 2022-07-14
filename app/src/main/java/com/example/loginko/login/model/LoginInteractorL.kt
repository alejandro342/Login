package com.example.loginko.login.model

import android.os.Handler
import android.text.TextUtils
import com.example.loginko.login.request.LoginRequets
import com.example.loginko.login.response.LoginResponse
import com.example.loginko.service.WebServices
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginInteractorL : LoginInterceptor {

    override fun login(email: String?, username: String?, listener: LoginInterceptor.OnLogin?) {

                if (TextUtils.isEmpty(email)){
                    listener?.onUsernameError()
                    return
                }
                if(TextUtils.isEmpty(username)){
                    listener?.onPasswordError()
                    return
                }

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
                            listener?.onSuccess()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {

                    }
                })

            }


    }

