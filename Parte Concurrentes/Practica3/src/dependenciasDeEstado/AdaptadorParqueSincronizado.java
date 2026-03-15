package dependenciasDeEstado;


public class AdaptadorParqueSincronizado implements IParque {
	private Parque parque; // Parque en vez de IParque para poder utilzar nuestros metodos de comprobacion
	private static AdaptadorParqueSincronizado instanciaSingleton = new AdaptadorParqueSincronizado();
	
	// Constructor privado que solo se va llamar desde este mismo adaptador
	private AdaptadorParqueSincronizado() {
		this.parque = new Parque();
	}

	@Override
	// Quitar el synchronized para ver la forma no sincronizada
	public synchronized void entrarAlParque(String puerta) {
		// Si no se puede entrar, esperamos 
		while(!this.parque.sePuedeEntrar()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.parque.entrarAlParque(puerta);
		// Notifico a los demás hilos del nuevo estado
		notifyAll();
	}
	
	@Override
	public synchronized void salirDelParque(String puerta) {
		while(!this.parque.sePuedeSalir()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.parque.salirDelParque(puerta);
		notifyAll();
		
	}
	
	/**
	 * Metodo para obtener la instancia del 
	 * @return Devuelve el adaptador con la unica instancia del parque
	 */
	public static AdaptadorParqueSincronizado getInstancia() {
		return instanciaSingleton;
	}
}
