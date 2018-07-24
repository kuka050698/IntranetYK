package com.example.kuka0.kbtuintranetsample_ky.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey


data class StudentData (@ColumnInfo(name = "name")
                            var name: String,
                            @ColumnInfo(name = "surname")
                            var surname: String,
                            @ColumnInfo(name = "course")
                            var course: String,
                            @ColumnInfo(name = "gpa")
                            var gpa:String)
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}