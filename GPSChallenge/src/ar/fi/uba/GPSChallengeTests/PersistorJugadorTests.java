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
		Jugador jugador = new Jugador("Martin");
		PersistidorJugador persistidor = new PersistidorJugador();
		persistidor.persistirJugador(jugador);
		File archivoParaObtenerLaDireccion = new File("Martin");
		String ruta = archivoParaObtenerLaDireccion.getAbsolutePath();		
		archivoParaObtenerLaDireccion = new File( ruta + System.getProperty("file.separator") + "PartidaDeMartin.xml");
		assertTrue(archivoParaObtenerLaDireccion.exists());
	}
	
	@Test
	public void testDespersistorDeUnJugador(){
		DespersistidorJugador despersistidor = new DespersistidorJugador();
		Jugador jugador = despersistidor.despersistirJugador();
		Jugador otroJugador = new Jugador();
		otroJugador.setNombre("Martin");
		otroJugador.setPuntaje(0);
		File archivoParaObtenerLaDireccion = new File("Martin");
		otroJugador.setPartidaGuardada(archivoParaObtenerLaDireccion.getAbsolutePath() + System.getProperty("file.separator") + "PartidaDeMartin.xml");
		assertEquals(jugador.getNombre(), otroJugador.getNombre());
		assertEquals(jugador.getPuntaje(), otroJugador.getPuntaje());
		assertEquals(jugador.getPartidaGuardada(), otroJugador.getPartidaGuardada());
	}
}
