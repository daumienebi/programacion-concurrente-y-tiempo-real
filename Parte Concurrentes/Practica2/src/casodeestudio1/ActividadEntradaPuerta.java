package casodeestudio1;

import java.util.Random;

public class ActividadEntradaPuerta implements Runnable {
	//Constructor..recibe el parque y la puerta
	public IParque parque;
	public String nombrePuerta;
	
	public ActividadEntradaPuerta(IParque parque, String nombrePuerta) {
		this.parque = parque;
		this.nombrePuerta = nombrePuerta;
	}

	@Override
	public void run() {
		// Aqui tenemos que meter lo que queremos que sea concurrente
		// Simulamos las 20 entradas al parque
		for(int i = 0; i < 20; i++) {
			this.parque.entrarAlParque(nombrePuerta);
			// Opcional : Generar un numero aleatorio para el valor de sleep para 
			// hacerle un poco mas guay o yo que se...para ver como van entrando
			// Aqui 3000 es el maximo tiempo de espera que he establecido yo y el mas 1 es para que no
			// se genere un numero como 2999 ya que el Math.random() devuelve numeros entre 0.01 y 0.9
 			int numeroAleatorio = (int) (Math.random() * 3000 + 1);
 			// TODO: Otra forma : Probar con la clase Random
 			// Random r = new Random();
			try {
				Thread.sleep(numeroAleatorio);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
