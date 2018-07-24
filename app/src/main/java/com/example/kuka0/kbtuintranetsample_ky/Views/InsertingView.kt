package com.example.kuka0.kbtuintranetsample_ky.Views

interface InsertingView {
    fun showMessage(message:String)
    fun studentFormVisibility(changed:Int)
    fun teacherFormVisibility(changed: Int)
    fun showProgress()
    fun hideProgress()
    fun goToMain()
}