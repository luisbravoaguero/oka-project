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
    #Entonces se muestra el filtro UserRole y el boton Search
    Entonces se muestra el filtro UserRole
    Y se muestra el boton Search
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


  Esquema del escenario: Validar mensaje 'No Records Found' en el popup azul al buscar Empleados con User Role Admin sin resultados
    Dado que el usuario se conecta a la pagina web DemoOrangehrmlive
    Entonces se muestra el formulario del login
    Y el usuario ingresa el usuario y clave "<user>" "<clave>"
    Y el usuario hace click en el boton LOGIN
    Entonces se muestra la pagina principal del home
    Y se muestra el menu Admin
    Entonces el usuario hace click en el menu Admin
    Entonces se muestra el filtro UserRole y el boton Search
    Y se muestra el campo Username
    Y validamos que la opcion Admin se encuentre en el combo box User Role
    Entonces el usuario selecciona la opcion Admin
    Y el usuario ingresa el texto "nombreLuis" en el campo Username
    Y selecciona el boton Search
    Y se muestra el mensaje "No Records Found" en la cabcera de la tabla de resultados
    Entonces se muestra popup con el mensaje "No Records Found"

    Ejemplos:
      | user  | clave    |
      | Admin | admin123 |


  Esquema del escenario: Agregar un nuevo usuario con rol Admin con estado Enabled
    Dado que el usuario se conecta a la pagina web DemoOrangehrmlive
    #Logueo
    Entonces se muestra el formulario del login
    Y el usuario ingresa el usuario y clave "<user>" "<clave>"
    Y el usuario hace click en el boton LOGIN
    Entonces se muestra la pagina principal del home
    #Ingresar al menu Admin
    Y se muestra el menu Admin
    Y el usuario hace click en el menu Admin
    #Ingresar a la pagina AddUser
    Y se muestra el boton Add
    Y el usuario hace click en el boton Add
    Entonces se muestra la pagina AddUser
    #Visibilidad de botones
    Y se muestra el filtro "User Role"
    Y se muestra el filtro "Status"
    Y se muestra el campo "Employee Name"
    Y se muestra el campo "Username"
    Y se muestra el campo "Password"
    Y se muestra el campo "Confirm Password"
    Y se muestra el boton "Save"
    #Visibilidad e ingreso de opciones en los comboboxes
    Y validamos que la opcion "Admin" se encuentre en el combo box "User Role"
    Entonces el usuario selecciona la opcion "Admin" del combo box "User Role"
    Y validamos que la opcion "Enabled" se encuentre en el combo box "Status"
    Entonces el usuario selecciona la opcion "Enabled" del combo box "Status"
    #Ingreso de datos en campos
    Y el usuario ingresa "James Butler" en el campo "Employee Name"
    Y validamos que la opcion "James Butler" se encuentre en el filtro "Employee Name"
    Entonces el usuario selecciona la opcion "James Butler" en el resultado del campo "Employee Name"
    Y el usuario ingresa "<username>" en el campo "Username"
    Y el usuario ingresa "<password>" en el campo "Password"
    Y el usuario ingresa "<password>" en el campo "Confirm Password"
    Y el usuario hace click en el boton Save
    Entonces se muestra popup con el mensaje "Successfully Saved"
    #Validar que se muestre la pagina UserManagement
    Entonces se muestra la pagina UserManagement
    #Validar que los campos a filtrar se muestren antes de ingresar los datos
    Y se muestra el filtro UserRole
    Y se muestra el boton Search
    #Y validamos que la opcion Admin se encuentre en el combo box User Role
    Y validamos que la opcion "Admin" se encuentre en el combo box "User Role"
    Entonces el usuario selecciona la opcion "Admin" del combo box "User Role"
    Y el usuario ingresa el texto "<username>" en el campo Username
    Y selecciona el boton Search
    #Validar que los datos del resultado son los que se acaban de registrar
    Entonces se visualiza el "username" "<username>"
    Y se visualiza el "rol" "<rol>"
    Y se visualiza el "empleado" "<empleado>"
    Y se visualiza el "status" "<status>"

    Ejemplos:
      | user  | clave    | username  | password     | empleado    | status  | rol  |
      | Admin | admin123 | LuisManuelBravoAguero| luisBravo123 | James Butler| Enabled | Admin|