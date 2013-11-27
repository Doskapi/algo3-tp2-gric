package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import java.io.File;

import ar.fi.uba.GPSChallenge.Modelo.*;


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
	
	@Test
	public void testSeVerificaQueElJugadorComiencePartida(){
		Jugador jugador = new Jugador("Diego");
		Nivel facil = new Facil();
		jugador.comenzarPartida(facil);
		assertNotNull(jugador.getPartida());
	}

	@Test
	public void testUnJugadorPuedeElegirUnVehiculo(){
		Jugador jugador = new Jugador("Diego");
		jugador.comenzarPartida(new Facil());
		jugador.elegirVehiculo(new Vehiculo(new Auto()));

		assertNotNull(jugador.getPartida().getMapa().getVehiculo());
	}
	
	@Test
	public void testUnJugadorPuedeSaberDondeEstaSuVehiculo(){
		Jugador jugador = new Jugador("Diego");
		jugador.comenzarPartida(new Facil());
		jugador.elegirVehiculo(new Vehiculo(new Auto()));
		Posicion posicion = jugador.pedirPosicionDelVehiculo();
		assertNotNull(posicion);
	}
	
	@Test
	public void testUnJugadorPuedeMoverElVehiculo(){
		Jugador jugador = new Jugador("Diego");
		jugador.comenzarPartida(new Facil());
		jugador.elegirVehiculo(new Vehiculo(new Auto()));
		Posicion posicionInicial = jugador.pedirPosicionDelVehiculo();
		jugador.moverVehiculo(new Norte());
		Posicion posicionFinal = jugador.pedirPosicionDelVehiculo();
		
		assertFalse(posicionInicial == posicionFinal);
	}
}
