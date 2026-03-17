package dependenciasDeEstado;
import java.util.Hashtable;

public class Parque implements IParque {

	// Variables para colores bonitos en la salida pero esto es totalmente opcional
	// ¿Porque lo he hecho? ...pues porque puedo
	final String VERDE = "\u001B[32m";
	final String AMARILLO = "\u001B[33m";
	final String RESET = "\u001B[0m";
	final String CYAN = "\u001B[46m";
	final String AZUL = "\u001B[44m";
	
	//Variables para el aforo
	private final int aforoMax = 20;
	private final int aforoMin = 0;
	// Contador de personas totales en el parque
	private int contadorPersonasTotales;
	// Contador individual para cada puerta con un HashTables dado que esta estructura esta
	// preparada para la concurrencia
	private Hashtable<String, Integer> contadorPuertas = new Hashtable<String, Integer>();

	// Constructor vacio porque no hace falta que se reciban los parametros
	public Parque() {
		contadorPersonasTotales = 0;
		contadorPuertas = new Hashtable<String, Integer>();
	}

	@Override
	public void entrarAlParque(String puerta) {
		// Actualizar el contador total
		contadorPersonasTotales++;
		// Este sleep aqui es para forzar que se incumpla el invariante porque aveces no
		// pasaba cuando se quita el 'synchronized'
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Actualizar los contadores individuales de cada puerta del hashtable
		if (contadorPuertas.get(puerta) == null) {
			contadorPuertas.put(puerta, 1);
		} else {
			// Obtener el valor anterior del contador para luego sumarle 1 para incrementar
			// el numero de personas que han entrado por esa puerta.
			int valorAnterior = contadorPuertas.get(puerta);
			contadorPuertas.put(puerta, valorAnterior + 1);
		}
		// Mostrar la informacion del parque
		mostrarInformacion(puerta, true);
		// Comprobar los invariantes
		checkInvarianteEntrada();
	}

	@Override
	public void salirDelParque(String puerta) {
		// Actualizar el contador total
		contadorPersonasTotales--;
		// Este sleep aqui es para forzar que se incumpla el invariante porque aveces no pasaba
		// cuando se quita el 'synchronized'
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Actualizar los contadores individuales de cada puerta del hashtable
		// Aqui, si se intenta salir por una puerta por la que nunca se ha entrada, lo inicializamos
		// con un valor de -1
		if (contadorPuertas.get(puerta) == null) {
			contadorPuertas.put(puerta, -1);
		} else {
			// Obtener el valor anterior del contador para restarle 1 y decrementar
			// el numero de personas que han salido por esa puerta.
			int valorAnterior = contadorPuertas.get(puerta);
			contadorPuertas.put(puerta, valorAnterior - 1);
		}
		// Mostrar la informacion del parque
		mostrarInformacion(puerta, false);
		// Comprobar los invariante con un Assert
		checkInvarianteSalida();
	}

	/**
	 * Muestra el estado actual de los contadores del parque
	 * @param puerta La puerta por la cual se ha producido una nueva entrada o salida
	 * @param esEntrada Para indicar si la actividad ha sido una entrada al parque
	 */
	private void mostrarInformacion(String puerta,boolean esEntrada) {
		// Este metodo podria ser mas corto pero como he metido cositas de colores y un formato a mi gusto
		// pues queda mas largo pero, se podria hacer muchiiiiisimo mas simple xd.
		if(esEntrada) {
			System.out.println(VERDE + "\n-------------------------------------------------" + RESET);
			System.out.println(VERDE + "\t\tEntrada al parque por " + puerta + RESET);
			System.out.println("\tPersonas en el parque: " + this.contadorPersonasTotales);
			// Ahora mostramos el balance entre entrada/salida de cada puerta
			for(String clave : contadorPuertas.keySet()) {
				System.out.println("\tPor " + clave  + ": "+ AZUL + contadorPuertas.get(clave) + RESET);
			}
			System.out.println(VERDE + "\n-------------------------------------------------" + RESET);
		}else {
			System.out.println(AMARILLO + "\n-------------------------------------------------" + RESET);
			System.out.println(AMARILLO + "\t\tSalida del parque por " + puerta + RESET);
			System.out.println("\tPersonas en el parque: " + this.contadorPersonasTotales);
			// Ahora mostramos el balance entre entrada/salida de cada puerta
			for(String clave : contadorPuertas.keySet()) {
				System.out.println("\tPor " + clave  + ": "+ AZUL + contadorPuertas.get(clave) + RESET);
			}
			System.out.println(AMARILLO + "\n-------------------------------------------------" + RESET);
		}
		
	}
	
	/**
	 * Calcula el total de personas en el parque recorriendo el HashTable para
	 * contar las personas que han entrado por cada puerta
	 * @return Devuelve la suma total de todos las personas del parque
	 */
	private int obtenerSumaTotalHashTable() {
		// Primero obtenemos todas las claves del hashtable para luego poder obtener sus
		// valores y contar la suma total de los valores.
		int contador = 0;
		for (String clave : contadorPuertas.keySet()) {
			// Realizamos la suma de todos los valores
			contador += contadorPuertas.get(clave);
		}
		return contador;
	}
	
	private void checkInvarianteEntrada() {
		int sumaTotal = obtenerSumaTotalHashTable();
		// Invariante 1
		assert (sumaTotal == contadorPersonasTotales) :  
			"INV : La suma total de las personas por cada puerta tiene que ser igual al numero de personas totales en el parque";
		// Invariante 2
		assert (contadorPersonasTotales <= aforoMax):"INV: El numero de personas en el parque tiene que ser <= que " + aforoMax;
	}
	
	private void checkInvarianteSalida() {
		assert (contadorPersonasTotales >= aforoMin) : "INV: El numero de personas en el parque tiene que ser >= " + aforoMin;
	}
	
	public boolean sePuedeEntrar() {
		return contadorPersonasTotales < aforoMax;
	}

	public boolean sePuedeSalir() {
		return contadorPersonasTotales > aforoMin;
	}

}
