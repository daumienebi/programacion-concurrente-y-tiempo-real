package casodeestudio3;
public class Lanzador {

	public static void main(String [] args) {
		
		Thread hiloA = new Thread(new Hilo('A',1000,100));
		Thread hiloB = new Thread(new Hilo('B',1500,100));
		Thread hiloC = new Thread(new Hilo('C',2000,100));
		
		// Empezamos la ejecuccion
		hiloA.start();
		hiloB.start();
		hiloC.start();
		
		//Ponemos uno de los hilos con prioridad
		// Sobre papel, el hiloA va tener mas prioridad, pero no signiifica que siempre va tener
		// prioridad, se utilza más internamente en caso de empate
		hiloA.setPriority(10);
		hiloB.setPriority(5);
		hiloC.setPriority(1);
	}
}
