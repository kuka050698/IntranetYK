package com.example.kuka0.kbtuintranetsample_ky.Interactors

import android.content.ContentValues.TAG
import android.util.Log
import com.example.kuka0.kbtuintranetsample_ky.Models.UserData
import com.example.kuka0.kbtuintranetsample_ky.Presenters.RegistrationPresenter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class RegistrationInteractor:RegistrationInteractorView {
    private var mAuth:FirebaseAuth?=null
    private var firebaseDB:FirebaseDatabase?=null
    private var myRef:DatabaseReference = firebaseDB!!.reference
    override fun register(user:UserData, listener: RegistrationPresenter) {
        mAuth!!.createUserWithEmailAndPassword(user.name, user.password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val useer = mAuth!!.currentUser
                        listener.onSuccess()
                        var key = myRef.child("users").push().key
                        myRef.child("users").child(key).child("username").setValue(user.name)
                        myRef.child("users").child(key).child("password").setValue(user.password)


                    } else {
                        listener.onFailed("Failed")
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    }

                }

    }
}