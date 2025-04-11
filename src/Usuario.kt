class Usuario(
    //constructor parametrizado y principal
    val nombre:String,
    val idUsuario:Int,
    val librosPrestados: MutableList<Libro> = mutableListOf()
) {
    fun tomarPrestados(libro: Libro) {
        if (libro.disponible) {
            librosPrestados.add(libro)
            println("El usuario $nombre, ha tomado el libro con los siguientes datos, ${libro.mostrarInfo()
            }")
            libro.marcarComoPrestado()
        } else  {
            println("El libro que el usuario: $nombre requiere, no se encuentra disponible")
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