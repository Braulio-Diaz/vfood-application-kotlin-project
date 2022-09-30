package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class CategoryCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_create)

        val til_category_create = findViewById<TextInputLayout>(R.id.til_category_create)
        val btn_category_create = findViewById<Button>(R.id.btn_category_create)

        btn_category_create.setOnClickListener {

            var category_create = til_category_create.editText?.text.toString()
            var validate = Validate()

            if (validate.validarCampoNulo(category_create)) til_category_create.error = getString(R.string.null_field_error) else til_category_create.error = ""

            Toast.makeText(this@CategoryCreate, "Cateogría creada", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@CategoryCreate,Category::class.java)
            startActivity(intent)
        }
    }
}