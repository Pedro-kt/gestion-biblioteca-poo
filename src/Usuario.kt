class Usuario (
    //constructor parametrizado y principal
    val nombre: String = "",
    val apellido: String = "",
    val nombreUsuario: String = "",
    val contraseña: String = "",
    val librosPrestados: MutableList<Libro> = mutableListOf()
) {
    fun tomarPrestados() {
        println("Elija el libro que quiere tomar prestado, para tomar prestado un libro ingrese el ID correspondiente del mismo \n")

        GestorLibrosDB().filtrarPorDisponible()

        println("¿Seguro que quiere tomar prestado un libro? \nIngrese [Si / No]")

        val respuesta: String = readln().trim().lowercase()

        when (respuesta) {
            "si" -> {

                val libro = GestorUsuarioDB().elegirLibro()

                println("El usuario tomo prestado el libro $libro")
            }
        }

    }

    fun devolverLibro(libro: Libro) {
        if (libro.disponible) {
            librosPrestados.remove(libro)
            println("Se ha devuelto el libro a la biblioteca")
        }

    }

    fun mostrarLibrosPrestados() {
        println("Libros que el usuario tiene prestado:")
        for (libro in librosPrestados) {
            println(libro.titulo)
        }
    }

}