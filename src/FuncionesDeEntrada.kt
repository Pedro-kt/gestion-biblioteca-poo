//Funciones de entrada al programa

//Funcion de saludar
fun saludoBienvenida() = println("\nBienvenido/a al sistema de gestion de biblioteca \n")

//Funcion que determina si el ususario tiene cuenta o no, y redirecciona segun corresponda devolviendo siempre un Usuario
fun validarOCrearCuenta(): Usuario {
    while (true) {
        println("=== Menu de Inicio de sesion o registro ===")
        println("¿Tienes una cuenta en el sistema?")
        println("Responder: Si / No")
        print("Respuesta: ")

        val respuesta: String = readln().lowercase()

        if (respuesta == "si") {
            return loginEnSistema()
        } else if (respuesta == "no") {
            return crearCuentaEnSistema()
        } else {
            println("\nIncorrecto intente de nuevo por favor...\n")
        }
    }
}

//Funcion que permite crear una cuenta en el sistema y devuelve el usuario creado
fun crearCuentaEnSistema(): Usuario {
    println("Entonces, creemos una cuenta!")

    println("Ingrese su nombre: ")
    val nombre: String = readln()

    println("Ingrese su apellido: ")
    val apellido: String = readln()

    println("Ingrese su nombre de usuario, (Nombre con el cual navegara por el sistema): ")
    val nombreUsuario: String = readln()

    println("Ingrese una contraseña valida (Esta misma debe tener mas de 4 caracteres): ")
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

fun loginEnSistema() : Usuario {

    val rutaArchivo: String = "/home/bustamante/IdeaProjects/gestion-biblioteca-poo/src/Usuarios.json"

    var usuarioRetornado : Usuario? = null //Asigno la variable a retornar como null, asi almenos me aseguro de que la funcion devuelva algo si o si
    val lista: List<Usuario> = cargarUsuariosDesdeJson(rutaArchivo)
    var contadorErrores: Int = 0

    println("Para iniciar sesion necesita ingresar su 'Nombre de usuario' y su 'Contraseña'")

    while (true) {

        println("\nIngrese su nombre de usuario: ")
        val nombreIngresado: String = readln().trim()

        println("Ingrese su contraseña")
        val contraseña: String = readln().trim()

        for (objetoUsuario in lista) {

            if (nombreIngresado == objetoUsuario.nombreUsuario) {

                if (contraseña == objetoUsuario.contraseña) {
                    println("\nInicio de sesion satisfactorio!, Bienvenido '$nombreIngresado'! \n")
                    usuarioRetornado = Usuario(objetoUsuario.nombre, objetoUsuario.apellido, objetoUsuario.nombreUsuario, objetoUsuario.contraseña)
                    break
                }
            }
        }

        if (usuarioRetornado != null) {
            break
        }

        contadorErrores += 1

        println("\nError!, 'Nombre de usuario' o 'Contraseña' incorrectos... Por favor, intente nuevamente \nCantidad de errores: $contadorErrores de 5")

        if (contadorErrores == 5) {
            println("\nSe llego al maximo de errores permitidos, será redirigido al menu e intente nuevamente. \n")
            return validarOCrearCuenta()
        }

    }

    return usuarioRetornado
}

//Funcion que se encarga de mostrar las opciones que tiene para realizar el sistema
fun mostrarOpcionesDelSistema() {

    //Opciones de accion en el programa
    val opciones = listOf(
        "=== Menu ===",
        "Dentro del sistema usted puede:",
        "- Tomar prestado un libro, ingrese: [ 1 ]",
        "- Devolver un libro, ingrese: [ 2 ]",
        "- Pedir informacion de los libros, ingrese: [ 3 ]",
        "- Mostrar la cantidad de libros que tiene prestado el usuario, ingrese: [ 4 ]",
        "- Salir del sistema: [ 5 ]"
    )

    for (verOpciones in opciones) {
        println(verOpciones)
    }
}

//Funcion que toma la opcion que quiere realizar el usuario y ejecuta la accion segun corresponda
fun ejecutarAccionSegunOpcion(usuario: Usuario) {

    while (true) {

        mostrarOpcionesDelSistema()

        try {
            print("Ingrese su opcion: ")
            val numeroIngresado = readln().toInt()
            when (numeroIngresado) {
                1 -> {
                    usuario.tomarPrestados()
                }
                2 -> {
                    usuario.devolverLibro()
                }
                3 -> {
                    GestorLibrosDB().mostrarInformacion()
                }
                4 -> {
                    usuario.mostrarLibrosPrestados()
                }
                5 -> {
                    val salir = salirDelSistema(usuario)

                    if (salir == true) {
                        break
                    }
                }
                else -> {
                    println("\nCaracter no valido, intente con otro \n")
                }
            }
        } catch (e: NumberFormatException) {
            println("Debe ingresar un numero de acuerdo a la accion a realizar, intente nuevamente... \n")
        }

    }

}

//Funcion que muestra la entrada al programa
fun mostrarInterfazDeEntrada() {

    saludoBienvenida()
    val usuarioActivo: Usuario = validarOCrearCuenta()
    ejecutarAccionSegunOpcion(usuarioActivo)

}

//Funcion que permite salir del sistema si el usuario lo desea
fun salirDelSistema(usuario: Usuario) : Boolean {

    var salir: Boolean = false

    while (true) {
        println("\n¿Seguro que desea salir del sistema? [ Si / No ]")
        print("Respuesta: ")
        val respuesta: String = readln().trim().lowercase()

        when (respuesta) {
            "si" -> {
                println("\nGracias por usar el sistema... Hasta luego '${usuario.nombreUsuario}!'")
                salir = true
                break
            }
            "no" -> {
                println("\nVolviendo al menu... \n")
                break
            }
            else -> {
                println("\nCaracter no valido, intente nuevamente...")
            }
        }
    }
    return salir
}
