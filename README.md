# Deber 7 de Programación

## Descripción 
El código Java proporcionado en su conjunto se centra en la creación de una aplicación que interactúa con una base de datos PostgreSQL relacionada con un sistema de Fórmula 1. Contiene varios modelos que representan entidades clave del sistema, como `ConstructorsResult`, `DriverMaxPoint`, `DriverResult`, `Season`, `Driver`, y `Circuit`. Estos modelos encapsulan los atributos y comportamientos de los constructores, pilotos, temporadas y circuitos. Además, cada modelo tiene métodos getters y setters para acceder y modificar sus atributos. La lógica de negocio y las operaciones de base de datos están manejadas por múltiples repositorios, como `CircuitRepository`, `ConstructorsResultRepository`, `DriverResultRepository`, `QueryRepository` y `SeasonRepository`, que contienen métodos para realizar consultas y operaciones CRUD (Crear, Leer, Actualizar, Borrar) específicas en la base de datos.

Cada repositorio gestiona un conjunto específico de tareas relacionadas con las entidades del modelo. Por ejemplo, `CircuitRepository` maneja la inserción y recuperación de circuitos, `ConstructorsResultRepository` y `DriverResultRepository` manejan la recuperación de resultados de constructores y pilotos respectivamente, y `QueryRepository` ejecuta consultas generales como obtener los 10 pilotos o constructores con más puntos. `SeasonRepository` se encarga de la recuperación de temporadas y años disponibles en la base de datos. En resumen, el código proporciona una estructura robusta para la gestión y consulta de datos de Fórmula 1, facilitando la interacción con la base de datos PostgreSQL a través de una serie de clases de modelo y repositorios bien definidas.

## Capturas
![image](https://github.com/user-attachments/assets/09c9eb63-4ca1-41fa-b0db-eb3ecfa3e097)
![image](https://github.com/user-attachments/assets/94485caa-846e-41ac-be7b-de700fa0ea7c)
![image](https://github.com/user-attachments/assets/ffa5c3c6-0e2f-4784-9b75-f105ab1ca6e3)
![image](https://github.com/user-attachments/assets/3fc645a8-102f-4de0-8403-3e421656ec1c)
![image](https://github.com/user-attachments/assets/0e111c40-21dd-4676-b58a-810c6dcc3d7d)





