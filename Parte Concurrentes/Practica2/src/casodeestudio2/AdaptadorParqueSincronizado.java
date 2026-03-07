package casodeestudio2;

/**
 * Esta clase se encargará de la parte concurrente del problema
 */
public class AdaptadorParqueSincronizado implements IParque {
	private IParque parque;
	private static AdaptadorParqueSincronizado instanciaSingleton = new AdaptadorParqueSincronizado();
	
	// Constructor privado que solo se va llamar desde esta misma clase
	private AdaptadorParqueSincronizado() {
		this.parque = new Parque();
	}

	@Override
	public void entrarAlParque(String puerta) {
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
