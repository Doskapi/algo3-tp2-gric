package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import junit.framework.TestCase;

public class NivelTests extends TestCase {
	
	@Test
	public void testSeCreaUnNivel(){
		Nivel moderado = new Moderado();
		assertNotNull(moderado);
	}
}
