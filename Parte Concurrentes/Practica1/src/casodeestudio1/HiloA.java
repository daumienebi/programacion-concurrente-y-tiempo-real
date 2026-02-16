package casodeestudio1;

public class HiloA implements Runnable {

	@Override
	public void run() {
		// Modificar el valor de max a un valor alto como 1millon para visualizarlo
		// bien en VisualVM o un valor bajo como 100 para ver bien la salida en la
		// consola de Eclipse
		int max = 1_000_000;
		for(int i= 0; i<max; i++) {		
			System.out.print("A");		
			// Podemos ceder el hilo despues de dos ejecucciones
			if(i == 1) {
				Thread.yield();
			}
		}
		System.out.println();
	}

}
