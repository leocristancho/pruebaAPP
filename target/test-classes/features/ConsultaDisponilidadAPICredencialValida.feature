Feature:  Consulta disponibilidad del  servicio Time Zone
  Con el fin de consumir el servicio  Time zone (Con Credenciales validas)  por una aplicacion
  Yo como usuario requiero poder enviar parametros asociados a unas coordenadas Lat y Long
  para  obtener un codigo de respuesta  que me indique que el servicio funciona correctamente

  Scenario Outline: Consulta exitosa de servicio Time Zone con coordenadas correctas
    Given Leonardo es un usuario que requiere consultar la api TimeZone
    When el envìa los valores asociados a las coordenadas <latitud> y <longitud>
    Then  la api devuelve un codigo de respuesta de consumo exitoso
    Examples:
      | latitud | longitud |
      | "-10"   | "20"     |
      | "10"    | "-5"     |
      | "25"    | "6"      |


  Scenario Outline: Consulta exitosa de servicio Time Zone con coordenadas incorrectas
    Given Leonardo es un usuario que requiere consultar la api TimeZone con coordenadas incorrectas
    When el envìa los valores asociados a las coordenadas <latitud> y <longitud> incorrectas
    Then  la api devuelve un codigo de respuesta de consumo exitoso -  caso coordenadas incorrectas
    Examples:
      | latitud                          | longitud       |
      | "-10000000000"                   | "200000000000" |
      | "k"                              | "null"         |
      | "null"                           | ""             |
      | "null"                           | "null"         |
      | ""                               | ""             |
      | "/'`09"                          | "454454/**-/·" |
      | "122222222255444554545445454545" | "56"            |

