# Practica 2 - Exclusión mutua en Java
## Simulación de entradas a un parque de dos entradas (Caso de estudio 1)
**_Ejecuta el programa varias veces y analiza el resultado de cada ejecución. ¿Son las trazas de ejecución siempre iguales?_**

No, las trazas de ejecución no son siempre iguales dado que se siguien comportando como hilos y no podemos asegurar por que puerta se entra al parque.

**_¿Cuál es invariante del parque que se intenta preservar (usar assert de Java)?_**
El invariante en este caso es que el total de personas en el parque tiene que ser igual que el total de personas que han entrado por cada puerta (A y B). Para utilizar el assert en Java, se utiliza con el siguiente sintaxis:

`assert expresión : mensajeDeError` por ejemplo `assert nuemro = 20 : "Se ha superado el limite"`.

Posteriormente, para que funcionen los asserts a la hora de ejecutar el programa tenemos que pasar el argumento `-ea` a la maquina virtual de java. Se puede pasar los argumentos por consolas si se ejecuta el programa por consola.

**NOTA** : Para pasar el valor por parametro a una aplicación en Eclipse : Click derecho sobre la clase a ejecutar -> Run As
-> Run Configuration -> Seleccionar la pestaña de argumentos e introducir el valor "-ea" como argumentos de la maquina virtual de java. (VM Arguments).

**_¿Si se elimina la sincronización se cumple el invariante (ejecutar con las aserciones activadas -ea)?_**

En la clase `Parque` que implementa la interfaz `IParque`, para solucionar los errores anteriores debido a que los hilos no entraban al metodo `entrarAlParque(String nombrePuerta)` de forma sincronizada, hubo que agregar la palabra reservada `synchronized` para que cuando un hilo se encuentra en ese metodo realizando sus tareas, otros hilos no puedan interferir en sus tareas.Entonces si eliminamos esa sincronización, no podemos asegurar que se cumpla el invariante....o no estoy seguro.. PREEEEEGUNTA AL PROFE!!

