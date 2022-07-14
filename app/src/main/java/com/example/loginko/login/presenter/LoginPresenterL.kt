package com.example.loginko.login.presenter

import com.example.loginko.login.model.LoginInteractorL
import com.example.loginko.login.model.LoginInterceptor
import com.example.loginko.login.view.LoginViewInterface


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