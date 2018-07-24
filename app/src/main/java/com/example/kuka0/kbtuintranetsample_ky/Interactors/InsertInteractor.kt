package com.example.kuka0.kbtuintranetsample_ky.Interactors

import com.example.kuka0.kbtuintranetsample_ky.Models.StudentData
import com.example.kuka0.kbtuintranetsample_ky.Models.TeacherData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertInteractor:InsertItemInteractor {
    private var dB = FirebaseDatabase.getInstance()
    private var mRef:DatabaseReference?=null
    override fun addUser(obj: Any) {
            if(obj is StudentData) {
                var student = obj
                mRef = dB?.getReference("students").push()
                mRef?.setValue(obj)
            }
            if(obj is TeacherData) {
                var teacher = obj
                mRef = dB?.getReference("teachers").push()
                mRef?.setValue(obj)
            }
    }
}