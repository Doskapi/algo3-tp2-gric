package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.Mapa;

public class MapaTests extends TestCase {
	
		@Test
		public void testCreoUnMapa(){
			Mapa mapa = new Mapa(10,10);
			assertNotNull (mapa);
		}	
	}

