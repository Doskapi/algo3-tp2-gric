package ar.fi.uba.GPSChallengeTests;
import junit.framework.TestCase;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Esquina;

public class EsquinaTests extends TestCase {
	
	@Test
	public void testCreoUnaEsquina(){
		Esquina esquina = new Esquina();
		assertNotNull (esquina);
	}

}
