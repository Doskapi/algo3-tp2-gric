package ar.fi.uba.GPSChallengeTests.Mapa;

import junit.framework.TestCase;
import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;

public class EsquinaTests extends TestCase {
	
	@Test
	public void testCrearUnaEsquinaConUnaPosicion(){
		Posicion posicion = new Posicion(2,1);
		Esquina esquina = new Esquina(posicion);
		assertEquals(esquina.getPosicion(),posicion);
	}

}
