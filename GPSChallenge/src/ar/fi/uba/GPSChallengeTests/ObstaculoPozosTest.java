package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.*;
import junit.framework.TestCase;

public class ObstaculoPozosTest extends TestCase {
	
	@Test
	public void testCreoUnObstaculoPozos() {
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		assertNotNull (obstaculoPozos);
	}
	
	@Test
	public void testObstaculoPozosSumaMovimientos(){
	
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		
		vehiculo.setCantidadDeMovimientos(2);
		
		int movimientosDelVehiculo = vehiculo.getCantidadDeMovimientos();
		movimientosDelVehiculo = (movimientosDelVehiculo + 3);
		
		obstaculoPozos.aplicarImprevisto(vehiculo);
		
		int luegoDeAplicar = vehiculo.getCantidadDeMovimientos();
		
		assertTrue(luegoDeAplicar == movimientosDelVehiculo);
	}
	
	@Test
	public void testObstaculoPozosNoSumaMovimientosACuatroPorCuatro(){
	
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		
		vehiculo.setCantidadDeMovimientos(2);
		
		int movimientosDelVehiculo = vehiculo.getCantidadDeMovimientos();
		
		obstaculoPozos.aplicarImprevisto(vehiculo);
		
		int movLuegoDeAplicar = vehiculo.getCantidadDeMovimientos();
		
		assertTrue(movLuegoDeAplicar == movimientosDelVehiculo);
	}
}
