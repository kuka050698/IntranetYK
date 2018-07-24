package com.example.kuka0.kbtuintranetsample_ky.Views

import android.view.View

interface MainView {
    fun showProgress()
    fun hideProgress()
    fun showMessage(message:String)
    fun OnItemClick(view: View, obj:Any)
    fun goToProfile(type:String,id:Int)
}