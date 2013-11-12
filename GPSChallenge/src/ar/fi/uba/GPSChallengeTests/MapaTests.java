package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;

public class MapaTests extends TestCase {
	
	@Test
	public void testCreoUnMapaVacio(){
		Mapa mapa = new Mapa(10,10);
		assertNotNull (mapa);
	}
	
	@Test
	public void testCreoUnMapaDe10x12(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.dimensiones(),120);
	}
	
	@Test
	public void testCreoUnMapaDe10x12YLeColocoUnaEsquinaDeLargada(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.dimensiones(),120);
		Esquina esquina = new Esquina(new Posicion(6,1));
		mapa.setEsquinaLargada(esquina);
		assertEquals(mapa.getEsquinaLargada(), esquina);
	}
	
	@Test
	public void testCreoUnMapaDe10x12YLeColocoUnaEsquinaDeMeta(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.dimensiones(),120);
		Esquina esquina = new Esquina(new Posicion(9,12));
		mapa.setEsquinaMeta(esquina);
		assertEquals(mapa.getEsquinaMeta(), esquina);
	}
	
	@Test
	public void testCreoUnMapaDe10x12YLeColocoUnVehiculo(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.dimensiones(),120);
		Vehiculo vehiculo = new Vehiculo(new Auto());
		mapa.agregarVehiculo(vehiculo);
		assertEquals(mapa.devolverVehiculo(), vehiculo);
	}
	
	@Test
	public void testCreoUnMapaDe10x12YLaLargadaSeColocaAutomaticamenteEnMitadDeMapa(){
		Mapa mapa = new Mapa(10,12);
		Esquina esquina = new Esquina(new Posicion(5,1));
		assertEquals(mapa.dimensiones(),120);
		assertEquals(mapa.getEsquinaLargada(), esquina);
	}
	
	@Test
	public void testCreoUnMapaDe11x12YLaLargadaSeColocaAutomaticamenteEnMitadDeMapa(){
		Mapa mapa = new Mapa(11,12);
		Esquina esquina = new Esquina(new Posicion(5,1));
		assertEquals(mapa.dimensiones(),132);
		assertEquals(mapa.getEsquinaLargada(), esquina);
	}
	
	@Test
	public void testCreoUnMapaDe15x10YLaLargadaSeColocaAutomaticamenteEnMitadDeMapa(){
		Mapa mapa = new Mapa(15,10);
		Esquina esquina = new Esquina(new Posicion(7,1));
		assertEquals(mapa.dimensiones(),150);
		assertEquals(mapa.getEsquinaLargada(), esquina);
	}
	
	@Test
	public void testCreoUnMapaDe10x12YLaMetaSeColocaEnFormaAleatoria(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.dimensiones(),120);
		assertTrue(mapa.getEsquinaMeta().getPosicion().getColumna() == 12);
	}
}

