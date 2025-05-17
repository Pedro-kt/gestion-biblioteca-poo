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

                librosPrestados.add(libro!!)

                GestorLibrosDB().marcarComoPrestrado(libro.id)

                mostrarLibrosPrestados()

                println("Volviendo al menu... \n")
                return ejecutarAccionSegunOpcion(this)
            }
            "no" -> {
                println("\nVolviendo al menu... \n")
                return ejecutarAccionSegunOpcion(this)
            }
        }

    }

    //Refactorizar este metodo, para que se acople a la db
    fun devolverLibro() {

        val cantidadLibros: Int = librosPrestados.size

        when (cantidadLibros) {

            0 -> {
                println("\nEl usuario no tiene libros prestados \n")
                println("Volviendo al menu... \n")
                return ejecutarAccionSegunOpcion(this)
            }
            else -> {
                println("El usuario tiene $cantidadLibros libros en su poder \n")

                for (libro in librosPrestados) {
                    println("Id: ${libro.id} \nTitulo: ${libro.titulo} \nAutor: ${libro.autor} \n")
                }

                println("Ingrese el Id del libro a devolver...")
                val libroId: Int = readln().trim().toInt()

                val libroAEncontrar: Libro? = librosPrestados.find { it.id == libroId }

                if (libroAEncontrar != null) {
                    librosPrestados.remove(libroAEncontrar)
                    println("El libro ha sido devuelto correctamente...")

                    GestorLibrosDB().marcarComoPrestrado(libroId)

                    mostrarLibrosPrestados()

                } else {
                    println("No se ha encontrado un libro con el id indicado anteriormente en sus devoluciones pendientes")
                }

                println("Volviendo al menu... \n")
                return ejecutarAccionSegunOpcion(this)

            }
        }

    }

    fun mostrarLibrosPrestados() {

        if (librosPrestados.isEmpty()) {
            println("\nEl usuario no tiene libros prestados en este momento, vuelva al menu para pedir prestado un libro... \n")
        } else {
            println("Libros que el usuario tiene prestado: \n")
            for (libro in librosPrestados) {
                println("Titulo: ${libro.titulo} \n")
            }
        }
    }

}