Feature: Validacion de coordenadas asociada a un pais
  Con el fin de consumir el servicio  Time zone (Con Credenciales validas)  por una aplicacion
  Yo como usuario requiero poder enviar parametros asociados a unas coordenadas Lat y Long
  para  obtener  una respuesta exitosa  con datos de la zona horaria y pais asociados

  Scenario Outline: Validacion exitosa de servicio Time Zone con coordenadas asociadas a un pais y zona horaria
    Given Leonardo es un usuario que requiere consultar la api TimeZone con coordenadas asociadas a un pais
    When el envia los valores asociados al pais a consultar segun las coordenadas <latitud> y <longitud>
    Then  la api devuelve los resultados asociados al pais segun las coordenadas <pais> <zonaHoraria>
    Examples:
      | latitud | longitud | pais          | zonaHoraria             |
      | "-18"   | "20"     | "Namibia"     | "Africa/Windhoek"       |
      | "10"    | "-5"     | "Alpaquistan" | "Africa/Alpaquistanian" |
      | "25"    | "6"      | "Algeria"     | "Africa/Algiers"        |
      | "2"     | "-38"    | "Spain"       | "Europa/Europa"         |
