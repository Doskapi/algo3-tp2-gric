package ar.fi.uba.GPSChallengeTests;
import junit.framework.TestCase;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Calle;
import ar.fi.uba.GPSChallenge.Modelo.Sorpresa;

public class SorpresaTests extends TestCase {
	
		@Test
		
		public void testCreoUnaSorpresa(){
			Sorpresa sorpresa = new Sorpresa();
			assertNotNull (sorpresa);
		}
		
		
	}
