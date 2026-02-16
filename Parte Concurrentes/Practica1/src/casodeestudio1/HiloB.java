package casodeestudio1;

public class HiloB implements Runnable {

	@Override
	public void run() {
		int max = 1_000_000; // Valor alto para poder visualizarlo en VisualVM
		for(int i= 0; i<max; i++) {		
			System.out.print("B");
		}
		System.out.println();
	}

}
