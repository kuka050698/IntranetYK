package com.example.kuka0.kbtuintranetsample_ky.Presenters

import android.util.Log
import com.example.kuka0.kbtuintranetsample_ky.Interactors.LoginInteractor
import com.example.kuka0.kbtuintranetsample_ky.Interactors.LoginInteractorView
import com.example.kuka0.kbtuintranetsample_ky.Models.UserData
import com.example.kuka0.kbtuintranetsample_ky.Views.LoginView

class LoginPresenter(private val view:LoginView,private val loginInteractor:LoginInteractor): LoginInteractorView.onFinishedListener {
    override fun onFailed(message: String) {
        view.hideProgress()
        view.showMessage(message)
    }

    override fun onSuccess() {
        view.showProgress()

    }

    fun signin(username:String,password:String){
        if(validate(username,password)) {
            view.showProgress()
            loginInteractor.login(UserData(username, password), this)

        }
    }
    private fun validate(username: String,password: String):Boolean{
            if(username.isEmpty() || username==null){
                Log.d("main","$username $password")
                view.showMessage("Enter the name")
                return false
            }
        if(password.isEmpty() || password==null){
            Log.d("main","$username $password")
            view.showMessage("Enter the password")
            return false
        }
        if(!standards(password)) return false
        return true
    }
        private fun standards(password: String):Boolean{
            var uppercase=0
            var number=0
            for(it in password){
                if(it in 'A'..'Z'){
                    uppercase++
                }
                else if(it in '0'..'9'){
                    number++
                }
            }
            if(password.length<8){
                Log.d("password standards","$password")
                view.showMessage("Password length must be at least 8")
                return false
            }
            if(uppercase==0){
                view.showMessage("Password should contain at least 1 uppercase letter")
                return false
            }
            if(number==0){
                view.showMessage("Password should contain at least 1 number")
                return false
            }
            return true
        }

}