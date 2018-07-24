package com.example.kuka0.kbtuintranetsample_ky.Views

interface TeacherView {

    fun showProgress ()
    fun hideProgress ()

    fun onResume()

    fun setTeacherAdapter (teachers : ArrayList<Any>)
    fun showMessage (message : String)
}