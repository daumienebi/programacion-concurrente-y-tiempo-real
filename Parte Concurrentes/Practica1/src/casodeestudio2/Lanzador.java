package casodeestudio2;

public class Lanzador {
	public static void main(String[] args) {
		//Utilizamos Thread para poder llamar nuestros hilos
		Thread hiloA = new Thread(new HiloA());
		Thread hiloB = new Thread(new HiloB());
		Thread hiloC = new Thread(new HiloC());
		
		// En vez de empezar la ejecuccion con el hilo.run(),
		// tenemos que hacerlo con el metodo start() dado que este metodo
		// llama al run() de forma concurrente
		hiloA.start();
		hiloB.start();
		hiloC.start();
		
		try {
			hiloA.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Esta linea que imprime hola no se ejecutará cuando haya terminado el hilo A
		// debido al join()
		System.out.println("hola, he esperado al hiloA para terminar antes de mostrarme");
	}
}
