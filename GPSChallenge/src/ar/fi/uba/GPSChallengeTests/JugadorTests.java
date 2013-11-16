package ar.fi.uba.GPSChallengeTests;

import static org.junit.Assert.*;
import ar.fi.uba.GPSChallenge.Modelo.Jugador;
import org.junit.Test;

public class JugadorTests {
	
	@Test
	public void testSeCreaElJugador(){
		Jugador jugador = new Jugador();
		assertNotNull(jugador);
	}
	

}
