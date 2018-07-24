package com.example.kuka0.kbtuintranetsample_ky.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.kuka0.kbtuintranetsample_ky.Presenters.MainPresenter
import com.example.kuka0.kbtuintranetsample_ky.R
import com.example.kuka0.kbtuintranetsample_ky.Views.MainView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),MainView {

    var mainPresenter = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floating_add.setOnClickListener{
            var intent = Intent(this,AddItemActivity::class.java)
            startActivity(intent)
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

    override fun OnItemClick(view: View, obj: Any) {
        mainPresenter.onItemClick(obj)
    }

    override fun goToProfile(type: String, id: Int) {
        var intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("type", type)
        intent.putExtra("id", id.toString())
        startActivity(intent)
    }


}




