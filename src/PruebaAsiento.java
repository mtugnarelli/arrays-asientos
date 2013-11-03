import junit.framework.Assert;

import org.junit.Test;

public class PruebaAsiento {

	@Test
	public void crearAsiento() {
		
		/* operación */
		Asiento asiento = new Asiento(150.0);
		
		/* comprobación */
		Assert.assertEquals("precio", 150.0, asiento.obtenerPrecio(), 0.01);
		Assert.assertEquals("disponibilidad", Disponibilidad.LIBRE, asiento.obtenerDisponibilidad());
	}
	
	@Test(expected = Error.class)
	public void crearAsientoConPrecioNegatico() {
		
		/* operación */
		new Asiento(-50.0);
	}
	
	@Test
	public void cambiarPrecio() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(100.0);
		
		/* operación */
		asiento.cambiarPrecio(80.0);
		
		/* comprobación */
		Assert.assertEquals("precio", 80.0, asiento.obtenerPrecio(), 0.01);
	}
	
	@Test(expected = Error.class)
	public void cambiarPrecioConValorNegativo() {
	
		/* condición inicial */
		Asiento asiento = new Asiento(120.0);
		
		/* operación */
		asiento.cambiarPrecio(-90.0);
	}
	
	@Test
	public void reservar() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(85.0);
		
		/* operación */
		asiento.reservar();
		
		/* comprobación */
		Assert.assertEquals("disponibilidad", Disponibilidad.RESERVADO, asiento.obtenerDisponibilidad());
	}
	
	@Test
	public void cancelarReserva() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(98.0);
		asiento.reservar();
		
		/* operación */
		asiento.cancelarReserva();
		
		/* comprobación */
		Assert.assertEquals("disponibilidad", Disponibilidad.LIBRE, asiento.obtenerDisponibilidad());
	}
	
	@Test
	public void venderAsientoLibre() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(50.0);
		
		/* operación */
		asiento.vender();
		
		/* comprobación */
		Assert.assertEquals("disponibilidad", Disponibilidad.VENDIDO, asiento.obtenerDisponibilidad());
	}
	
	@Test
	public void venderAsientoReservado() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(80.0);
		asiento.reservar();
		
		/* operación */
		asiento.vender();
		
		/* comprobación */
		Assert.assertEquals("disponibilidad", Disponibilidad.VENDIDO, asiento.obtenerDisponibilidad());
	}
	
	@Test(expected = Error.class)
	public void venderAsientoVendido() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(200.0);
		asiento.vender();
		
		/* operación */
		asiento.vender();
	}
	
	@Test(expected = Error.class)
	public void reservarAsientoReservado() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(60.0);
		asiento.reservar();
		
		/* operación */
		asiento.reservar();
	}
	
	@Test(expected = Error.class)
	public void reservarAsientoVendido() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(40.0);
		asiento.vender();
		
		/* operación */
		asiento.reservar();
	}
	
	@Test(expected = Error.class)
	public void cancelarReservaAsientoLibre() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(100.0);

		/* operación */
		asiento.cancelarReserva();
	}
	
	@Test(expected = Error.class)
	public void cancelarReservaAsientoVendido() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(85.0);
		asiento.vender();
		
		/* operación */
		asiento.cancelarReserva();
	}
	
	@Test(expected = Error.class)
	public void cambiarPrecioAsientoReservado() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(120.0);
		asiento.reservar();
		
		/* operación */
		asiento.cambiarPrecio(150.0);
	}
	
	@Test(expected = Error.class)
	public void cambiarPrecioAsientoVendido() {
		
		/* condición inicial */
		Asiento asiento = new Asiento(80.0);
		asiento.vender();
		
		/* operación */
		asiento.cambiarPrecio(50.0);
	}
}
