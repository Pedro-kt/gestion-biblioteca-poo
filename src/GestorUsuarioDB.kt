import java.sql.SQLException

class GestorUsuarioDB {

    fun elegirLibro() : Libro? {

        val conector = ConexionDB().conectarDB()

        val consulta = "SELECT * FROM libros WHERE disponible = 1"

        val statement = conector?.createStatement()

        var objetoLibro: Libro? = null
        try {
            val resultSet = statement?.executeQuery(consulta)

            println("Libros disponibles: \n")

            while (resultSet?.next() == true) {
                val idLibro = resultSet.getInt("id")
                val titulo = resultSet.getString("titulo")
                val autor = resultSet.getString("autor")
                val genero = resultSet.getString("genero")
                val añoDePublicacion = resultSet.getInt("añoPublicacion")
                //val disponible = resultSet.getBoolean("disponible")

                println("ID del Libro: $idLibro")
                println("Título: $titulo")
                println("Autor: $autor")
                println("Género: $genero")
                println("Año de publicación: $añoDePublicacion")
                //println("Disponible: ${if (disponible) "Sí" else "No"}")
                println("-------------")
            }

            print("Ingrese el ID del libro: ")
            val idIngresado: Int = readln().toInt()

            val consulta = "SELECT * FROM libros WHERE id = $idIngresado"
            val statement = conector?.createStatement()

            val resultado = statement?.executeQuery(consulta)

            println("\nLibro que tomará prestado: \n")

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
                println("Año de publicación: $añoDePublicacion \n")

                objetoLibro = Libro(titulo,autor,añoDePublicacion,genero)

                Usuario().librosPrestados.add(objetoLibro)

                return objetoLibro
            }
        } catch (e: SQLException) {
            println("Error al realizar la consulta ${e.message}")
        } finally {
            statement?.close()
            ConexionDB().desconectar()
        }

        return objetoLibro
    }

}