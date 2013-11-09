package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Obstaculo;
import junit.framework.TestCase;

public class ObstaculoTest extends TestCase {

	@Test
	public void testCreoObstaculo() {
		Obstaculo obstaculo = new Obstaculo();
		assertNotNull(obstaculo);
	}

}
