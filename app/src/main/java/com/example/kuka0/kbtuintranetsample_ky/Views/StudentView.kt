package com.example.kuka0.kbtuintranetsample_ky.Views

interface StudentView {

    fun showProgress ()
    fun hideProgress ()

    fun onResume()

    fun setStudentAdapter (students : ArrayList<Any>)
    fun showMessage (message : String)
}