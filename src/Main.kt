//Gestion de Biblioteca


class Libro(
    //constructor parametrizado y principal
    val titulo:String,
    val autor:String,
    val fechaPublicacion:Int,
    val genero:String,
    var disponible:Boolean = true
) {

    fun marcarComoDisponible() {
        disponible = true
        println("El libro se encuentra disponible")
    }

    fun marcarComoPrestado() {
        disponible = false
        println("El libro se encuentra prestado, no disponible en biblioteca")
    }

    fun mostrarInfo(): String {
        return """
        Titulo: $titulo
        Autor: $autor
        Fecha de Publicacion: $fechaPublicacion
        Genero del Libro: $genero
    """.trimIndent()
    }

}

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

class Biblioteca(
    val catalogo: MutableList<Libro> = mutableListOf()
) {

}

//Funciones de entrada al programa

//Funcion de saludar
fun saludoBienvenida() = println("Bienvenido/a al sistema de gestion de biblioteca")

//Funcion breve descripcion del programa
fun descripcionDeSistema() = println("Dentro del sistema usted puede:")

fun opcionesDelSistema() {

    //Opciones de accion en el programa
    val opciones = listOf(
        "- Tomar prestado un libro",
        "- Devolver un libro",
        "- Pedir informacion del libro"
    )

    //iterador de la lista opciones, para imprimir en pantalla las opciones que tiene el sistema para brindar
    for (verOpciones in opciones) {
        println(verOpciones)
    }
}

//Funcion que muestra la entrada al programa
fun mostrarEntrada() {
    saludoBienvenida()
    descripcionDeSistema()
    opcionesDelSistema()
}

fun main() {

    mostrarEntrada()

    //Libros

    val libro1 = Libro("Cien años de soledad", "Gabriel Garcia Marquez", 1967, "Realismo magico")
    val libro2 = Libro("1984", "George Orwell", 1949, "Ciencia Ficcion, Distopia")
    val libro3 = Libro("Orgullo y prejuicio", "Jane Austen", 1813, "Romance, Drama")
    val libro4 = Libro("El nombre del viento", "Patrick Rothfuss", 2007, "Fantasia")
    val libro = Libro("Los pilares de la tierra", "Ken Follett", 1989, "Novela historica")

    //Usuarios
    val usuario1 = Usuario("Pepito", 0)
    val usuario2 = Usuario("Pepita", 1)
    val usuario3 =  Usuario("Ramiro", 2)

    usuario1.tomarPrestados(libro1)
    usuario1.mostrarLibrosPrestados()
}