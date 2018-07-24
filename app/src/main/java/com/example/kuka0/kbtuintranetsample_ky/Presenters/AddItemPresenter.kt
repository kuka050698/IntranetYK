package com.example.kuka0.kbtuintranetsample_ky.Presenters

import android.text.TextUtils
import android.util.Log
import com.example.kuka0.kbtuintranetsample_ky.Interactors.InsertInteractor
import com.example.kuka0.kbtuintranetsample_ky.Models.StudentData
import com.example.kuka0.kbtuintranetsample_ky.Models.TeacherData
import com.example.kuka0.kbtuintranetsample_ky.Views.InsertingView

class AddItemPresenter(private val view:InsertingView,private val addInteractor:InsertInteractor) {

    var typeOfUser:String?=null
    fun insertItem(obj:Any){
        if(obj is StudentData){
            var student:StudentData=obj
            if(!isEmptyUsername(student.name)||!isEmptyPassword(student.surname) || isCourseCorrect(student.course)
            || isGPACorrect(student.gpa) ) return
            view.showProgress()
            addInteractor.addUser(student)
            view.hideProgress()
            view.showMessage("Added")
            view.goToMain()
        }
        else if(obj is TeacherData){
            var teacher:TeacherData=obj
            if(!isEmptyUsername(teacher.name)||!isEmptyPassword(teacher.surname) || !isSubjectEmpty(teacher.subject))
            return
            view.showProgress()
            addInteractor.addUser(teacher)
            view.hideProgress()
            view.showMessage("Added")
            view.goToMain()

        }
    }
    fun isSubjectEmpty(subject:String):Boolean{
        if(TextUtils.isEmpty(subject)){
            return false
        }
        return true
    }
    fun isEmptyUsername(username:String):Boolean{
        if(TextUtils.isEmpty(username) || username==null){
            return false
            view.showMessage("Please enter the name")
        }
        return true
    }
    fun isEmptyPassword(password:String):Boolean{
        if(!passwordValidate(password)){
            return false
        }
        return true
    }
    private fun passwordValidate(password: String):Boolean{
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
        if(TextUtils.isEmpty(password) || password==null){
            return false
            view.showMessage("Please enter the password")
        }
        else if(password.length<8){
            Log.d("password standards","$password")
            view.showMessage("Password length must be at least 8")
            return false
        }
        else if(uppercase==0){
            view.showMessage("Password should contain at least 1 uppercase letter")
            return false
        }
        else if(number==0){
            view.showMessage("Password should contain at least 1 number")
            return false
        }
        return true

    }
    fun isCourseCorrect(course:String):Boolean{
        if(TextUtils.isEmpty(course)){
            return false
            view.showMessage("Please fill the course")
        }
        if(course>="6" && course>="10"){
            return false
            view.showMessage("Course if out of range")
        }
        return true
    }
    fun isGPACorrect(gpa:String):Boolean{
        if(gpa>="4.1"){
            return false
            view.showMessage("Gpa is out of range")
        }
        return true
    }
}