package com.example.v_foodapplication

import android.util.Patterns
import java.util.regex.Pattern

class Validate {

    /**
     * FUNCION PARA VALIDAR SI EL TEXTO ES NULO
     */
    fun validarCampoNulo(texto : String): Boolean{
        return texto.equals("") || texto.length == 0
    }

    /**
     * FUNCION PARA VALIDAR SI ES CORRECTO EL FORMATO DEL NOMBRE SEGUN UNA EXPRESION REGULAR
     */
    fun validarNombre(nombre : String): Boolean{
        val pattern = Pattern.compile("^[a-zA-Z ]+$")
        return pattern.matcher(nombre).matches()
    }

    /**
     * FUNCION QUE VALIDA SI ES CORRECTO EL FORMATO DEL NOMBRE SEGUN UNA EXPRESION REGULAR PREDETERMINADA
     */
    fun validarFormatoEmail(correo : String): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    }
}