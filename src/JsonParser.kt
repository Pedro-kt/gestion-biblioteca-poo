import org.json.JSONArray
import org.json.JSONObject
import java.io.File

fun cargarUsuariosDesdeJson(rutaArchivo: String): List<Usuario> {
    val usuarios = mutableListOf<Usuario>()

    // Leer todo el contenido del archivo como texto
    val contenido = File(rutaArchivo).readText()

    // Parsear el contenido a un JSONArray
    val jsonArray = JSONArray(contenido)

    // Recorrer cada objeto dentro del JSONArray
    for (i in 0 until jsonArray.length()) {
        val objeto = jsonArray.getJSONObject(i)

        val nombre = objeto.getString("nombre")
        val apellido = objeto.getString("apellido")
        val nombreUsuario = objeto.getString("nombreUsuario")
        val contraseña = objeto.getString("contraseña")

        // Crear un objeto Usuario y agregarlo a la lista
        val usuario = Usuario(nombre, apellido, nombreUsuario, contraseña)
        usuarios.add(usuario)
    }

    return usuarios
}
