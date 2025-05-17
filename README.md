# Gestión de Biblioteca (Kotlin - Terminal)

Este es un sistema de gestión de biblioteca desarrollado en Kotlin con enfoque en la programación orientada a objetos. Permite registrar usuarios, iniciar sesión, y visualizar los libros disponibles almacenados en una base de datos SQLite. El objetivo es simular el funcionamiento básico de una biblioteca desde la terminal, y está pensado como un proyecto de aprendizaje personal.

## ¿Cómo probarlo?

Clonar el repositorio:

git clone https://github.com/Pedro-kt/gestion-biblioteca-poo.git

## Requisitos:

Asegurate de tener instalado:

- Kotlin

- IntelliJ IDEA para abrir el proyecto (preferentemente, ya que esta siendo desarrollado ahí).

- SQLite (si no lo tienen, sigan los pasos de abajo):

  En Linux (Debian/Ubuntu):

    - sudo apt install sqlite3

  O usar alguna herramienta gráfica como DB Browser for SQLite para ver/editar la base de datos.

- Verificar que el archivo de base de datos esté en la carpeta db/ dentro del proyecto.

- Ejecutar el programa desde main.kt

## 🚀 Tecnologías utilizadas

- Kotlin
- IntelliJ IDEA
- Programación orientada a objetos
- Org.json (para parseo de JSON)

## ✨ Funcionalidades

- Registro de usuarios con validaciones básicas.
- Inicio de sesión con verificación desde archivo .json
- Tomar prestado un libro (Mediante instancia de clase)
- Devolver un libro (Mediante instancia de clase)
- Mostrar informacion del libro
- Mostrar la cantidad de libros que tiene el usuario en su poder
- Crear Usuario, con validador de contraseña
- Sistema de login v1

## ⚙️ Funcionalidades en Desarrollo

- Préstamo de libros por parte de los usuarios.
- Listar libros disponibles en la biblioteca
- Persistencia del estado de disponibilidad al pedir un libro.
- Refactorización de logica antigua que manejaba los libros en memoria.

## 📦 Refactorizaciones realizadas

- Eliminación de código que gestionaba libros en listas locales.
- Separación de responsabilidades: ahora Libro es solo un modelo, y GestorLibroDB se encarga del acceso a datos.
- Estructura preparada para ampliar con nuevas funciones a futuro

## 🔍 Funcionalidades a agregar a futuro

- Mejoras en el login (Validacion, control de errores, refactorización, y mejoras varias)
- Filtros de busqueda (por autor, año, genero, etc)
- Mejoras en la experiencia de usuarios
- entre otros

## 📊 Diagramas de flujo

Estos diagramas explican el funcionamiento interno de algunos métodos importantes del sistema.

[Diagramas...](docs/diagrams)

## 🧑‍💻 Autor
Pedro (GitHub: [Pedro-kt](https://github.com/Pedro-kt))
