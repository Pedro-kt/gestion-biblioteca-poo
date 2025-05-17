import java.sql.SQLException

class GestorLibrosDB {

    fun mostrarInformacion() {
        val conexionDB = ConexionDB()
        val conexion = conexionDB.conectarDB()

        val query = "SELECT * FROM libros"
        val statement = conexion?.createStatement()

        try {
            val resultado = statement?.executeQuery(query)

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
            conexionDB.desconectar()
        }

    }

    fun traerLibroPorID(id: Int) {
        val conexionDB = ConexionDB()
        val conexion = conexionDB.conectarDB()

        val query = "SELECT * FROM libros WHERE id = $id"
        val statement = conexion?.createStatement()

        try {
            val resultado = statement?.executeQuery(query)

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
            conexionDB.desconectar()
        }
    }

    fun marcarComoDisponible(id: Int) {
        val conexionDB = ConexionDB()
        val conexion = conexionDB.conectarDB()

        try {
            val query = "UPDATE libros SET disponible = 1 WHERE id = ?"
            val statement = conexion?.prepareStatement(query)
            statement?.setInt(1, id)
            statement?.executeUpdate()
            statement?.close()
        } catch (e: SQLException) {
            println("Error al actualizar disponibilidad: ${e.message}")
        } finally {
            conexionDB.desconectar()
        }
    }

    fun marcarComoPrestrado(id: Int) {
        val conexionDB = ConexionDB()
        val conexion = conexionDB.conectarDB()

        try {
            val sql = "UPDATE libros SET disponible = 0 WHERE id = ?"
            val statement = conexion?.prepareStatement(sql)
            statement?.setInt(1, id)
            statement?.executeUpdate()
            statement?.close()
        } catch (e: SQLException) {
            println("Error al actualizar disponibilidad: ${e.message}")
        } finally {
            conexionDB.desconectar()
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

}