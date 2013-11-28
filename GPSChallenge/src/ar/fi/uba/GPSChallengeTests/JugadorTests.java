package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;

import org.junit.Test;

import java.io.File;

import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Dificil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Facil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Moderado;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Nivel;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Norte;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class JugadorTests extends TestCase {
	
	@Test
	public void testSeCreaElJugador(){
		Jugador jugador = new Jugador("JulianTest");
		assertNotNull(jugador);
	}
	
	@Test
	public void testSeVerificaQueElJugadorComiencePartida(){
		Jugador jugador = new Jugador("DiegoTest");
		Nivel facil = new Facil();
		jugador.comenzarPartida(facil);
		assertNotNull(jugador.getPartida());
	}

	@Test
	public void testUnJugadorPuedeElegirUnVehiculo(){
		Jugador jugador = new Jugador("DiegoTest");
		jugador.comenzarPartida(new Facil());
		jugador.elegirVehiculo(new Vehiculo(new Auto()));
		assertNotNull(jugador.getPartida().getMapa().getVehiculo());
	}
	
	@Test
	public void testUnJugadorPuedeSaberDondeEstaSuVehiculo(){
		Jugador jugador = new Jugador("DiegoTest");
		jugador.comenzarPartida(new Facil());
		jugador.elegirVehiculo(new Vehiculo(new Auto()));
		Posicion posicion = jugador.pedirPosicionDelVehiculo();
		assertNotNull(posicion);
	}
	
	@Test
	public void testUnJugadorPuedeMoverElVehiculo(){
		Jugador jugador = new Jugador("DiegoTest");
		jugador.comenzarPartida(new Facil());
		jugador.elegirVehiculo(new Vehiculo(new Auto()));
		Posicion posicionInicial = jugador.pedirPosicionDelVehiculo();
		jugador.moverVehiculo(new Norte());
		Posicion posicionFinal = jugador.pedirPosicionDelVehiculo();
		assertFalse(posicionInicial == posicionFinal);
	}
	
	@Test
	public void testUnJugadorCalculaSuPuntajeEnNivelFacil(){
		Jugador jugador = new Jugador("DiegoTest");
		jugador.comenzarPartida(new Facil());
		jugador.elegirVehiculo(new Vehiculo(new Auto()));
		jugador.moverVehiculo(new Norte());
		jugador.moverVehiculo(new Norte());
		jugador.moverVehiculo(new Norte());
		jugador.calcularPuntaje();
		assertEquals(jugador.getPuntaje(), 67);
	}
	
	@Test
	public void testUnJugadorCalculaSuPuntajeEnNivelModerado(){
		Jugador jugador = new Jugador("DiegoTest");
		jugador.comenzarPartida(new Moderado());
		jugador.elegirVehiculo(new Vehiculo(new Auto()));
		jugador.moverVehiculo(new Norte());
		jugador.moverVehiculo(new Norte());
		jugador.moverVehiculo(new Norte());
		jugador.calcularPuntaje();
		assertEquals(jugador.getPuntaje(), 94);
	}
	
	@Test
	public void testUnJugadorCalculaSuPuntajeEnNivelDificil(){
		Jugador jugador = new Jugador("DiegoTest");
		jugador.comenzarPartida(new Dificil());
		jugador.elegirVehiculo(new Vehiculo(new Auto()));
		jugador.moverVehiculo(new Norte());
		jugador.moverVehiculo(new Norte());
		jugador.moverVehiculo(new Norte());
		jugador.calcularPuntaje();
		assertEquals(jugador.getPuntaje(), 81);
	}
	
	@Test
	
	public void testUnJugadorGuardaSuPartida(){
		Jugador jugador = new Jugador("JuanaTest");
		jugador.comenzarPartida(new Facil());
		jugador.elegirVehiculo(new Vehiculo(new Auto()));
		jugador.persistirPartida();
		String rutaArchivos = System.getProperty("user.dir") + System.getProperty("file.separator") + "Jugadores" +  System.getProperty("file.separator") + jugador.getNombre() + System.getProperty("file.separator");
		File archivoPartida = new File(rutaArchivos + "PartidaGuardada.xml");
		File archivoMapa = new File(rutaArchivos + "Mapa.xml");
		assertTrue(archivoPartida.exists());
		assertTrue(archivoMapa.exists());
	}
}
