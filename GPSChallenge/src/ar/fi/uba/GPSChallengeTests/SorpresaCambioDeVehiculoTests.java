package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.SorpresaCambioDeVehiculo;

public class SorpresaCambioDeVehiculoTests extends TestCase{
	
	@Test
	public void testCreoUnaSorpresaCambioDeVehiculo(){
		
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		assertNotNull(sorpresaCambioDeVehiculo);
	}


}