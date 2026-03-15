# Practica 3 - Dependencia de Estado
## Objetivos
* Comprender que la concurrencia dependiente del estado impone problemas adicionales de cumplimiento precondiciones dependientes del estado
* Aplicar esperas sincronizadas para resolver problemas de dependencias de estado

## Enunciado
Basada en la práctica anterior donde se ha solucionado el problema de exclusión mutua de un parque con dos entradas ( ver enunciado en "Exclusión mutua en Java"). Se pide hacer la simulación para  que permita entradas y salidas.
Se trata de escribir un programa que simule el comportamiento del sistema durante un periodo determinado de ejecución hasta que se alcancen 20 entradas y sus correspondientes 20 salidas por cada una de las cinco puertas. El programa debe indicar, para cada entrada/salida, la puerta por la que entra o sale y sus contadores parciales. Para llevar a cabo la simulación, deben lanzarse diez tareas, cinco (una por cada puerta) para simular 20 entradas cada una y otras cinco para simular 20 salidas cada una. Todo esto bajo un aforo máximo de 50 personas en el parque.


## Comentarios sobre la practica
// Preguntar al profe si primero tienen que entrar las 20 personas antes de salir o que lo hagan simultaneamentes...para modificar     	la implementación

### Notas
* Sí el numero de algunas puerta se encuentra en negativa, es porque han salido mas personas que los que han entrado por esa puerta!
* Sí el numero de alguna puerta es 0, significa que han entrado y salido el mismo número de personas por esa puerta
* Por último, si el valor de alguna puerta es un valor positivo, significa que no todos los que han entrado por esa puerta han salida por esa misma puerta.

## Extras
Para utilizar el assert en Java, se utiliza con el siguiente sintaxis:

`assert expresión : mensajeDeError` por ejemplo `assert nuemro = 20 : "Se ha superado el limite"`.

Posteriormente, para que funcionen los asserts a la hora de ejecutar el programa tenemos que pasar el argumento `-ea` a la maquina virtual de java. Se puede pasar los argumentos por consolas si se ejecuta el programa por consola.

**NOTA** : Para pasar el valor por parametro a una aplicación en Eclipse : Click derecho sobre la clase a ejecutar -> Run As
-> Run Configuration -> Seleccionar la pestaña de argumentos e introducir el valor "-ea" como argumentos de la maquina virtual de java. (VM Arguments).
<img width="1182" height="521" alt="image" src="https://github.com/user-attachments/assets/f249d3a0-1ffa-44f5-9a73-9e1acb39484c" />
