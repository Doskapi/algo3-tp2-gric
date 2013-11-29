package ar.fi.uba.GPSChallengeTests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.Juego;

public class JuegoTests {
	
	@Test
	public void testCreoElJuego(){
		Juego juego = new Juego();
		assertNotNull(juego);
	}
	
	@Test
	public void testVerificoQueSeCreeCarpetaJugadores(){
		Juego juego = new Juego();	
		String rutaDeCarpetaJugadores = System.getProperty("user.dir") + System.getProperty("file.separator") + "Jugadores";
		File carpetaDeJugadores = new File(rutaDeCarpetaJugadores);
		assertTrue(carpetaDeJugadores.exists());
	}
	
}
