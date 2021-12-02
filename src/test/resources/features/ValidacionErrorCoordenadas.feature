Feature:Validacion  error en coordenadas
  Con el fin de consumir el servicio  Time zone con coordenadas no asociadas  o erradas
  Yo como usuario requiero probar diferentes combinaciones de coordinadas no asociadas o erradas
  para  obtener un status  que me indique que  hay un error en los parametros

  Scenario Outline: Consulta  servicio Time Zone con  parametros de coordenadas erroneas
    Given Leonardo es un usuario que requiere consultar la api TimeZone con parametros de coordenadas erroneas
    When el envìa los valores erroneos en las coordenadas <latitud> y <longitud>
    Then  la api devuelve un codigo  de status  que indica  error en los parametros
    Examples:
      | latitud           | longitud        |
      | "----885"         | "2--a0"         |
      | "877777777979797" | "7/7/7/8848448" |
      | ""                | "6"             |
      | "·$e&74"          | "6"             |
