package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CategoryUpdate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_update)


        val btn_category_update = findViewById<Button>(R.id.btn_category_update)

        btn_category_update.setOnClickListener {
            val intent = Intent(this@CategoryUpdate,Category::class.java)
            startActivity(intent)
        }
    }
}