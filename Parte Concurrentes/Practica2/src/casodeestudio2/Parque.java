package casodeestudio2;

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
	public void entrarAlParque(String puerta) {
		//Actualizar el contador total
		contadorPersonasTotales++;
		// Este sleep aqui es para forzar que se incumpla el invariante porque aveces no pasaba
		// cuando se quita el 'synchronized'
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Actualizar los contadores individuales de cada puerta del hashtable
		if(contadorPuertas.get(puerta) == null) {
			contadorPuertas.put(puerta, 1);
		}else {
			// Obtener el valor anterior del contador para luego sumarle 1 para incrementar
			// el numero de personas que han entrado por esa puerta.
			int valorAnterior = contadorPuertas.get(puerta);
			contadorPuertas.put(puerta, valorAnterior + 1);
		}
		
		// Mostramos la informacion del parque
		mostrarInformacion(puerta);
		
		//Comprobar los invariante con un Assert
		int sumaTotal = obtenerSumaTotalHashTable();
		assert (sumaTotal == contadorPersonasTotales) : "No se cumple el invariante";
	}
	
	/**
	 * Muestra el estado actual de los contadores del parque
	 * @param puerta La puerta por la cual se ha producido una nueva entrada al parque
	 */
	private void mostrarInformacion(String puerta) {
		System.out.println("Entrada al parque por " + puerta);
		System.out.println("Personas en el parque " + this.contadorPersonasTotales);
		// Ahora mostramos el numero de entradas por cada puerta
		for(String clave : contadorPuertas.keySet()) {
			System.out.println("Por " + clave  + ": "+ contadorPuertas.get(clave));
		}
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
