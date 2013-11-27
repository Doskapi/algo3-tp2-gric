package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import java.io.File;
import ar.fi.uba.GPSChallenge.Modelo.Jugador;


public class JugadorTests extends TestCase {
	
	@Test
	public void testSeCreaElJugador(){
		Jugador jugador = new Jugador("Reverendo Alegria");
		assertNotNull(jugador);
	}
	
	@Test
	public void testVerificacionDeRutaDeArchivoDentroDeCarpeta(){
		Jugador jugador = new Jugador("Juan");
		File direccion = new File("Juan");
		String direccionAProbar = direccion.getAbsolutePath() + "/PartidaDeJuan.xml";
		assertEquals(jugador.getPartidaGuardada(), direccionAProbar );
	}

}
