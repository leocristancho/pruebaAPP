#Prueba Práctica para Ingreso a AppGate - Leonardo Cristancho
Este es el README básico para preparar el entorno  y la ejecución de las pruebas para la API TIMEZONE.

Como framework de automatización y generación de reportes se utiliza Serenity BDD con integración de Cucumber y Maven principalente. 
El patrón de automatización es una implementación de Screen Play 

######El proyecto se compone principalmentte de las siguientes paquetes JAVA: #####

- Models.Country
Con las clases referentes al modelo de los objetos de la API TIMEZONE 

- Questions 
Clases utilizadas para hacer las preguntas y posterior implementación para validación. Nos  sirive para traer las respuesta del  servicio asociado a ciertas caracteristicas.

- StepDefitions
Clases  en donde se implementa el codigo java referente a los features creados 

- Task
Clases para implementación de las tareas, aquí enviamos el codigo para la petición de respuesta del servicio de APITIMEZONE

- CLase Runner - Test
SerenityInitialTest clase ruuner.

- Resources - Features 

Paquete que contiene los Features  escritos en BDD - Gherking usando cucumber. Aquí se encuentran los escenarios a probar con las diferentes combinaciones. 

-Resources - Target - Site 
Aquí tenemos la generación de los reportes con serenity. Abrir index.html con un navegador una vez ejecutamos el proyecto.


Cualquier duda o comentario, comunicarse al correo: leocristancho@hotmail.com



## Requerimientos Previos: 

Debe verificiar que su equipo cuente con las siguientes herramientas

-  Java JDK 1.8
-  apache-maven-3.8.4
-  IDE Java Preferiblemente IntelliJ IDEA
-  Verificar que se cuente con la ultima versión del proyecto  en el repositorio git 


## Preparación del Ambiente 

Una vez validados los requerimientos previos, se deben seguir los siguientes pasos:

#1 Abrir IntelliJ IDEA

#2 Importar Proyecto 
Buscar la opción "Open" -  seleccionar ruta de destino - aceptar y seguir los pasos

#3 Cargar librerias y complementos a través del POM

una vez importemos el proyecto buscamos el archivo POM en el IDE, hacemos click derecho - Maven - Reload Project. Aquí debemos esperar hasta que se descarguen todas las dependecias y complementos.

#4 Ejecutar proyecto desde consola (CMD)

-Abrimos una terminal CMD
- Escribimos cd y la ruta del proyecto. Ejemplo: cd C:\Users\leocr\IdeaProjects\serenitybddprueba1
- Una vez en la ruta del proyecto ejecutamos el comando:  mvn clean verify
-Esperamos que termine la ejecución, maven nos avisará

#5 Abrir reportes de finalización de pruebas
Una vez se finalice la ejecución de las pruebas podemos revisar los reportes con todos los datos de la ejecución allí nos dira si falló o pasó la prueba,adicional podemos ver el request y el response de cada escenario.

Ej Ruta: C:\Users\leocr\IdeaProjects\serenitybddprueba1\target\site\serenity

Debemos abrir el archivo Index con un navegador como Google chrome. 