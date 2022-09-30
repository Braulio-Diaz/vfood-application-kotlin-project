package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class UserRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        //Esconder la barra ActionBar
        this.supportActionBar?.hide()

        //DECLARAMOS LAS VARIABLES
        val til_name = findViewById<TextInputLayout>(R.id.til_name)
        val til_surname = findViewById<TextInputLayout>(R.id.til_surname)
        val til_form_email = findViewById<TextInputLayout>(R.id.til_form_email)
        val til_form_password = findViewById<TextInputLayout>(R.id.til_form_password)
        val til_form_repeat_password = findViewById<TextInputLayout>(R.id.til_form_repeat_password)
        val btn_form_register = findViewById<Button>(R.id.btn_form_register)

        btn_form_register.setOnClickListener {

            var name = til_name.editText?.text.toString()
            var surname = til_surname.editText?.text.toString()
            var formEmail = til_form_email.editText?.text.toString()
            var formPassword = til_form_password.editText?.text.toString()
            var formRepeatPassword = til_form_repeat_password.editText?.text.toString()

            //VALIDACIONES DE CAMPO NULO
            val validate = Validate()
            if (validate.validarCampoNulo(name)) til_name.error = getString(R.string.null_field_error) else til_name.error = ""
            if (validate.validarCampoNulo((surname))) til_surname.error = getString(R.string.null_field_error) else til_surname.error = ""
            if (validate.validarCampoNulo(formEmail)) til_form_email.error = getString(R.string.null_field_error) else til_form_email.error = ""
            if (validate.validarCampoNulo(formPassword)) til_form_password.error = getString(R.string.null_field_error) else til_form_password.error = ""
            if (validate.validarCampoNulo(formRepeatPassword)) til_form_repeat_password.error = getString(R.string.null_field_error) else til_form_repeat_password.error = ""

            Toast.makeText(this@UserRegister, "Usuario creado", Toast.LENGTH_SHORT).show()
        }
    }
}