# ForoHub
ForoHub es un proyecto de API REST desarrollado con Spring Boot para replicar el funcionamiento de un foro backend. El objetivo es permitir a los usuarios interactuar con los tópicos mediante operaciones CRUD (Crear, Leer, Actualizar, Eliminar). Esta API proporciona un entorno donde los participantes pueden plantear preguntas y colaborar entre ellos.

## Descripción
Un foro es un espacio donde todos los participantes de una plataforma pueden plantear sus preguntas sobre determinados tópicos. 
ForoHub se enfoca en la gestión de tópicos del foro, permitiendo a los usuarios realizar las siguientes operaciones:

Crear un nuevo tópico
Mostrar todos los tópicos creados
Mostrar un tópico específico
Actualizar un tópico
Marcar un topico como Resuelto
Eliminar un tópico

### Características
API REST: Implementación de rutas siguiendo las mejores prácticas del modelo REST.
CRUD : Operaciones para Crear, Leer, Actualizar y Eliminar tópicos.
Validaciones: Realización de validaciones según las reglas de negocio.
Base de Datos Relacional: Uso de una base de datos relacional para almacenar la información.
Autenticación/Autorización: Servicio para restringir el acceso a la información.

### Tecnologías Utilizadas
* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven

## Endpoints de la API
#### Crear un nuevo tópico
* URL: /api/topicos
* Método: POST 
* Body: JSON con los detalles del tópico:
```
{
    "titulo": "Título del tópico",
    "mensaje": "Mensaje del tópico",
    "autor": "Autor del tópico",
    "curso": "CURSO"
}
```
#### Mostrar todos los tópicos
* URL: /api/topicos
* Método: GET
#### Mostrar un tópico específico 
* URL: /api/topicos/{id}
* Método: GET
#### Actualizar un tópico
* URL: /api/topicos/{id}
* Método: PUT
* Body: JSON con los detalles actualizados del tópico
```
{
    "titulo": "Título actualizado del tópico",
    "mensaje": "Mensaje actualizado del tópico",
}
```

#### Eliminar un tópico
* URL: /api/topicos/{id}
* Método: DELETE
