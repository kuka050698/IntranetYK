package com.example.kuka0.kbtuintranetsample_ky.Presenters

import android.util.Log
import com.example.kuka0.kbtuintranetsample_ky.Interactors.RegistrationInteractor
import com.example.kuka0.kbtuintranetsample_ky.Models.UserData
import com.example.kuka0.kbtuintranetsample_ky.Views.RegistrationView

class RegistrationPresenter(private val view:RegistrationView,private val registerInteractor:RegistrationInteractor) {
     fun onFailed(message: String) {
        view.hideProgress()
        view.showMessage(message)
    }

     fun onSuccess() {
        view.showProgress()
    }
    fun signup(name:String,password:String){
       if(validate(name,password)){
           view.showProgress()
           registerInteractor.register(UserData(name,password),this)
       }
    }
    private fun validate(username: String,password: String,id: String):Boolean{
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