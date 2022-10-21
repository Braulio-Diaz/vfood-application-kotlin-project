package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch
import roomDatabase.Db

class UserLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        //INICIALIZAMOS LA BASE DE DATOS
        val room = Room.databaseBuilder(this, Db::class.java,"database-charizard").allowMainThreadQueries().build()


        //DECLARAMOS LAS VARIABLES Y LAS REFERENCIAMOS CON EL ID INGRESADO EN EL LAYOUT
        val til_login_user = findViewById<TextInputLayout>(R.id.til_login_user)
        val til_password = findViewById<TextInputLayout>(R.id.til_password)
        val btn_register = findViewById<Button>(R.id.btn_register)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val sw_rememberUser = findViewById<Switch>(R.id.sw_rememberUser)

        //LISTENER DE BOTONES
        btn_register.setOnClickListener {
            val intent = Intent(this@UserLogin,UserRegister::class.java)
            startActivity(intent)
        }

        //CAPTURA DATOS Y LOS MUESTRA POR PANTALLA Y LOS VALIDA
        btn_login.setOnClickListener {

            //SE CAPTURAN LOS DATOS INGRESADOS
            var login_user = til_login_user.editText?.text.toString()
            var password = til_password.editText?.text.toString()
            var rememberUser = sw_rememberUser.isChecked


            val validate = Validate()
            /*
          if (validate.validarCampoNulo(login_user)) til_login_user.error = getString(R.string.null_field_error) else til_login_user.error = ""
          if (validate.validarCampoNulo(password)) til_password.error = getString(R.string.null_field_error) else til_password.error = ""

          if (validate.validarFormatoEmail(email)) {
              Toast.makeText(this, "Email verificado!", Toast.LENGTH_SHORT).show()
          } else {
              Toast.makeText(this, "Ingrese un email valido", Toast.LENGTH_SHORT).show()
          }

          //Toast.makeText(this@UserLogin,email+" "+password,Toast.LENGTH_SHORT).show()
          */

            //INSERTAMOS LA INFORMACION EN LA DB
            lifecycleScope.launch{
                val response = room.daoUsuario().login(login_user, password)

                if (response.size == 1){

                    Toast.makeText(this@UserLogin, "Bienvenido "+login_user, Toast.LENGTH_LONG).show()

                    val intent = Intent(this@UserLogin,SplshScreen::class.java)
                    startActivity(intent)
                }
                else if (validate.validarCampoNulo(login_user) || validate.validarCampoNulo(password)){

                    til_login_user.error = getString(R.string.null_field_error)
                    til_password.error = getString(R.string.null_field_error)

                }
                else{
                    til_login_user.error = getString(R.string.incorrect_user_or_password)
                    til_password.error = getString(R.string.incorrect_user_or_password)
                }
            }
        }
    }
}