package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UserRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        val btn_form_register = findViewById<Button>(R.id.btn_form_register)

        btn_form_register.setOnClickListener {
            val intent = Intent(this@UserRegister,UserLogin::class.java)
            startActivity(intent)
        }
    }
}