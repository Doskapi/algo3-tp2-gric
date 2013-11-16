package ar.fi.uba.GPSChallengeTests;

import static org.junit.Assert.*;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.Juego;

public class JuegoTests {
	
	@Test
	public void testCreoElJuego(){
		Juego juego = new Juego();
		assertNotNull(juego);
	}
	
}
