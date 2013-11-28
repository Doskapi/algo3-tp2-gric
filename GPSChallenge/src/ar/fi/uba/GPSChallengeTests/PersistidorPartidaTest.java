package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.*;
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
	public void testDespersistoUnaPartida(){
		Jugador jugador = new Jugador("DiegoTest");
		String carpetaArchivos = System.getProperty("user.dir") + System.getProperty("file.separator") + "Jugadores" +  System.getProperty("file.separator") + jugador.getNombre() + System.getProperty("file.separator");
		DespersistidorPartida despersistidorPartida = new DespersistidorPartida();
		Partida partidaDespersistida = despersistidorPartida.despersistirPartida(carpetaArchivos  + "PartidaGuardada.xml");
		Partida partida = new Partida();
		DespersistidorMapa despersistidorMapa = new DespersistidorMapa();
		Mapa mapa = despersistidorMapa.despersistirMapa(carpetaArchivos + "Mapa.xml");
		partida.setMapa(mapa);
		partida.setNivel(new Facil());
		assertEquals(partidaDespersistida, partida);
	}
	
}