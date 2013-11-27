package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Persistencia.DespersistidorJugador;
import ar.fi.uba.GPSChallenge.Persistencia.PersistidorJugador;

public class PersistorJugadorTests extends TestCase {

	@Test
	public void testPersistorDeUnJugador() throws JAXBException, IOException{
		Jugador jugador = new Jugador("MartinTest");
		PersistidorJugador persistidor = new PersistidorJugador();
		persistidor.persistirJugador(jugador);
		File archivoParaObtenerLaDireccion = new File("MartinTest");	
		archivoParaObtenerLaDireccion = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Jugadores" + System.getProperty("file.separator") + jugador.getNombre() + System.getProperty("file.separator") + "PartidaGuardada.xml");
		assertTrue(archivoParaObtenerLaDireccion.exists());
	}
	
	@Test
	public void testDespersistorDeUnJugador(){
		DespersistidorJugador despersistidor = new DespersistidorJugador();
		Jugador jugador = despersistidor.despersistirJugador(System.getProperty("user.dir") + System.getProperty("file.separator") + "Jugadores" + System.getProperty("file.separator") + "MartinTest" + System.getProperty("file.separator") + "PartidaGuardada.xml");
		Jugador otroJugador = new Jugador();
		otroJugador.setNombre("MartinTest");
		otroJugador.setPuntaje(0);
		otroJugador.setPartidaGuardada(System.getProperty("user.dir") + System.getProperty("file.separator") + "Jugadores" + System.getProperty("file.separator") + "MartinTest" + System.getProperty("file.separator") + "PartidaGuardada.xml");
		assertEquals(jugador.getNombre(), otroJugador.getNombre());
		assertEquals(jugador.getPuntaje(), otroJugador.getPuntaje());
	}
}
