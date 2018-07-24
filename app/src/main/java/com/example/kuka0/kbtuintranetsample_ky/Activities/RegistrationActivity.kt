package com.example.kuka0.kbtuintranetsample_ky.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.kuka0.kbtuintranetsample_ky.R
import com.example.kuka0.kbtuintranetsample_ky.Views.RegistrationView

class RegistrationActivity : AppCompatActivity(), RegistrationView {
    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun goToMainPage() {

    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }
}
