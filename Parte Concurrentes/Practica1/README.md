# Notas / Respuesta a las pregunts sobre la practica
## Concurrencia básica (Caso de estudio 1)
_¿Describe el funcionamiento del planificador de hilos?_

El planificador de hilos es el sistema interno de la máquina virtual de java que se encarga de gestionar el funcionamiento de nuestros hilos, ya sea pararlos, que un hilo ceda a otros o interrumpir su ejecución en general (aunque como programadores, también podemos gestionar parte de su comportamiento). Estas acciones no siempre se van a poder realizar en un momento exacto dado que el funcionamiento no es determinista.

_El método yield de la clase Thread se encarga de dejar paso a otro hilo para que se ejecute, ¿ha cambiado algo en la ejecución_
Si, al utilizar el yield con un hilo en específico, lo que hacemos es hilo trate de ceder el paso a los demás hilos en ejecución, pero no siempre se va poder dejar pasar a los demás hilos porque no es determinista, no se puede predecir su comportamiento al 100%. Entonces, puede que se visualicen algunos cambios donde uno de los hilos ha cedido paso a los demás.

## Hilos en espera (Caso de estudio 2)
_¿Qué ocurre si todos los hilos tienen el mismo tiempo de espera?_

Lo que ocurre aquí es que en el momento de que se ejecute la línea de espera de cada hilo (Thread.sleep(milliseg)), ese hilo en específico tendría que estar parada durante el tiempo indicado mientras los demás hilos siguen funcionando, y si todos tienen el mismo tiempo de espera, todos esperarán la misma unidad de tiempo, pero eso no significa que tienen que esperar todos a la vez.

_¿Y si estos tiempos de espera son distintos?_

Pues al igual que el caso anterior, cada hilo esperará la unidad de tiempo correspondiente antes de continuar con su ejecución. Mientras un hilo se encuentra en espera, los otros pueden seguir en funcionamiento, pero también puede llegar un momento donde todos los hilos se encuentren parados (dependiendo del tiempo de espera que tengan cada uno de ellos)

## Constructores parametrizados (Caso de estudio 3)
_¿Qué se puede decir del orden en el que se activan los hilos?_

En cuanto al orden, lo que sabemos que es que no es determinista pero dentro de la medida posible, podemos indicarle al planificador cierta prioridad para cada uno de los hilos. Estos valores se encuentran entre 0 y 10, siendo 10 la prioridad más alta. Esto no significa que el hilo que posee la prioridad 10 se va a ejecutarse siempre de primero, solo significa que dentro de lo posible, el planificador intentará darse más prioridad a ese hilo.

## x (Caso de estudio 4)

## x (Caso de estudio 5)
