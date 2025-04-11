//Funciones de entrada al programa

//Funcion de saludar
fun saludoBienvenida() = println("Bienvenido/a al sistema de gestion de biblioteca")

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
    descripcionDeSistema()
    opcionesDelSistema()
}

//Palabra clave que vuelve al inicio del sistema
fun inicio() {
    val palabraClave: String = "Inicio"
}

//Variable que usaremos para decidir las diferentes acciones dentro del sistema
val opcion = readln().toInt()

//Funcion donde decidiremos el camino del sistema
fun comprobarNumeroValido() {
    if (opcion in 1..5) {
        when (opcion) {
        }
    }
}