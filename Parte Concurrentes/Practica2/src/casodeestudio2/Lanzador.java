package casodeestudio2;
import java.util.Scanner;

public class Lanzador {
	public static void main(String [] args) {
		//Forma nueva de crear el parque con el adaptador
		IParque  parque = AdaptadorParqueSincronizado.getInstancia();
		
		//Pedimos el numero de parque al usuario
		Scanner scanner = new Scanner(System.in);
		System.out.print("¿Cuantas puertas va tener el parque ? :");
		int N = scanner.nextInt();
		char letraInicial = 'A'; // Empezamos en 'A'
		// El parque necesita como minimo 2 puertas y maximo 26 (por las letras del abecedario de
		// la A-Z)...¿Porque lo he hecho asi? pues porque si :)
		if(N <= 2 || N > 26) {
			System.err.println("El parque tiene que tener minimo 2 puertas y maximo 26 (Puertas de A - Z)");
		}else {
			for(int i = 0; i < N; i++) {
				String nombrePuerta = "Puerta " + String.valueOf(letraInicial);
				// Pasamos a la siguiente letra sumando 1 al codigo ASCII
				// Esto podria tener algunos problemas dado que si hay mas de 27 puertas
				// ya no tendremos mas letras del abecedario en mayusculas para representarlos
				// pero para este ejercicio, es totalmente valido
				letraInicial+=1;
				Thread puerta = new Thread(new ActividadEntradaPuerta(parque, nombrePuerta));
				// Lanzamos cada hilo creado
				puerta.start();
			}
		}
	}
}
