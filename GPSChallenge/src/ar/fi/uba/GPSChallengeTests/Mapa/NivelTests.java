package ar.fi.uba.GPSChallengeTests.Mapa;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Dificil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Facil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Moderado;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Nivel;
import junit.framework.TestCase;

public class NivelTests extends TestCase {
	
	@Test
	public void testSeCreaUnNivelFacil(){
		Nivel facil = new Facil();
		assertNotNull(facil);
	}
	
	@Test
	public void testSeCreaUnNivelModerado(){
		Nivel moderado = new Moderado();
		assertNotNull(moderado);
	}
	
	@Test
	public void testSeCreaUnNivelDificil(){
		Nivel dificil = new Dificil();
		assertNotNull(dificil);
	}
	
	@Test
	public void testUnNivelFacilCalculaSuPuntaje(){
		int cantidadDeMovimientos = 10;
		Facil facil = new Facil();
		int puntaje = facil.calcularPuntaje(cantidadDeMovimientos);
		assertEquals(puntaje, 60);
	}
	
	@Test
	public void testUnNivelModeradoCalculaSuPuntaje(){
		int cantidadDeMovimientos = 10;
		Moderado moderado = new Moderado();
		int puntaje = moderado.calcularPuntaje(cantidadDeMovimientos);
		assertEquals(puntaje, 80);
	}
	
	@Test
	public void testUnNivelDificilCalculaSuPuntaje(){
		int cantidadDeMovimientos = 10;
		Dificil dificil = new Dificil();
		int puntaje = dificil.calcularPuntaje(cantidadDeMovimientos);
		assertEquals(puntaje, 60);
	}
}
