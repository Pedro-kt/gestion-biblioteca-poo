import java.sql.SQLException

class GestorLibrosDB {

    fun mostrarInformacion() {

        val conexion = ConexionDB().conectarDB()

        val consulta = "SELECT * FROM libros"
        val statement = conexion?.createStatement()

        try {
            val resultado = statement?.executeQuery(consulta)

            while (resultado?.next() == true) {
                val idLibro = resultado.getInt("id")
                val titulo = resultado.getString("titulo")
                val autor = resultado.getString("autor")
                val genero = resultado.getString("genero")
                val añoDePublicacion = resultado.getInt("añoPublicacion")
                val disponible = resultado.getBoolean("disponible")

                println("ID del Libro: $idLibro")
                println("Título: $titulo")
                println("Autor: $autor")
                println("Género: $genero")
                println("Año de publicación: $añoDePublicacion")
                println("Disponible: ${if (disponible) "Sí" else "No"}")
                println("-------------")
            }
        } catch (e: SQLException) {
            println("Error al ejecutar la consulta: ${e.message}")
        } finally {
            statement?.close()
            ConexionDB().desconectar()
        }

    }

    fun marcarComoDisponible() {
        //disponible (1) no disponible (0)
    }

    fun filtrarPorAutor() {

    }

    fun filtrarPorDisponible() {

    }

    fun filtrarPorGenero() {

    }

    fun traerLibroPorID(id: Int) {
        val conexion = ConexionDB().conectarDB()

        val consulta = "SELECT * FROM libros WHERE id = $id"
        val statement = conexion?.createStatement()

        try {
            val resultado = statement?.executeQuery(consulta)

            while (resultado?.next() == true) {
                val idLibro = resultado.getInt("id")
                val titulo = resultado.getString("titulo")
                val autor = resultado.getString("autor")
                val genero = resultado.getString("genero")
                val añoDePublicacion = resultado.getInt("añoPublicacion")

                println("ID del Libro: $idLibro")
                println("Título: $titulo")
                println("Autor: $autor")
                println("Género: $genero")
                println("Año de publicación: $añoDePublicacion")
                println("-------------")
            }
        } catch (e: SQLException) {
            println("Error al ejecutar la consulta: ${e.message}")
        } finally {
            statement?.close()
            ConexionDB().desconectar()
        }
    }
}