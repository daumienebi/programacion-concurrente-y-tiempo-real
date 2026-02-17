package casodeestudio4;

public class Hilo implements Runnable{

	// Al poner los atributos de las clases como publicas, no nos hacen falta los
	// getters ni setters
	public char caracter;
	public int tiempoEspera;
	public int nVecesEscritura;
	
	
	public Hilo(char caracter, int tiempoEspera, int nVecesEscritura) {
		super();
		this.caracter = caracter;
		this.tiempoEspera = tiempoEspera;
		this.nVecesEscritura = nVecesEscritura;
	}
	
	
	@Override
	public void run() {
		for(int i= 0; i<this.nVecesEscritura; i++) {		
			System.out.print(this.caracter);
			try {
				Thread.sleep(tiempoEspera);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}
