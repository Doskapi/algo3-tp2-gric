package ar.fi.uba.GPSChallengeTests.Mapa;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;

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
	
	@Test
	public void testGetPosicionRandom(){
		Posicion posicion = new Posicion();
		posicion.setPosicionRandom(10, 50);
		assertTrue(posicion.getFila() <= 10);
		assertTrue(posicion.getColumna() <= 50);
		assertTrue(posicion.getFila() > 0);
		assertTrue(posicion.getColumna() > 0);
	}
	
	@Test
	public void testGetContiguaRandom(){
		Mapa mapa = new Mapa(10,12);
		Posicion posicion1 = new Posicion();
		Posicion posicion2 = new Posicion();
		posicion1.setPosicionRandom(mapa.getFilas(), mapa.getColumnas());
		posicion2 = posicion1.getContiguaRandom(mapa.getFilas(), mapa.getColumnas());
		assertTrue(posicion2.getFila() <= 10);
		assertTrue(posicion2.getColumna() <= 50);
		assertTrue(posicion2.getFila() > 0);
		assertTrue(posicion2.getColumna() > 0);
	}
	
	@Test
	public void testDosPosicionesSonIgualesCuandoCoincidenSusFilasYSusColumnas(){
		Posicion posicion1 = new Posicion(1,2);
		Posicion posicion2 = new Posicion(1,2);
		assertEquals(posicion1, posicion2);
	}
}
