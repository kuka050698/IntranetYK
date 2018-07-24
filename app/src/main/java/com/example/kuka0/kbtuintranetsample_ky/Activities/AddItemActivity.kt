package com.example.kuka0.kbtuintranetsample_ky.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.kuka0.kbtuintranetsample_ky.Models.StudentData
import com.example.kuka0.kbtuintranetsample_ky.Models.TeacherData
import com.example.kuka0.kbtuintranetsample_ky.Presenters.AddItemPresenter
import com.example.kuka0.kbtuintranetsample_ky.R
import com.example.kuka0.kbtuintranetsample_ky.Views.InsertingView
import kotlinx.android.synthetic.main.activity_add_item.*
import kotlinx.android.synthetic.main.activity_login.*

class AddItemActivity : AppCompatActivity(),InsertingView {
    private var insertPresenter:AddItemPresenter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        add_btn.setOnClickListener{
           if(insertPresenter?.typeOfUser=="Student"){
               insertPresenter?.insertItem(StudentData(insertedName.text.toString(),insertedSurname.text.toString()
               ,insertedCourse.text.toString(),insertedGpa.text.toString()))
           }
            else if(insertPresenter?.typeOfUser=="Teacher"){
               insertPresenter?.insertItem(TeacherData(insertedName.text.toString(),insertedSurname.text.toString(),insertedGpa.text.toString()))
           }
        }

    }
    override fun showMessage(message: String) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show()
    }

    override fun studentFormVisibility(changed: Int) {
        if(changed == 0){
            studentForm.visibility = View.VISIBLE
        }
        studentForm.visibility = View.INVISIBLE
    }

    override fun teacherFormVisibility(changed: Int) {
        if(changed == 0){
            teacherForm.visibility = View.INVISIBLE
        }
        teacherForm.visibility = View.VISIBLE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun goToMain() {
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }


}
