package ar.fi.uba.GPSChallengeTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

public class VehiculoTest {

	@Test
		public void testCrearVehiculo(){
		Vehiculo vehiculo = new Vehiculo();
		assertNotNull(vehiculo);
	}
}
	
	
