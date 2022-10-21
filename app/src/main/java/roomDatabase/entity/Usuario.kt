package roomDatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Usuario {

    @PrimaryKey
    var usuario: String
    var nombre: String? = null
    var apellido: String? = null
    var correo: String? = null
    var contrasena: String? = null

    constructor(usuario: String, nombre:String, apellido:String, correo:String ,contrasena:String){
        this.usuario = usuario
        this.nombre = nombre
        this.apellido = apellido
        this.correo = correo
        this.contrasena = contrasena
    }
}