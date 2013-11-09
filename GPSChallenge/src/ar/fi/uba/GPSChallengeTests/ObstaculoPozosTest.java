package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.ObstaculoPozos;
import junit.framework.TestCase;

public class ObstaculoPozosTest extends TestCase {
	
	@Test
	public void testCreoUnObstaculoPozos() {
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		assertNotNull (obstaculoPozos);
	}

}
