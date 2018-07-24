package com.example.kuka0.kbtuintranetsample_ky.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

    data class TeacherData(
        @ColumnInfo(name = "name")
        var name:String,
        @ColumnInfo(name="surname")
        var surname:String,
        @ColumnInfo(name = "subject")
        var subject: String

){
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}
