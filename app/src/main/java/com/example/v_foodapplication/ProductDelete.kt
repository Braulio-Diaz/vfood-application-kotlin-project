package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProductDelete : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_delete)

        val btn_product_delete = findViewById<Button>(R.id.btn_product_delete)

        btn_product_delete.setOnClickListener {
            val intent = Intent(this@ProductDelete,CategoryRead::class.java)
            startActivity(intent)
        }
    }
}