package casodeestudio1;

public class Lanzador {
	public static void main(String [] args) {
		
		//Parque
		IParque parque = new Parque();
		
		//2 hilos actividadentrada puerta
		Thread puertaA = new Thread(new ActividadEntradaPuerta(parque, "Puerta A"));
		Thread puertaB = new Thread(new ActividadEntradaPuerta(parque, "Puerta B"));
		
		// Lanzar los hilos
		puertaA.start();
		puertaB.start();
	}
}
