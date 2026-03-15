package dependenciasDeEstado;

public class Lanzador {
	public static void main(String[] args) {
		// Forma nueva de crear el parque con el adaptador
		IParque parque = AdaptadorParqueSincronizado.getInstancia();
		int N = 5; // El enunciado pide lanzar 10 tareas en total, 5 para entradas y 5 para salidas
		System.out.println("Creando " + N + " puertas de entradas y salidas");
		char letraInicial = 'A'; // Empezamos en 'A'
		// En cada iteracion, creamos dos tareas, uno para entrar por la puerta y otra para salir
		for (int i = 0; i < N; i++) {
			String nombrePuerta = "Puerta " + String.valueOf(letraInicial);
			// Pasamos a la siguiente letra en mayuscula sumando 1 al codigo ASCII
			letraInicial += 1;
			Thread puertaEntrada = new Thread(new ActividadEntradaPuerta(parque, nombrePuerta));
			Thread puertaSalida = new Thread(new ActividadSalidaPuerta(parque, nombrePuerta));
			// Lanzamos cada tarea creada
			puertaEntrada.start();
			puertaSalida.start();
		}
	}
}
