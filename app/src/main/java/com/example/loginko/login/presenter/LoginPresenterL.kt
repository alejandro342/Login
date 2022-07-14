package com.example.loginko.login.presenter

import com.example.loginko.login.model.LoginInteractorL
import com.example.loginko.login.model.LoginInterceptor
import com.example.loginko.login.request.LoginRequets
import com.example.loginko.login.response.LoginResponse
import com.example.loginko.login.view.LoginViewInterface
import com.example.loginko.service.WebServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginPresenterL(
    private  var mLogingView: LoginViewInterface,
    private  var mLoginInteractorL: LoginInteractorL
) : LoginPresenter, LoginInterceptor.OnLogin {



    override fun validateUsers(email: String?,username: String?) {
        mLogingView.showProgress()

        mLoginInteractorL.login(email, username,this)
    }


    override fun onUsernameError() {
        mLogingView.setUserNameError()
        mLogingView.hideProgress()
    }

    override fun onPasswordError() {
        mLogingView.setPasswordError()
        mLogingView.hideProgress()
    }

    override fun onSuccess() {
        mLogingView.goHome()
        mLogingView.hideProgress()
    }


    override fun onDestroy() {

    }
}