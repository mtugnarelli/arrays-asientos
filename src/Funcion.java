
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

	/**
	 * pre : fila está en el rango [1,contarFilasDeAsientos],
	 * 		 numeroAsiento está en el rango [1,contarAsientosPorFila],
	 * 		 precio es mayor o igual a 0.
	 * post: cambia el precio del Asiento indicado.
	 */
	public void cambiarPrecioDelAsiento(int fila, int numeroAsiento, double precio) {

		Asiento asiento = this.obtenerAsiento(fila, numeroAsiento);
		
		asiento.cambiarPrecio(precio);
	}

	/**
	 * pre : fila está en el rango [1,contarFilasDeAsientos],
	 * 		 numeroAsiento está en el rango [1,contarAsientosPorFila],
	 * 		 precio es mayor o igual a 0.
	 * post: devuelve el precio del Asiento indicado.
	 */
	public double obtenerPrecioDelAsiento(int fila, int numeroAsiento) {

		Asiento asiento = this.obtenerAsiento(fila, numeroAsiento);
		
		return asiento.obtenerPrecio();
	}
	
	/**
	 * pre : fila está en el rango [1,contarFilasDeAsientos],
	 * 		 numeroAsiento está en el rango [1,contarAsientosPorFila].
	 * post: devuelve el Asiento identificado por fila-numeroAsiento.
	 */
	private Asiento obtenerAsiento(int fila, int numeroAsiento) {
		
		if ((fila < 1) || (fila > this.asientos.length) ||
			(numeroAsiento < 1) || (numeroAsiento > this.asientos[fila].length)) {
			
			throw new Error("El Asiento " + fila + "-" + numeroAsiento + " no existe");
		}
		
		return this.asientos[fila - 1][numeroAsiento - 1];
	}

	/**
	 * pre : fila está en el rango [1,contarFilasDeAsientos],
	 * 		 numeroAsiento está en el rango [1,contarAsientosPorFila],
	 * 		 el Asiento está LIBRE.
	 * post: el Asiento indicado queda RESERVADO.
	 */
	public void reservarAsiento(int fila, int numeroAsiento) {

		this.obtenerAsiento(fila, numeroAsiento).reservar();
	}

	/**
	 * pre : fila está en el rango [1,contarFilasDeAsientos],
	 * 		 numeroAsiento está en el rango [1,contarAsientosPorFila].
	 * post: devuelve la disponibilidad del Asiento indicado.
	 */
	public Disponibilidad obtenerDisponibilidadDelAsiento(int fila, int numeroAsiento) {

		return this.obtenerAsiento(fila, numeroAsiento).obtenerDisponibilidad();
	}

	/**
	 * pre : fila está en el rango [1,contarFilasDeAsientos],
	 * 		 numeroAsiento está en el rango [1,contarAsientosPorFila],
	 * 		 el Asiento no está VENDIDO.
	 * post: el Asiento indicado queda VENDIDO.
	 */
	public void venderAsiento(int fila, int numeroAsiento) {
		
		this.obtenerAsiento(fila, numeroAsiento).vender();
	}

	/**
	 * pre : fila está en el rango [1,contarFilasDeAsientos],
	 * 		 numeroAsiento está en el rango [1,contarAsientosPorFila],
	 * 		 el Asiento está RESERVADO.
	 * post: el Asiento indicado queda LIBRE.
	 */
	public void cancelarReservaAsiento(int fila, int numeroAsiento) {
	
		this.obtenerAsiento(fila, numeroAsiento).cancelarReserva();
	}

	/**
	 * post: devuelve la cantidad de Asiento con Disponibilidad igual a disponibilidadBuscada.
	 */
	public int contarAsientos(Disponibilidad disponibilidadBuscada) {

		int total = 0;
		
		for (int i = 0; i < this.asientos.length; i++) {
			
			for (int j = 0; j < this.asientos[i].length; j++) {
				
				Asiento asiento = this.asientos[i][j];
				
				if (asiento.obtenerDisponibilidad() == disponibilidadBuscada) {
					
					total++;
				}
			}
		}
		
		return total;
	}
}
