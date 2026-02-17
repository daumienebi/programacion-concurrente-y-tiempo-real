package casodeestudio4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {

	public static void main(String [] args) {
		/**
		 * Como nuestra clase hilo implemeneta Runnable, no es necesario crear un
		   Objeto de tipo Thread, podemos crear los hilos directamente con nuestra clase
		   y pasar eso al executor de la siguiente forma :
				Hilo hiloA = new Hilo('A',1000,100); y luego llamarlo con
				exec.execute(hiloA); ...pero no tendriamos el metodo de setPriority() por ejemplo
				... se podria porbar a ver si se puede sobreescribir
		 */
		Thread hiloA = new Thread(new Hilo('A',100,10_000));
		Thread hiloB = new Thread(new Hilo('B',150,10_000));
		Thread hiloC = new Thread(new Hilo('C',200,10_000));
		
		// Creamos los diferentes tipos de ejecutores que se irán probando
		// Solo se debe tener uno de ellos descomentado dado que el ejercicio se trata de
		// probarlos uno por uno:
		//ExecutorService exec = Executors.newCachedThreadPool();
		ExecutorService exec = Executors.newFixedThreadPool(1);
        // ExecutorService exec = Executors.newSingleThreadExecutor();
        // ExecutorService exec = Executors.newFixedThreadPool(2);
        // ExecutorService exec = Executors.newFixedThreadPool(3);
		
		// Empezamos la ejecuccion
		exec.execute(hiloA);
		exec.execute(hiloB);
		exec.execute(hiloC);
		
		// Ponemos uno de los hilos con prioridad
		// Sobre papel, el hiloA va tener mas prioridad, pero no signiifica que siempre va tener
		// prioridad, se utilza más internamente en caso de empate
		hiloA.setPriority(10);
		hiloB.setPriority(5);
		hiloC.setPriority(1);
		
		System.out.println("Soy el hiloA y tengeo la prioridad " + hiloA.getPriority());
		System.out.println("Soy el hiloB y tengeo la prioridad " + hiloB.getPriority());
		System.out.println("Soy el hiloC y tengeo la prioridad " + hiloC.getPriority());
		
		// Terminamos el ejecutor cuando haya acabado de ejecutar las tareas
		exec.shutdown();
	}
}
