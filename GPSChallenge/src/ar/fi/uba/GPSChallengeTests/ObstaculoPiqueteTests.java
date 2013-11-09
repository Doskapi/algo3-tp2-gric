package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.ObstaculoPiquete;
import junit.framework.TestCase;

public class ObstaculoPiqueteTests extends TestCase {

	@Test
	public void testCreoUnOstaculoPiquete() {
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		assertNotNull (obstaculoPiquete);
	}

}
