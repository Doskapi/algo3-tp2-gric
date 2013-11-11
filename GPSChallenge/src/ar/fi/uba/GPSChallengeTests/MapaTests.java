package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;

public class MapaTests extends TestCase {
	
	@Test
	public void testCreoUnMapaVacio(){
		Mapa mapa = new Mapa();
		assertNotNull (mapa);
	}
	

}

