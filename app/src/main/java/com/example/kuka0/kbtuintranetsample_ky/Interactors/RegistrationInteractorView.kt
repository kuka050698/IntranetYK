package com.example.kuka0.kbtuintranetsample_ky.Interactors

import com.example.kuka0.kbtuintranetsample_ky.Presenters.RegistrationPresenter

interface RegistrationInteractorView {
    interface onFinishedListener{
        fun onFailed(message:String)
        fun onResume()
    }
    fun register(user:com.example.kuka0.kbtuintranetsample_ky.Models.UserData, listener: RegistrationPresenter)
}