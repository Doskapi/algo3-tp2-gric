package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;

public class MapaTests extends TestCase {
	
	@Test
	public void testCreoUnMapa(){
		Mapa mapa = new Mapa(10,10);
		assertNotNull (mapa);
	}	
	
	@Test
	public void testCreoUnMapaDe8x5(){
		Mapa mapa = new Mapa(8,5);
		assertEquals(mapa.getFilas(), 8);
		assertEquals(mapa.getColumnas(), 5);
	}	
}

