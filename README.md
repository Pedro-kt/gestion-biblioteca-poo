# Gestión de Biblioteca (Kotlin - Terminal)

Este es un sistema de gestión de biblioteca desarrollado en Kotlin con enfoque en la programación orientada a objetos. Permite registrar usuarios, iniciar sesión, y realizar acciones basicas como (pedir prestado un libro, devolver un libro, visualizar los libros almacenados en la biblioteca, listar los libros que el usuario tiene prestado, etc). El objetivo es simular el funcionamiento básico de una biblioteca desde la terminal, y está pensado como un proyecto de aprendizaje personal.

## ¿Cómo probarlo?

Clonar el repositorio:

git clone https://github.com/Pedro-kt/gestion-biblioteca-poo.git

## Requisitos:

Asegurate de tener instalado:

- Kotlin

- IntelliJ IDEA para abrir el proyecto (preferentemente, ya que esta siendo desarrollado ahí).

- SQLite (si no lo tienen, sigan los pasos de abajo):

  En Linux (Debian/Ubuntu) ejecuten este comando en la terminal:

      - sudo apt install sqlite3

    O usar alguna herramienta gráfica como DB Browser for SQLite para ver/editar la base de datos.

- Verificar que el archivo de base de datos esté en la carpeta db/ dentro del proyecto.

- Ejecutar el programa desde main.kt

## 🚀 Tecnologías utilizadas

- Kotlin
- IntelliJ IDEA
- Programación orientada a objetos
- Org.json (para parseo de JSON)
- SQLite

## ✨ Funcionalidades 

- Crear Usuario, con validador de contraseña basico (No tiene persistencia de datos)
- Inicio de sesión con verificación desde archivo .json
- Tomar prestado un libro
- Devolver un libro
- Mostrar informacion de los libros en biblioteca
- Mostrar la cantidad de libros que tiene prestados el usuario
- Sistema de login
- Persistencia del estado de disponibilidad al pedir un libro y al devolverlo.

## ⚙️ Funcionalidades en Desarrollo
- Filtros de busqueda de libros (por autor, año, genero, etc)

## 📦 Refactorizaciones realizadas

- Refactorización de logica antigua que manejaba los libros en memoria.
- Separación de responsabilidades: ahora Libro es solo un modelo, y GestorLibroDB se encarga del acceso a datos.
- Refactorizacion de la estructura, preparada para ampliar con nuevas funciones a futuro
- Separacion de logica, en clases / funciones especificas
- Mejoras en la experiencia de usuarios
- Control / manejo de errores que causaban crasheo
- Refactorizacion en los metodos " tomarPrestados() y devolverLibro() " de la Clase Usuario
- Metodos añadidos en la Clase GestorLibrosDB
- Correccion de error critico al momento de conectarse a la DB, (la DB habria una conexion, pero no se cerraba, esto era causado por un error en el manejo del objeto)

## 🔍 Funcionalidades a agregar a futuro

- Sin planificacion por el momento

## 📊 Diagramas de flujo

Agregaré diagramas a lo largo del tiempo, estos diagramas explican el funcionamiento interno de algunos métodos y/o funciones importantes del sistema, esto ayudará a comprender mejor la logica del sistema.

[DIAGRAMAS...](docs/diagrams)

## 🧑‍💻 Autor
Pedro Bustamante (GitHub: [Pedro-kt](https://github.com/Pedro-kt))
