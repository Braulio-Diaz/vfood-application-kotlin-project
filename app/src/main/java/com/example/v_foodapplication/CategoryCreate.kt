package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CategoryCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_create)

        val btn_category_create = findViewById<Button>(R.id.btn_category_create)

        btn_category_create.setOnClickListener {
            val intent = Intent(this@CategoryCreate,Category::class.java)
            startActivity(intent)
        }
    }
}