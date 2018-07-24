package com.example.kuka0.kbtuintranetsample_ky.Presenters

import com.example.kuka0.kbtuintranetsample_ky.Interactors.DeleteInteractor
import com.example.kuka0.kbtuintranetsample_ky.Interactors.GetInteractor
import com.example.kuka0.kbtuintranetsample_ky.Interactors.GetInteractorView
import com.example.kuka0.kbtuintranetsample_ky.Views.ProfileView

class ProfilePresenter(private val view:ProfileView,private val getInteractor:GetInteractor,
                    private val deleteInteractor:DeleteInteractor) : GetInteractorView.onFinishedListener {
    override fun onReadFinished(obj: Any) {
        view.hideProgress()
        view.setItems(obj)
    }


    fun ReadItem(id:Int,type:String){
        view.showProgress()
        getInteractor.onRead(this,id,type)

    }
    fun deleteItem(id:Int,type: String){
        view.showProgress()
        deleteInteractor.onDeleteItem(id,type)
        view.hideProgress()
        view.showMessage("Removed")
        view.goToMain()
    }
}