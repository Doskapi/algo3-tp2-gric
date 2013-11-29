package ar.fi.uba.GPSChallengeTests.Persistor;

import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Facil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Persistencia.*;

public class PersistidorPartidaTest extends TestCase {
	
	
	
	@Test
	public void testPersistoUnaPartida() throws JAXBException, IOException{
		Partida partida = new Partida(new Facil());
		PersistidorPartida persistidor = new PersistidorPartida();
		Jugador jugador = new Jugador("DiegoTest");
		String rutaPrueba = System.getProperty("user.dir") + System.getProperty("file.separator") + "Jugadores" +  System.getProperty("file.separator") + jugador.getNombre();
		persistidor.persistirPartida(partida, rutaPrueba);
		File archivo = new File(rutaPrueba + System.getProperty("file.separator") + "Mapa.xml");
		assertTrue (archivo.exists());
	}
	
	
	@Test
	public void testDespersistoUnaPartida() throws JAXBException, IOException{
		Partida partida = new Partida(new Facil());
		PersistidorPartida persistidor = new PersistidorPartida();
		Jugador jugador = new Jugador("DiegoTest");
		String rutaPrueba = System.getProperty("user.dir") + System.getProperty("file.separator") + "Jugadores" +  System.getProperty("file.separator") + jugador.getNombre();
		persistidor.persistirPartida(partida, rutaPrueba);
		DespersistidorPartida despersistidorPartida = new DespersistidorPartida();
		Partida partidaDespersistida = despersistidorPartida.despersistirPartida(jugador.getRutaASuCarpeta()  + "PartidaGuardada.xml");
		DespersistidorMapa despersistidorMapa = new DespersistidorMapa();
		Mapa mapa = despersistidorMapa.despersistirMapa(jugador.getRutaASuCarpeta() + "Mapa.xml");
		partida.setMapa(mapa);
		partida.setNivel(new Facil());
		assertEquals(partidaDespersistida, partida);
	}
	
	
	
}