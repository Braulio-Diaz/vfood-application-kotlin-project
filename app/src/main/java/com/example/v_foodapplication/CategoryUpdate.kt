package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class CategoryUpdate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_update)

        val til_category_name_update = findViewById<TextInputLayout>(R.id.til_category_name_update)
        val btn_category_update = findViewById<Button>(R.id.btn_category_update)

        btn_category_update.setOnClickListener {

            var categoryNameUpdate = til_category_name_update.editText?.text.toString()

            val validate = Validate()
            if (validate.validarCampoNulo(categoryNameUpdate)) til_category_name_update.error = getString(R.string.null_field_error) else til_category_name_update.error = ""

            val intent = Intent(this@CategoryUpdate,Category::class.java)
            startActivity(intent)
        }
    }
}