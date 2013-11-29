package ar.fi.uba.GPSChallengeTests.Persistor;

import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;


import javax.xml.bind.JAXBException;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Persistencia.*;


public class PersistidorJuegoTests extends TestCase{
	@Test
	public void testPersistoUnJuego() throws JAXBException, IOException{
		Juego juego = new Juego();
		Jugador unJugador = new Jugador("JuanTest");
		Jugador otroJugador = new Jugador("PedroTest");
		juego.agregarJugador(unJugador);
		juego.agregarJugador(otroJugador);
		PersistidorDeJuego persistidor = new PersistidorDeJuego();
		persistidor.persistirJuego(juego);
		
		File archivoParaObtenerLaDireccion = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml");
		
		assertTrue(archivoParaObtenerLaDireccion.exists());
		
	}
	
	@Test
	public void testDespersistoUnJuego(){
		DespersistidorDeJuego despersistidor = new DespersistidorDeJuego();
		Jugador unJugador = new Jugador("JuanTest");
		Jugador otroJugador = new Jugador("PedroTest");
		
		Juego unJuego = despersistidor.despersistirJuego(System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml");
		Juego otroJuego = new Juego();
		otroJuego.agregarJugador(unJugador);
		otroJuego.agregarJugador(otroJugador);
		assertEquals(unJuego, otroJuego);
	}	
}

