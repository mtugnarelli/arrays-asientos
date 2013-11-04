
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
}
