//Funciones de entrada al programa

//Funcion de saludar
fun saludoBienvenida() = println("Bienvenido/a al sistema de gestion de biblioteca")

//Funcion que determina si el ususario tiene cuenta o no, y redirecciona segun corresponda devolviendo siempre un Usuario
fun validarOCrearCuenta(): Usuario {
    println("¿Tiene una cuenta en el sistema?")
    println("Responder: Si / No")
    print("Respuesta: ")

    val respuesta: String = readln().lowercase()

    //en funcionamiento solo la rama else if!

    return if (respuesta == "si") {
        println("Ingrese nombre de 'Usuario' y su 'Contraseña' para logearse")
        loginEnSistema(usuario = )
        //se implementa la funcion crear cuenta a fin de testing, proximamente a desarrollar la funcion de logueo
    } else if (respuesta == "no") {
        crearCuentaEnSistema()
    } else {
        println("Incorrecto intente de nuevo")
        crearCuentaEnSistema()
    }

}

//Funcion que permite crear una cuenta en el sistema y devuelve el usuario creado
fun crearCuentaEnSistema(): Usuario {
    println("Entonces, creemos una cuenta!")

    print("Ingrese su nombre: ")
    val nombre: String = readln()

    print("Ingrese su apellido: ")
    val apellido: String = readln()

    print("Ingrese su nombre de usuario, (Nombre con el cual navegara por el sistema): ")
    val nombreUsuario: String = readln()

    print("Ingrese una contraseña valida (Esta misma debe tener mas de 4 caracteres): ")
    var contraseña: String

    //Bucle que valida contraseña (mayor a 4 caracteres para crear contraseña)
    do {
        val validarcontraseña: String = readln()
        contraseña = validarcontraseña
        if (contraseña.length < 4) {
            println("Contraseña no valida, esta debe contener mas de 4 caracteres")
        } else {
            println("Contraseña valida...")
            break
        }
    } while (contraseña.length < 4)

    //Instanciacion de la clase usuario para la creacion del objeto
    val usuarioCreado = Usuario(nombre, apellido, nombreUsuario, contraseña)

    println("Se ha creado una cuenta correctamente")
    println("Nombre de Usuario: $nombreUsuario")
    println("Contraseña: $contraseña")

    return usuarioCreado
}

fun loginEnSistema(usuario: Usuario) {
    println("Para loguearse necesita ingresar su 'Nombre de usuario' y su 'Contraseña'")
    println("Ingrese su nombre de usuario: ")
    val nombreUsuario: String = readln()

    println("Ingrese su contraseña")
    val contraseña: String = readln()

    val cuentaUsuario = Usuario(nombreUsuario = nombreUsuario, contraseña = contraseña)

    val usuarioComparado = return if (nombreUsuario == usuario.nombreUsuario || contraseña == usuario.contraseña) {
        println("Datos correctos, bienvenido $nombreUsuario")
        return
    } else {
        println("Datos incorrectos, ingrese nuevamente")
        return
    }
}

//Funcion que se encarga de mostrar las opciones que tiene para realizar el sistema
fun mostrarOpcionesDelSistema() {

    println("Dentro del sistema usted puede:")

    //Opciones de accion en el programa
    val opciones = listOf(
        "- Tomar prestado un libro, ingrese: 1",
        "- Devolver un libro, ingrese: 2",
        "- Pedir informacion de un libro, ingrese: 3",
        "- Mostrar la cantidad de libros que tiene prestado el usuario, ingrese: 4"
    )

    //iterador de la lista opciones, para imprimir en pantalla las opciones que tiene el sistema para brindar
    for (verOpciones in opciones) {
        println(verOpciones)
    }
}


//Funcion que toma la opcion que quiere realizar el usuario y ejecuta la accion segun corresponda, en funcionamiento solo el item de tomar prestado un libro!
fun ejecutarAccionSegunOpcion(usuario: Usuario, libro: Libro) {
    val numeroIngresado = readln().toInt()
    when (numeroIngresado) {
        1 -> {
            usuario.tomarPrestados(libro)
        }
        2 -> {
            val cantidadDeLibro = usuario.librosPrestados.size

            when (cantidadDeLibro) {
                0 -> println("Usted no posee libros prestados por la biblioteca")
                else -> {
                    println("¿Que libro quiere devolver?")
                    usuario.mostrarLibrosPrestados()
                    usuario.devolverLibro(libro)
                }
            }
        }
        3 -> {
            libro.mostrarInfo()
        }
        4 -> {
            usuario.mostrarLibrosPrestados()
        }
        else -> {
            println("Caracter no valido, intente con otro")
        }
    }
}

//Palabra clave que vuelve al inicio del sistema
fun volverAlInicio() { val palabraClave: String = "Inicio"}


//Funcion que muestra la entrada al programa
fun mostrarInterfazDeEntrada() {

    saludoBienvenida()
    val usuarioActivo = validarOCrearCuenta()
    mostrarOpcionesDelSistema()
    ejecutarAccionSegunOpcion(usuarioActivo, libro = Libro("Cien años de soledad", "Gabriel Garcia Marquez", 1967, "Realismo magico"))

}
