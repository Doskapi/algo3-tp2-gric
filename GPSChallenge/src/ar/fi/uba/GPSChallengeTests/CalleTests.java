package ar.fi.uba.GPSChallengeTests;
import junit.framework.TestCase;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Calle;


public class CalleTests extends TestCase {
	
	@Test
	public void testCreoUnaCalle(){
		Calle calle = new Calle();
		assertNotNull(calle);
	}

}
