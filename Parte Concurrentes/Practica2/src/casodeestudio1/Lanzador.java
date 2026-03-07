package casodeestudio1;

public class Lanzador {
	public static void main(String [] args) {
		
		//Forma antigua de crear un parque antes de utilizar el adaptador
		//IParque parque = new Parque();
		
		//Forma nueva de crear el parque con el adaptador
		IParque  parque = AdaptadorParqueSincronizado.getInstancia();
		
		//2 hilos actividadentrada puerta
		Thread puertaA = new Thread(new ActividadEntradaPuerta(parque, "Puerta A"));
		Thread puertaB = new Thread(new ActividadEntradaPuerta(parque, "Puerta B"));
		
		// Lanzar los hilos
		puertaA.start();
		puertaB.start();
	}
}
