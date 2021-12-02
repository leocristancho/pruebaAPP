Feature:Consulta Respuesta del servicio con Credenciales Invalidas
  Con el fin de consumir el servicio  Time zone Con Credenciales invalidas (Username no existente)  por una aplicacion
  Yo como usuario requiero adicional a las coordinadas enviar campo username con credenciales incorrectas
  para  obtener un codigo de respuesta  que me indique que  hay un error de autenticacion

  Scenario Outline: Consulta  servicio Time Zone con  credencial username invalida
    Given Leonardo es un usuario que requiere consultar la api TimeZone con username invalido
    When el envìa los valores asociados a las coordenadas <latitud> y <longitud>  con username <username> invalido
    Then  la api devuelve un codigo de respuesta que indica   que el username no existe o no es valido
    Examples:
      | latitud  | longitud | username    |
      | "-3"     | "20"     | "qa_mobile" |
      | "10"     | "-5"     | "quasimodo" |
      | ""       | "6"      | ""          |
      | "·$e&74" | "6"      | "MasTer"    |
