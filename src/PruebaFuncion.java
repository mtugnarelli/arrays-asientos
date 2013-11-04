
import org.junit.Assert;
import org.junit.Test;

public class PruebaFuncion {

	@Test
	public void crearFuncion() {

		/* operación */
		Funcion funcion = new Funcion(5, 10, 120.0);
		
		/* comprobación */
		Assert.assertEquals("cantidad de filas de asientos", 5, funcion.contarFilasDeAsientos());
		Assert.assertEquals("cantidad de asientos por fila", 10, funcion.contarAsientosPorFila());
	}
	
	@Test(expected = Error.class)
	public void crearFuncionConFilasNegativo() {
		
		new Funcion(-2, 10, 50.0);
	}
	
	@Test(expected = Error.class)
	public void crearFuncionConAsientosPorFilaNegativo() {
		
		new Funcion(10, -2, 100.0);
	}
	
	@Test(expected = Error.class)
	public void crearFuncionConPrecioPorAsientoNegativo() {
		
		new Funcion(10, 15, -80.0);
	}
	
	@Test
	public void cambiarPrecioDelAsiento() {
		
		/* condición inicial */
		Funcion funcion = new Funcion(10, 5, 50.0);
		
		/* operación */
		funcion.cambiarPrecioDelAsiento(1, 3, 120.0);
		double precio = funcion.obtenerPrecioDelAsiento(1, 3);
		
		/* comprobación */
		Assert.assertEquals("precio del asiento", 120.0, precio, 0.01);
	}
	
	@Test(expected  = Error.class)
	public void cambiarPrecioDelAsientoConFilaIncorrecta() {
		
		/* condicion inicial */
		Funcion funcion = new Funcion(10, 5, 120.0);
		
		/* operación */
		funcion.cambiarPrecioDelAsiento(11, 3, 100.0);
	}
	
	@Test(expected = Error.class)
	public void cambiarPrecioDelAsientoConNumeroIncorrecto() {
		
		/* condicion inicial */
		Funcion funcion = new Funcion(5, 6, 100.0);
		
		/* operación */
		funcion.cambiarPrecioDelAsiento(3, 7, 80.0);
	}
	
	@Test(expected = Error.class)
	public void cambiarPrecioDelAsientoConPrecioNegativo() {
		
		/* condicion inicial */
		Funcion funcion = new Funcion(10, 5, 80.0);
		
		/* operación */
		funcion.cambiarPrecioDelAsiento(1, 1, -60);
	}
	
	@Test
	public void reservarAsiento() {
		
		/* condición inicial */
		Funcion funcion = new Funcion(10, 8, 100.0);
		
		/* operación */
		funcion.reservarAsiento(1, 5);
		Disponibilidad disponibilidadDelAsiento = funcion.obtenerDisponibilidadDelAsiento(1, 5);
		
		/* comprobación */
		Assert.assertEquals("disponibilidad del asiento",
							Disponibilidad.RESERVADO, disponibilidadDelAsiento);
	}
	
	@Test
	public void venderAsiento() {
		
		/* condición inicial */
		Funcion funcion = new Funcion(5, 6, 80.0);
		
		/* operación */
		funcion.venderAsiento(3, 4);
		Disponibilidad disponibilidadDelAsiento = funcion.obtenerDisponibilidadDelAsiento(3, 4);
		
		/* comprobación */
		Assert.assertEquals("disponibilidad del asiento",
							Disponibilidad.VENDIDO, disponibilidadDelAsiento);
	}
	
	@Test
	public void cancelarReservaAsiento() {
		
		/* condición inicial */
		Funcion funcion = new Funcion(10, 5, 90.0);
		funcion.reservarAsiento(2, 1);
		
		/* operación */
		funcion.cancelarReservaAsiento(2, 1);
		Disponibilidad disponibilidadDelAsiento = funcion.obtenerDisponibilidadDelAsiento(2, 1);
		
		/* comprobación */
		Assert.assertEquals("disponibilidad del asiento",
							Disponibilidad.LIBRE, disponibilidadDelAsiento);
	}
	
	@Test
	public void contarAsientosLibres() {
		
		/* condición inicial */
		Funcion funcion = new Funcion(10, 5, 100.0);
		funcion.reservarAsiento(1, 1);
		funcion.reservarAsiento(5, 3);
		funcion.reservarAsiento(8, 4);
		funcion.venderAsiento(1, 2);
		funcion.venderAsiento(2, 4);
		
		/* operación */
		int libres = funcion.contarAsientos(Disponibilidad.LIBRE);
		
		/* comprobación */
		Assert.assertEquals("asientos libres", 45, libres);
	}
	
	@Test
	public void contarAsientosReservados() {
		
		/* condición inicial */
		Funcion funcion = new Funcion(10, 5, 100.0);
		funcion.reservarAsiento(1, 1);
		funcion.reservarAsiento(5, 3);
		funcion.reservarAsiento(8, 4);
		funcion.venderAsiento(1, 2);
		funcion.venderAsiento(2, 4);
		
		/* operación */
		int reservados = funcion.contarAsientos(Disponibilidad.RESERVADO);
		
		/* comprobación */
		Assert.assertEquals("asientos reservados", 3, reservados);
	}
	
	@Test
	public void contarAsientosVendidos() {
		
		/* condición inicial */
		Funcion funcion = new Funcion(10, 5, 100.0);
		funcion.reservarAsiento(1, 1);
		funcion.reservarAsiento(8, 4);
		funcion.venderAsiento(1, 2);
		funcion.venderAsiento(2, 3);
		funcion.venderAsiento(2, 4);
		funcion.venderAsiento(2, 5);
		
		/* operación */
		int vendidos = funcion.contarAsientos(Disponibilidad.VENDIDO);
		
		/* comprobación */
		Assert.assertEquals("asientos vendidos", 4, vendidos);
	}
	
	@Test
	public void sumarizarRecaudacion() {
		
		/* condición inicial */
		Funcion funcion = new Funcion(10, 5, 100.0);
		funcion.reservarAsiento(1, 1);
		funcion.reservarAsiento(8, 4);
		funcion.cambiarPrecioDelAsiento(1, 2, 50.0);
		funcion.venderAsiento(1, 2);
		funcion.venderAsiento(3, 3);
		funcion.venderAsiento(3, 4);
		funcion.venderAsiento(3, 5);
		funcion.venderAsiento(5, 3);
		funcion.venderAsiento(5, 4);
		funcion.venderAsiento(5, 5);
		
		/* operación */
		double recaudacion = funcion.sumarizarRecaudacion();
		
		/* comprobación */
		Assert.assertEquals("recaudacion", 650.0, recaudacion, 0.01);
	}
}
