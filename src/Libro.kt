data class Libro(
    //constructor parametrizado y principal
     val id: Int,
     val titulo: String = "",
     val autor: String = "",
     val añoPublicacion: Int = 0,
     val genero: String = "",
     var disponible: Boolean = true
) {

}