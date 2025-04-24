#language: es
@DemoOorangehrmlive
Característica: DemoOorangehrmlive


  Esquema del escenario: Validar login exitoso
    Dado que el usuario se conecta a la pagina web DemoOrangehrmlive
    Entonces se muestra el formulario del login
    Y el usuario ingresa el usuario y clave "<user>" "<clave>"
    Y el usuario hace click en el boton LOGIN
    Entonces se muestra la pagina principal del home

    Ejemplos:
      | user  | clave    |
      | Admin | admin123 |



  Esquema del escenario: Validar login fallido
    Dado que el usuario se conecta a la pagina web DemoOrangehrmlive
    Entonces se muestra el formulario del login
    Y el usuario ingresa el usuario y clave "<user>" "<clave>"
    Y el usuario hace click en el boton LOGIN
    Entonces se muestra el mensaje Invalid credentials

    Ejemplos:
      | user  | clave    |
      | UsuarioIncorrecto | admin123 |
