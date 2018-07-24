package com.example.kuka0.kbtuintranetsample_ky.Interactors

interface GetInteractorView {

    interface onFinishedListener{
        fun onReadFinished(obj:Any)
    }
    fun onRead(listener:onFinishedListener,id:Int,type:String)
}