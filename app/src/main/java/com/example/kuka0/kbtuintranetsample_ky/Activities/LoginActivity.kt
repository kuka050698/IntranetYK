package com.example.kuka0.kbtuintranetsample_ky.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.kuka0.kbtuintranetsample_ky.Interactors.LoginInteractor
import com.example.kuka0.kbtuintranetsample_ky.Presenters.LoginPresenter
import com.example.kuka0.kbtuintranetsample_ky.R
import com.example.kuka0.kbtuintranetsample_ky.Views.LoginView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),LoginView {
    lateinit var loginPresenter : LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this, LoginInteractor())
        bnSeePassword.bringToFront()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        bnLogin.setOnClickListener{
            loginPresenter.signin(user_name.text.toString(),pass_word.text.toString())
        }
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun goToMainPage() {
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    }


}
