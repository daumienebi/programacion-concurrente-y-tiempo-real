package casodeestudio1;

public class AdaptadorParqueSincronizado implements IParque {
	private IParque parque;
	private static AdaptadorParqueSincronizado instanciaSingleton = new AdaptadorParqueSincronizado();
	
	// Constructor privado que solo se va llamar desde este mismo adaptador
	private AdaptadorParqueSincronizado() {
		this.parque = new Parque();
	}

	@Override
	// Quitar el synchronized para ver la forma no sincronizada
	public synchronized void entrarAlParque(String puerta) {
		this.parque.entrarAlParque(puerta);	
	}
	
	/**
	 * Metodo para obtener la instancia del 
	 * @return Devuelve el adaptador con la unica instancia del parque
	 */
	public static AdaptadorParqueSincronizado getInstancia() {
		return instanciaSingleton;
	}
}
