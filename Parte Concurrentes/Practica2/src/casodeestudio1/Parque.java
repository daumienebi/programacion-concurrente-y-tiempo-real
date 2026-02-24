package casodeestudio1;

import java.util.Hashtable;

public class Parque implements IParque {
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
	// Quitar el synchronized para ver la forma no sincronizada
	public synchronized void entrarAlParque(String puerta) {
		//Actualizar el contador total
		contadorPersonasTotales++;
		// Actualizar los contadores individuales de cada puerta del hashtable
		if(contadorPuertas.get(puerta) == null) {
			contadorPuertas.put(puerta, 1);
		}else {
			// Obtener el valor anterior del contador para luego s
			int valorAnterior = contadorPuertas.get(puerta);
			contadorPuertas.put(puerta, valorAnterior + 1);
		}
		//Mostrar la informacion
		System.out.println("Entrada al parque por " + puerta);
		System.out.println("Personas en el parque " + contadorPersonasTotales);
		System.out.println("Por puerta A: " + contadorPuertas.get("Puerta A"));
		System.out.println("Por puerta B: " + contadorPuertas.get("Puerta B"));
		
		//Comprobar los invariante con un Assert
		int sumaTotal = obtenerSumaTotalHashTable();
		assert (sumaTotal == contadorPersonasTotales) : "No se cumple el invariante";
	}
	
	/**
	 * Calcula el total de personas en el parque recorriendo el HashTable para contar las personas
	 * que han entrado por cada puerta
	 * @return Devuelve la suma total de todos las personas del parque
	 */
	private int obtenerSumaTotalHashTable() {
		// Primero obtenemos todas las claves del hashtable para luego poder obtener sus valores
		// y contar la suma total de los valores.
		int contador = 0;
		for(String clave : contadorPuertas.keySet()) {
			// Realizamos la suma de todos los valores
			contador+= contadorPuertas.get(clave);
		}
		return contador;
	}
}
