# Notas / Respuesta a las pregunts sobre la practica
## Concurrencia básica (Caso de estudio 1)
**_Describe el funcionamiento del planificador de hilos_**

El planificador de hilos es el sistema interno de la máquina virtual de java que se encarga de gestionar el funcionamiento de nuestros hilos, ya sea pararlos, que un hilo ceda a otros o interrumpir su ejecución en general (aunque como programadores, también podemos gestionar parte de su comportamiento). Estas acciones no siempre se van a poder realizar en un momento exacto dado que el funcionamiento no es determinista.

**_El método yield de la clase Thread se encarga de dejar paso a otro hilo para que se ejecute, ¿ha cambiado algo en la ejecución_**

Si, al utilizar el yield con un hilo en específico, lo que hacemos es hilo trate de ceder el paso a los demás hilos en ejecución, pero no siempre se va poder dejar pasar a los demás hilos porque no es determinista, no se puede predecir su comportamiento al 100%. Entonces, puede que se visualicen algunos cambios donde uno de los hilos ha cedido paso a los demás.

## Hilos en espera (Caso de estudio 2)
**_¿Qué ocurre si todos los hilos tienen el mismo tiempo de espera?_**

Lo que ocurre aquí es que en el momento de que se ejecute la línea de espera de cada hilo (Thread.sleep(milliseg)), ese hilo en específico tendría que estar parada durante el tiempo indicado mientras los demás hilos siguen funcionando, y si todos tienen el mismo tiempo de espera, todos esperarán la misma unidad de tiempo, pero eso no significa que tienen que esperar todos a la vez.

**_¿Y si estos tiempos de espera son distintos?_**

Pues al igual que el caso anterior, cada hilo esperará la unidad de tiempo correspondiente antes de continuar con su ejecución. Mientras un hilo se encuentra en espera, los otros pueden seguir en funcionamiento, pero también puede llegar un momento donde todos los hilos se encuentren parados (dependiendo del tiempo de espera que tengan cada uno de ellos)

## Constructores parametrizados (Caso de estudio 3)
**_¿Qué se puede decir del orden en el que se activan los hilos?_**

En cuanto al orden, lo que sabemos que es que no es determinista pero dentro de la medida posible, podemos indicarle al planificador cierta prioridad para cada uno de los hilos. Estos valores se encuentran entre 0 y 10, siendo 10 la prioridad más alta. Esto no significa que el hilo que posee la prioridad 10 se va a ejecutarse siempre de primero, solo significa que dentro de lo posible, el planificador intentará darse más prioridad a ese hilo.

## Ejecutores (Caso de estudio 4)
**_¿Son las trazas de ejecución siempre iguales?_**

No son siempre iguales dado que no es determinista pero puede parecerlo dependiendo de que tipo de ejecutor utilzamos.

**_Describe el comportamiento de cada ejecutor_**

Un ejecutor se encargar de ejecutar las tareas que le pasamos de forma concurrente. En este caso de estudio, esto será el comportamiento de los siguientes
tipos de ejecutores:

`newCachedThreadPool()`: Crea un pool de hilo según los necesita pero puede ser peligroso dado que si por ejemplo lanzamos 100 hilos, lo que hace el 
cachedthreadpool es crear todos esos hilos y luego mantenerlos para un futuro uso.

`newFixedThreadPool(1)`: Crea un unico pool de hilos con un hilo. Solo puede ejecutar una tarea a la vez. Aqui puede parecer que los distintos hilos se ejecutan secuencialmente pero eso occurre por tener solo un hilo entonces varios de nuestros hilos no pueden ejecutarse a la vez.

`newSingleThreadExecutor()`: Lo mismo que la explicación anterior, solo hay un hilo de ejecución creado para nuestros hilos. Todos se encuentran activos pero el
planificador solo puede realizar la tarea de uno a la vez.

`newFixedThreadPool(2)`: Crea un unico pool de hilos con 2 hilos. Solo puede ejecutar dos tareas a la vez. Aqui puede parecer que los distintos hilos se ejecutan secuencialmente pero eso ocurre por tener solo dos hilos entonces solo dos de nuestros hilos pueden ejecutarse a la vez pero todos se encuentran activos.

`newFixedThreadPool(3)`: Crea un unico pool de hilos con 3 hilos. Solo puede ejecutar 3 tareas a la vez. Aqui puede parecer que los distintos hilos se ejecutan secuencialmente pero eso ocurre por tener solo 3 hilos entonces solo 3 de nuestros hilos pueden ejecutarse a la vez pero todos se encuentran activos.

**_¿Cuando se aconseja utilizar ejecutores en vez del método Thread.start()?_**  
Cuando se quiere controlar cuantos hilos maximos que se pueden ejecutar / lanzar a la vez por ejemplo

**_¿Qué se entiende por degrade gracefully de una aplicación?_**  
Terminar con la aplicacion de forma que nada queda abierto

## Análisis y monitorización de ejecuciones concurrentes con interrupción (Caso de estudio 5)
**_¿Cuál es el valor del parámetro de entrada con el que se ha conseguido cada salida?_**
<img width="1062" height="378" alt="image" src="https://github.com/user-attachments/assets/a3500640-bed0-4ba6-b5fb-d254ee285674" />

<img width="1062" height="537" alt="image" src="https://github.com/user-attachments/assets/3bf35884-a6bd-4052-a6f3-07965ebdbdfa" />

**NOTA** : Para pasar el valor por parametro a una aplicación en Eclipse : Click derecho sobre la clase a ejecutar -> Run As 
-> Run Configuration -> Seleccionar la pestaña de argumentos e introducir el valor deseado como se muestra en la captura
<img width="965" height="322" alt="image" src="https://github.com/user-attachments/assets/b878ac8d-c5dc-4f32-9624-35b459370de3" />

* Salida de ejecución 1: 8
* Salida de ejecución 2: 2
* Salida de ejecución 3: 16 o cualquiero numero mayor que 16
* Salida de ejecución 4: 12
