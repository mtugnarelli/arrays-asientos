
/**
 * Un Asiento es una localidad disponible para presenciar una Función.
 * 
 */
public class Asiento {

	private double precio;
	
	private Disponibilidad disponibilidad;

	/**
	 * pre : precio es positivo.
	 * post: el asiento queda libre y con el precio indicado.
	 */
	public Asiento(double precio) {
		
		this.disponibilidad = Disponibilidad.LIBRE;		
		this.cambiarPrecio(precio);
	}

	/**
	 * post: devuelve el precio del asiento
	 */
	public double obtenerPrecio() {
		
		return this.precio;
	}
	
	/**
	 * pre : precio debe ser mayor a 0.
	 * post: cambia el precio del asiento.
	 */
	public void cambiarPrecio(double precio) {

		if (precio <= 0) {
			
			throw new Error("Precio debe ser mayor a cero");
		}
		
		if (this.disponibilidad != Disponibilidad.LIBRE) {
			
			throw new Error("Solo se puede cambiar el precio cuando está LIBRE");
		}
		this.precio = precio;
	}
	
	/**
	 * pre : está LIBRE.
	 * post:cambia la disponibilidad a RESERVADO.
	 */
	public void reservar() {
		
		if (this.disponibilidad != Disponibilidad.LIBRE) {
			
			throw new Error("El asiento no está LIBRE");
		}
		this.disponibilidad = Disponibilidad.RESERVADO;
	}
	
	/**
	 * pre : no está VENDIDO
	 * post: cambia la disponibilidad a VENDIDO.
	 */
	public void vender() {
		
		if (this.disponibilidad == Disponibilidad.VENDIDO) {
			
			throw new Error("El asiento ya está VENDIDO");
		}
		this.disponibilidad = Disponibilidad.VENDIDO;
	}
	
	/**
	 * pre : está RESERVADO.
	 * post: cambia la disponibilidad a LIBRE.
	 */
	public void cancelarReserva() {
		
		if (this.disponibilidad != Disponibilidad.RESERVADO) {
			
			throw new Error("El asiendo no está RESERVADO");
		}
		
		this.disponibilidad = Disponibilidad.LIBRE;
	}
	
	public Disponibilidad obtenerDisponibilidad() {
		
		return this.disponibilidad;
	}
}