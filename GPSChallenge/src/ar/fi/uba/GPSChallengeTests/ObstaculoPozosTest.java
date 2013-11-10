package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.ObstaculoPozos;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo;
import junit.framework.TestCase;

public class ObstaculoPozosTest extends TestCase {
	
	@Test
	public void testCreoUnObstaculoPozos() {
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		assertNotNull (obstaculoPozos);
	}
	
	@Test
	public void testIdentificarQueVehiculoEs(){
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		obstaculoPozos.agregarVehiculo(vehiculo);
		assertTrue(obstaculoPozos.identificarQueVehiculoEs() == cuatroPorCuatro);
	}

}
