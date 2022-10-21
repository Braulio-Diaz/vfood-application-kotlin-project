package com.example.v_foodapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class CategoryCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_create)

        val til_category_create = findViewById<TextInputLayout>(R.id.til_category_create)
        val btn_category_create = findViewById<Button>(R.id.btn_category_create)

        //CREAR FECHAS SENCILLAS
        val til_date_create_category = findViewById<TextInputLayout>(R.id.til_date_create_category)
        val til_hour_create_category = findViewById<TextInputLayout>(R.id.til_hour_create_category)

        val cal = Calendar.getInstance() //Obtener instancia

        val listenerFecha = DatePickerDialog.OnDateSetListener {
                datePicker, anyo, mes, dia -> til_date_create_category.editText?.setText("$dia/$mes/$anyo")
        }
        val listenerHora = TimePickerDialog.OnTimeSetListener {
                timePicker, hora, minuto ->  til_hour_create_category.editText?.setText("$hora:$minuto")
        }

        til_date_create_category.editText?.setOnClickListener {
            DatePickerDialog(this,listenerFecha,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(
                Calendar.DAY_OF_MONTH)).show()
        }

        til_hour_create_category.editText?.setOnClickListener {
            TimePickerDialog(this@CategoryCreate,listenerHora,cal.get(Calendar.HOUR_OF_DAY),cal.get(
                Calendar.MINUTE),false).show()
        }





        btn_category_create.setOnClickListener {

            var category_create = til_category_create.editText?.text.toString()
            var date_create_category = til_date_create_category.editText?.text.toString()
            var hour_create_category = til_hour_create_category.editText?.text.toString()
            var validate = Validate()

            if (validate.validarCampoNulo(category_create)) til_category_create.error = getString(R.string.null_field_error) else til_category_create.error = ""
            if (validate.validarCampoNulo(date_create_category)) til_date_create_category.error = getString(R.string.null_field_error) else til_date_create_category.error = ""
            if (validate.validarCampoNulo(hour_create_category)) til_hour_create_category.error = getString(R.string.null_field_error) else til_hour_create_category.error = ""

            Toast.makeText(this@CategoryCreate, "Cateogría creada", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@CategoryCreate,Category::class.java)
            startActivity(intent)
        }
    }
}