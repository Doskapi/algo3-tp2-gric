package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.*;

import junit.framework.TestCase;

public class PartidaTests extends TestCase{
	
	@Test
	public void testSeCreaUnaPartidaVacia(){
		Partida unaPartida = new Partida(new Facil());
		assertNotNull(unaPartida);
	}
	
	@Test
	public void testSeCreaUnaPartidaConUnNivel(){
		Nivel dificil = new Dificil();
		Partida unaPartida = new Partida(dificil);
		assertEquals(unaPartida.getNivel(), dificil);
	}
	
	@Test
	public void testCreoUnaPartidaYLePideUnMapaAlNivel(){
		Nivel facil = new Facil();
		Partida unaPartida = new Partida(facil);
		assertFalse(unaPartida.getMapa() != null);
	}
	
}
