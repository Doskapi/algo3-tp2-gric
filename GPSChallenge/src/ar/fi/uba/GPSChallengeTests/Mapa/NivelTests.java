package ar.fi.uba.GPSChallengeTests.Mapa;

import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Moderado;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Nivel;
import junit.framework.TestCase;

public class NivelTests extends TestCase {
	
	@Test
	public void testSeCreaUnNivel(){
		Nivel moderado = new Moderado();
		assertNotNull(moderado);
	}
}
