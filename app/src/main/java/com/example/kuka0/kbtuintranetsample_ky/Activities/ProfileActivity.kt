package com.example.kuka0.kbtuintranetsample_ky.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.kuka0.kbtuintranetsample_ky.Models.StudentData
import com.example.kuka0.kbtuintranetsample_ky.Models.TeacherData
import com.example.kuka0.kbtuintranetsample_ky.R
import com.example.kuka0.kbtuintranetsample_ky.Views.ProfileView
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(),ProfileView {
    var type:String?=null
    var id:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        var intent = intent
        type = intent.getStringExtra("type")
        id = intent.getStringExtra("id").toInt()

    }
    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }


    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun setItems(obj: Any) {
        if(obj is StudentData){
            profileName.text = obj.name
            profileSurname.text = obj.surname
            profileCourse.text = obj.course
            profileGpa.text = obj.gpa
        }
        else if(obj is TeacherData){
            studentBar.visibility = View.VISIBLE
            subjectForm.visibility = View.VISIBLE
            profileName.text = obj.name
            profileSurname.text = obj.surname
            profileSubject.text = obj.subject

        }
    }

    override fun goToMain() {
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    override fun showForm() {
        mainForm.visibility = View.VISIBLE
    }


}
