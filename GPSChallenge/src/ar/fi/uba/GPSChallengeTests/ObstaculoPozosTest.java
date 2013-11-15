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
	public void testObstaculoPozosSumaMovimientosAMoto(){
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 0);
		obstaculoPozos.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 3);
	}
	
	@Test
	public void testObstaculoPozosSumaMovimientosAAuto(){
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 0);
		obstaculoPozos.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 3);
	}
	
	@Test
	public void testObstaculoPozosNoSumaMovimientosACuatroPorCuatro(){
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 0);
		obstaculoPozos.aplicarImprevisto(vehiculo);
		assertEquals(vehiculo.getCantidadDeMovimientos(), 0);
	}
	
}
