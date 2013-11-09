package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.Posicion;

public class PosicionTests extends TestCase {

	@Test
	public void testCreoUnaPosicionVacia(){
		Posicion posicion = new Posicion();
		assertNotNull (posicion);
	}
	
	@Test
	public void testCreoUnaPosicionValida(){
		Posicion posicion = new Posicion(1,2);
		assertNotNull (posicion);
	}
	
}
