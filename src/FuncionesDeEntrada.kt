//Funciones de entrada al programa

//Funcion de saludar
fun saludoBienvenida() = println("Bienvenido/a al sistema de gestion de biblioteca")

fun crearCuentaEnSistema() {
    println("Entonces, creemos una cuenta!")
    print("Ingrese su nombre: ")
    val nombre: String = readln()
    print("Ingrese su apellido: ")
    val apellido: String = readln()
    print("Ingrese su nombre de usuario, (Nombre con el cual navegara por el sistema): ")
    val nombreUsuario: String = readln()
    print("Ingrese una contraseña valida (Esta misma debe tener mas de 4 caracteres): ")
    var contraseña: String

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

    val usuario = Usuario(nombre, apellido, nombreUsuario, contraseña)

    println("Se ha creado una cuenta correctamente")
    println("Nombre de Usuario: $nombreUsuario")
    println("Contraseña: $contraseña")
}

//Funcion que determina si el ususario tiene cuenta o no
fun validadorDeCuenta() {
    println("¿Tiene una cuenta en el sistema?")
    println("Responder: Si / No")
    print("Respuesta: ")

    val respuesta: String = readln().lowercase()

    if (respuesta == "si") {
        println("Ingrese nombre de 'Usuario' y su 'Contraseña' para logearse")
    } else if (respuesta == "no") {
        crearCuentaEnSistema()
    } else if (respuesta == null) {
        println("Incorrecto intente de nuevo")
    }

}


//Funcion breve descripcion del programa
fun descripcionDeSistema() = println("Dentro del sistema usted puede:")

//Funcion que se encarga de mostrar las opciones que tiene para realizar el sistema
fun opcionesDelSistema() {

    //Opciones de accion en el programa
    val opciones = listOf(
        "- Tomar prestado un libro, ingrese: 1",
        "- Devolver un libro, ingrese: 2",
        "- Pedir informacion del libro, ingrese: 3",
        "- Mostrar la cantidad de libros que tiene prestado el usuario, ingrese: 4"
    )

    //iterador de la lista opciones, para imprimir en pantalla las opciones que tiene el sistema para brindar
    for (verOpciones in opciones) {
        println(verOpciones)
    }
}

//Funcion que muestra la entrada al programa
fun mostrarEntrada() {
    saludoBienvenida()
    validadorDeCuenta()
    descripcionDeSistema()
    opcionesDelSistema()
}

//Palabra clave que vuelve al inicio del sistema
fun inicio() {
    val palabraClave: String = "Inicio"
}

//Variable que usaremos para decidir las diferentes acciones dentro del sistema
/*val opcion = readln().toInt()

//Funcion donde decidiremos el camino del sistema
fun comprobarNumeroValido() {
    if (opcion in 1..5) {
        when (opcion) {
        }
    }
}

 */