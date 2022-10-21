package roomDatabase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import roomDatabase.entity.Usuario

@Dao
interface DaoUsuario {
    //METODO PARA OBTENER LA INFO
    @Query("SELECT * FROM Usuario")
    //suspend son las corrutinas estas son una de las características más impresionantes de Kotlin is simply a function that can be paused and resumed
    suspend fun obtenerUsuario(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE usuario=:usuario")
    suspend fun obtenerUsuario(usuario: String):Usuario

    //=: nos permite parametrizar
    @Query("SELECT * FROM Usuario WHERE usuario=:usuario AND contrasena=:contrasena")
    suspend fun login(usuario: String, contrasena: String): List<Usuario>

    @Insert
    suspend fun agregarUsuario(usuario: Usuario):Long

    @Query("UPDATE  Usuario SET nombre=:nombre, apellido=:apellido, correo=:correo, contrasena=:contrasena WHERE usuario=:usuario")
    suspend fun actualizarUsuario(usuario: String, nombre:String,apellido: String, correo: String ,contrasena:String): Int

    @Query("DELETE FROM Usuario WHERE usuario=:usuario")
    suspend fun borrarUsuario(usuario: String)

}