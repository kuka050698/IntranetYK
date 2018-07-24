package com.example.kuka0.kbtuintranetsample_ky.Interactors

import com.example.kuka0.kbtuintranetsample_ky.Models.UserData

interface LoginInteractorView {
    interface onFinishedListener{
        fun onFailed(message:String)
        fun onSuccess()
    }

    fun login(user: UserData, listener:onFinishedListener )
}