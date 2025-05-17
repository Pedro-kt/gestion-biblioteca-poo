import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

class ConexionDB {
    //url de conexion a la base de datos
    val url = "jdbc:sqlite:/home/bustamante/IdeaProjects/gestion-biblioteca-poo/db/biblioteca?busy_timeout=5000"

    //variable que mantiene la conexion
    var conexion: Connection? = null

    //metodo para conectar
    fun conectarDB(): Connection? {

        println("\nEl sistema se esta conectando a la base de datos...")

        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(url)
                println("Conexion a la base de datos satisfactoria... \n")
            } catch (e: SQLException) {
                println("Error de conexion: ${e.message} \n")
            }
        }
        return conexion
    }

    //metodo para desconectar
    fun desconectar() {

        println("\nCerrando la base de datos...")

        try {
            conexion?.close()
            println("Se cerro con exito la base de datos... \n")
        } catch (e: SQLException) {
            println("Error al cerrar la conexion ${e.message} \n")
        }
    }

}