package com.example.kuka0.kbtuintranetsample_ky.Presenters

import com.example.kuka0.kbtuintranetsample_ky.Models.StudentData
import com.example.kuka0.kbtuintranetsample_ky.Models.TeacherData
import com.example.kuka0.kbtuintranetsample_ky.Views.MainView

class MainPresenter(private val view:MainView) {
    fun onItemClick(obj:Any){
        if (obj is TeacherData)
            view.goToProfile("Teacher", obj.id)
        if (obj is StudentData)
            view.goToProfile("Student", obj.id)

    }
}