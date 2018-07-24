package com.example.kuka0.kbtuintranetsample_ky.Interactors

import android.content.ContentValues.TAG
import android.util.Log
import com.example.kuka0.kbtuintranetsample_ky.Models.UserData
import com.google.firebase.auth.FirebaseAuth


class LoginInteractor:LoginInteractorView {

    private var mAuth:FirebaseAuth?=null


    override fun login(user: UserData, listener: LoginInteractorView.onFinishedListener) {
        mAuth!!.signInWithEmailAndPassword(user.name, user.password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        listener.onSuccess()
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val useer = mAuth!!.currentUser

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        listener.onFailed("Something is wrong")
                    }

                    // ...
                }
    }
}