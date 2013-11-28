package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Dificil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Facil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Moderado;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Nivel;

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
		assertNotNull(unaPartida.getMapa());
	}
	
	@Test
	public void testElNivelFacilDevuelveUnMapaFacil(){
		Nivel facil = new Facil();
		Mapa mapa = facil.pedirUnMapaParaTest();
		Partida partida = new Partida(facil);
		partida.setMapa(mapa);
		
		assertEquals(partida.getMapa() , mapa);
	}
	
	@Test
	public void testElNivelModeradoDevuelveUnMapaModerado(){
		Nivel moderado = new Moderado();
		Mapa mapa = moderado.pedirUnMapaParaTest();
		Partida partida = new Partida(moderado);
		partida.setMapa(mapa);
		
		assertEquals(partida.getMapa() , mapa);
	}
	
	@Test
	public void testElNivelDificilDevuelveUnMapaDificil(){
		Nivel dificil = new Dificil();
		Mapa mapa = dificil.pedirUnMapaParaTest();
		Partida partida = new Partida(dificil);
		partida.setMapa(mapa);
		
		assertEquals(partida.getMapa() , mapa);
	}
	
	@Test
	public void testDosPartidasSonIguales(){
		Partida partida = new Partida(new Moderado());
		Partida otraPartida = new Partida();
		otraPartida.setNivel(new Moderado());
		otraPartida.setMapa(partida.getMapa());
		assertEquals(partida, otraPartida);
	}
}
