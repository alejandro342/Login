package com.example.loginko.login.model

import android.os.Handler
import android.text.TextUtils
import com.example.loginko.service.WebServices
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginInteractorL : LoginInterceptor {

    override fun login(email: String?, username: String?, listener: LoginInterceptor.OnLogin?) {
        Handler().postDelayed(object : Runnable {
            override fun run() {
                if (TextUtils.isEmpty(email)){
                    listener?.onUsernameError()
                    return
                }
                if(TextUtils.isEmpty(username)){
                    listener?.onPasswordError()
                    return
                }
                listener?.onSuccess()
            }
        }, 10000)

    }

}