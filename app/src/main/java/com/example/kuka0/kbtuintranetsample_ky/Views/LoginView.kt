package com.example.kuka0.kbtuintranetsample_ky.Views

interface LoginView {
    fun showProgress()
    fun hideProgress()
    fun showMessage(message:String)
    fun goToMainPage()

}