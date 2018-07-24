package com.example.kuka0.kbtuintranetsample_ky.Interactors

import com.example.kuka0.kbtuintranetsample_ky.DB.AppDatabase.Companion.studentDB
import com.example.kuka0.kbtuintranetsample_ky.DB.AppDatabase.Companion.teacherDB
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DeleteInteractor:DeleteInteractorView {
    override fun onDeleteItem(id: Int, type: String) {
            Single.fromCallable{
                if (type == "StudentData")
                    studentDB.studentDao().removeStudentById(id)
                else if(type =="TeacherData")
                    teacherDB.teacherDAO().removeTeachersyId(id)

            }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()
        }
    }
