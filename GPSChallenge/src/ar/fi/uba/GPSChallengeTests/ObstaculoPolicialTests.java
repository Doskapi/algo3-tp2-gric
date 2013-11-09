package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.ObstaculoPolicial;
import junit.framework.TestCase;

public class ObstaculoPolicialTests extends TestCase {

	@Test
	public void testCreoUnOstaculoPolicial() {
		ObstaculoPolicial obstaculoPolicial = new ObstaculoPolicial();
		assertNotNull (obstaculoPolicial);
	}	
}
