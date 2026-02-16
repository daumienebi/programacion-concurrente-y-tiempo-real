package casodeestudio2;

public class HiloA implements Runnable {

	@Override
	public void run() {
		// Modificar el valor de max a un valor alto como 1millon para visualizarlo
		// bien en VisualVM o un valor bajo como 100 para ver bien la salida en la
		// consola de Eclipse
		int max = 100;
		for(int i= 0; i<max ;i++) {	
			System.out.print("A");
			try {
				// Dormimos durante 1 segundo
				System.out.println(this.getClass().getName() + "va a dormir");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

}
