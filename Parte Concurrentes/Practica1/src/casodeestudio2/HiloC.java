package casodeestudio2;

public class HiloC implements Runnable {

	@Override
	public void run() {
		for(int i= 0;i<10_000_000;i++) {		
			System.out.print("C");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}

}
