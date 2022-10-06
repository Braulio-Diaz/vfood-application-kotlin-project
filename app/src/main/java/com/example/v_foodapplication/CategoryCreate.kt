package com.example.v_foodapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class CategoryCreate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_create)

        val til_category_create = findViewById<TextInputLayout>(R.id.til_category_create)
        val til_categoy_date = findViewById<TextInputLayout>(R.id.til_categoy_date)
        val btn_category_create = findViewById<Button>(R.id.btn_category_create)
        til_categoy_date.editText?.setOnClickListener { v -> showDatePickerDialog() }

        btn_category_create.setOnClickListener {

            var category_create = til_category_create.editText?.text.toString()
            var category_date = til_categoy_date.editText?.text.toString()
            var validate = Validate()

            if (validate.validarCampoNulo(category_create)) til_category_create.error = getString(R.string.null_field_error) else til_category_create.error = ""
            if (validate.validarCampoNulo(category_date)) til_categoy_date.error = getString(R.string.null_field_error) else til_categoy_date.error = ""

            Toast.makeText(this@CategoryCreate, "Cateogría creada", Toast.LENGTH_SHORT).show()

            val intent = Intent(this@CategoryCreate,Category::class.java)
            startActivity(intent)
        }

    }






    //FUNCION PARA MOSTRAR EL DIALOGO
    private fun showDatePickerDialog(){
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day,month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    //FUNCION PARA PONER LA FECHA SELECCIONADA EN EL CAMPO DE TEXTO
    private fun onDateSelected(day:Int, month:Int, year:Int){
        val til_categoy_date = findViewById<TextInputLayout>(R.id.til_categoy_date)
        var daySelected = "$day"
        var monthSelected = (month+1).toString()
        if (day<10){ daySelected = "0$day" }
        if ((month+1)<10){ monthSelected = "0"+(month+1).toString() }
        til_categoy_date.editText?.setText("$daySelected/$monthSelected/$year")
    }
}