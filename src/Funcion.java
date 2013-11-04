
public class Funcion {

	private Asiento[][] asientos;
	
	/**
	 * pre : filas y asientosPorFila son mayores a 0.
	 * 		 precioPorAsiento es mayor o igual a 0.0
	 * post: la función queda inicializada teniendo la distribución de Asientos 
	 * 		 filas x asientosPorFila, siendo su precio inicial el indicado en
	 * 		 precioPorAsiento.
	 * 
	 * @param filas
	 * @param asientosPorFila
	 * @param precioPorAsiento
	 */
	public Funcion(int filas, int asientosPorFila, double precioPorAsiento) {

		if (filas <= 0) {
			
			throw new Error("La cantidad de filas debe ser mayor a 0");
		}
		
		if (asientosPorFila <= 0) {
			
			throw new Error("La cantidad de asientos por fila debe ser mayor a 0");
		}
		
		this.asientos = new Asiento[filas][asientosPorFila];
		
		for (int i = 0; i < this.asientos.length; i++) {
			
			for (int j = 0; j < this.asientos[i].length; j++) {
				
				this.asientos[i][j] = new Asiento(precioPorAsiento);
			}
		}
	}

	public int contarFilasDeAsientos() {

		return this.asientos.length;
	}

	public int contarAsientosPorFila() {

		return this.asientos[0].length;
	}

	public void cambiarPrecioDelAsiento(int fila, int numeroAsiento, double precio) {

//		this.asientos[fila - 1][numeroAsiento - 1].cambiarPrecio(precio);
	}

	public double obtenerPrecioDelAsiento(int fila, int numeroAsiento) {

		return this.asientos[fila - 1][numeroAsiento - 1].obtenerPrecio();
	}

}
