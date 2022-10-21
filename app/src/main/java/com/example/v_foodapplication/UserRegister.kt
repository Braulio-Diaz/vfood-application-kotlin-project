package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch
import roomDatabase.Db
import roomDatabase.entity.Usuario
import java.lang.Exception

class UserRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        //Esconder la barra ActionBar
        this.supportActionBar?.hide()

        //INICIALIZAMOS LA BASE DE DATOS
        val room = Room.databaseBuilder(this, Db::class.java,"database-chichi").allowMainThreadQueries().build()

        //DECLARAMOS LAS VARIABLES
        val til_register_user_name = findViewById<TextInputLayout>(R.id.til_register_user_name)
        val til_name = findViewById<TextInputLayout>(R.id.til_name)
        val til_surname = findViewById<TextInputLayout>(R.id.til_surname)
        val til_form_email = findViewById<TextInputLayout>(R.id.til_form_email)
        val til_form_password = findViewById<TextInputLayout>(R.id.til_form_password)
        val btn_form_register = findViewById<Button>(R.id.btn_form_register)

        btn_form_register.setOnClickListener {

            //OBTENEMOS LOS DATOS INGRESADOS
            var register_user_name = til_register_user_name.editText?.text.toString()
            var name = til_name.editText?.text.toString()
            var surname = til_surname.editText?.text.toString()
            var formEmail = til_form_email.editText?.text.toString()
            var formPassword = til_form_password.editText?.text.toString()


            //VALIDACIONES DE CAMPO NULO
            val validate = Validate()
            if (validate.validarCampoNulo(register_user_name)) til_register_user_name.error = getString(R.string.null_field_error)
            else til_register_user_name.error = ""

            if (validate.validarCampoNulo(name)) til_name.error = getString(R.string.null_field_error)
            else til_name.error = ""

            if (validate.validarCampoNulo(surname)) til_surname.error = getString(R.string.null_field_error)
            else til_surname.error = ""

            if (validate.validarCampoNulo(formEmail)) til_form_email.error = getString(R.string.null_field_error)
            else til_form_email.error = ""

            if (validate.validarFormatoEmail(formEmail)) {
                Toast.makeText(this, "Email verificado!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ingrese un email valido", Toast.LENGTH_SHORT).show()
            }
            if (validate.validarCampoNulo(formPassword)) til_form_password.error = getString(R.string.null_field_error) else til_form_password.error = ""


            //INSERTAMOS LA INFORMACION EN LA DB
            val usuario = Usuario(register_user_name, name, surname, formEmail, formPassword)

            lifecycleScope.launch{

                if (validate.validarCampoNulo(register_user_name) || validate.validarCampoNulo(name) || validate.validarCampoNulo(surname) || validate.validarCampoNulo(formEmail) || validate.validarCampoNulo(formPassword)){

                    Toast.makeText(this@UserRegister, "Error al registrarse", Toast.LENGTH_SHORT).show()
                }
                else{
                    val id = room.daoUsuario().agregarUsuario(usuario)
                    if (id>0) {
                        Log.i("LOG_INSERT_USER", id.toString())

                        Toast.makeText(this@UserRegister, "Usuario registrado", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@UserRegister, UserLogin::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}