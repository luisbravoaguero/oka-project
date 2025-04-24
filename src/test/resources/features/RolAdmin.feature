#language: es
@DemoOorangehrmlive
Característica: DemoOorangehrmlive


  Esquema del escenario: Validar que los registros contengan actions editar y eliminar
    Dado que el usuario se conecta a la pagina web DemoOrangehrmlive
    Entonces se muestra el formulario del login
    Y el usuario ingresa el usuario y clave "<user>" "<clave>"
    Y el usuario hace click en el boton LOGIN
    Entonces se muestra la pagina principal del home
    Y se muestra el menu Admin
    Entonces el usuario hace click en el menu Admin
    Entonces se muestra el filtro UserRole y el boton Search
    Y validamos que la opcion Admin se encuentre en el combo box User Role
    Entonces el usuario selecciona la opcion Admin
    Y selecciona el boton Search
    Entonces se muestra la columna Actions
    Y se muestra al menos un resultado filtrado
    Entonces se muestra el icono borrar y editar

    Ejemplos:
      | user  | clave    |
      | Admin | admin123 |


  Esquema del escenario: Validar que todos los registros filtrados contengan el rol Admin
    Dado que el usuario se conecta a la pagina web DemoOrangehrmlive
    Entonces se muestra el formulario del login
    Y el usuario ingresa el usuario y clave "<user>" "<clave>"
    Y el usuario hace click en el boton LOGIN
    Entonces se muestra la pagina principal del home
    Y se muestra el menu Admin
    Entonces el usuario hace click en el menu Admin
    Entonces se muestra el filtro UserRole y el boton Search
    Y validamos que la opcion Admin se encuentre en el combo box User Role
    Entonces el usuario selecciona la opcion Admin
    Y selecciona el boton Search
    Entonces todos los registros filtrados contienen el rol Admin

    Ejemplos:
      | user  | clave    |
      | Admin | admin123 |