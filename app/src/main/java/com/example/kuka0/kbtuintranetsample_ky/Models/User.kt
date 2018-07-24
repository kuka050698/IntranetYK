package com.example.kuka0.kbtuintranetsample_ky.Models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.PrimaryKey

data class UserData(
        @ColumnInfo(name = "name")
        var name:String,
        @ColumnInfo(name="password")
        var password:String
){
    @PrimaryKey(autoGenerate = true)
    var key:Int=0
}

