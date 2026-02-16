package casodeestudio2;
public class HiloB implements Runnable{
	@Override
	public void run() {
		int max = 100;
		for(int i= 0;i<max; i++) {		
			System.out.print("B");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}
