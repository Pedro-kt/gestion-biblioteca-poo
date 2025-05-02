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
        println("El libro ahora se encuentra prestado, no disponible en biblioteca")
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