UNTreF - Algoritmos y Programación 1

# Práctica: Asientos para la Función

## Arrays multidimensionales 

## Enunciado

Utilizar la clase `Asiento` (ver)[asiento] para implementar la clase `Funcion` que modele el sistema de venta y 
reserva de localidades para un espectáculo.    

La `Funcion` debe proveer operaciones para:

1. Inicializar la `Funcion` a partir de la cantidad de filas de asientos, asientos por filas y precio general de cada asiento.

2. Cambiar y obtener el precio de un `Asiento` identificándolo a partir de su fila y número.

3. Reservar un `Asiento`.

4. Vender un `Asiento`.

5. Cancelar la reserva de un `Asiento`.

6. Contar la cantidad de `Asientos` LIBRES.

7. Contar la cantidad de `Asientos` RESERVADOS.

8. Contar la cantidad de `Asientos` VENDIDOS.

9. Sumarizar la recaudación, es decir la suma de precios de los `Asientos` VENDIDOS.

## Solución

### Implementaciones incrementales

1. Constructor de `Funcion`
	* [`Funcion`](../punto1/src/Funcion.java)
	* [`PruebaFuncion`](../punto1/src/PruebaFuncion.java)
	
2. Métodos `cambiarPrecioDelAsiento` y `obtenerPrecioDelAsiento` 
	* [`Funcion`](../punto2/src/Funcion.java)
	* [`PruebaFuncion`](../punto2/src/PruebaFuncion.java)

### Versión final

`Disponibilidad` [ver][disponibilidad]

`Asiento` [ver][asiento]

`PruebaAsiento` [ver][prueba.asiento]

`Funcion` [ver][funcion]

`PruebaFuncion` [ver][prueba.funcion]


[disponibilidad]:../master/src/Disponibilidad.java
[asiento]:../master/src/Asiento.java
[prueba.asiento]:../master/src/PruebaAsiento.java
[funcion]:../master/src/Funcion.java
[prueba.funcion]:../master/src/PruebaFuncion.java

