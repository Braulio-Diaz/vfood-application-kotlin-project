package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class CategoryDelete : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_delete)

        val btn_delete_category = findViewById<Button>(R.id.btn_category_delete)

        btn_delete_category.setOnClickListener {

            Toast.makeText(this@CategoryDelete, "Categoría eliminada", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@CategoryDelete,Category::class.java)
            startActivity(intent)
        }
    }
}