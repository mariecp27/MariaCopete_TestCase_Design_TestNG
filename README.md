# Taller de testNG

- Un proyecto en Java utilizando maven.
- El pom.xml contenga la dependencia de TestNG (la versión deseada).
- .gitignore adaptado a sus necesidades.
- Cree los tests para la página de ESPN (https://www.espnqa.com/?_adbock=true&src=com&espn=cloud) de:
  * Iniciar sesión.
  * Cerrar sesión.
  * Desactivar usuario.
  * Debe imprimir en la consola cada paso realizado para la ejecución de las pruebas.
  * Idealmente usar loggers.
- Una suite de pruebas (archivo xml) con la ejecución de las clases.
- Incorporar el print en consola simulando los pasos que abren y cierran el browser para cada test.

Nota:
1. Este proyecto NO DEBE INCLUIR nada relacionado con selenium, cada test debe estar conformado por sentencias que impriman en consola lo que haría un test real.
2. La precondición sería tener una cuenta válida de ESPN para los tres tests.
3. Siga el ejemplo para la elaboración del ejercicio (tenga en cuenta imprimir en consola la iniciación y cierre del browser).

**Ejemplo de uso de anotaciones para realizar procesos bancarias en un cajero:**

- @BeforeSuite

//Poseer cuenta y tarjeta de la entidad bancaria

- @BeforeClass

//Entrar e interactuar con cajero de servicios bancario

- @BeforeMethod

// Ingresar tarjeta en ranura de cajero

----- Test Case 1 ------

- @Test

//Realizar transacción bancaria en el cajero

---- Fin Test Case 1 -----

- @AfterMethod

//Revisar en pantalla o recibo de transacción realizada y retirar tarjeta de ranura del cajero

- @AfterClass

//Retirarse del lugar donde está el cajero
