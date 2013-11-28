package ar.fi.uba.GPSChallengeTests.Mapa;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class MapaTests extends TestCase {
	
	@Test
	public void testCreoUnMapaVacio(){
		Mapa mapa = new Mapa(10,10);
		assertNotNull (mapa);
	}
	
	@Test
	public void testCreoUnMapaDe10x12(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.cantidadDeElementos(),120);
	}
	
	@Test
	public void testCreoUnMapaDe10x12YLeColocoUnaEsquinaDeLargada(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.cantidadDeElementos(),120);
		Esquina esquina = new Esquina(new Posicion(6,1));
		mapa.setEsquinaLargada(esquina);
		assertEquals(mapa.getEsquinaLargada(), esquina);
	}
	
	@Test
	public void testCreoUnMapaDe10x12YLeColocoUnaEsquinaDeMeta(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.cantidadDeElementos(),120);
		Esquina esquina = new Esquina(new Posicion(9,12));
		mapa.setEsquinaMeta(esquina);
		assertEquals(mapa.getEsquinaMeta(), esquina);
	}
	
	@Test
	public void testCreoUnMapaDe10x12YLeColocoUnVehiculo(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.cantidadDeElementos(),120);
		Vehiculo vehiculo = new Vehiculo(new Auto());
		mapa.agregarVehiculo(vehiculo);
		assertEquals(mapa.getVehiculo(), vehiculo);
	}
	
	@Test
	public void testCreoUnMapaDe10x12YLaLargadaSeColocaAleatoriamente(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.cantidadDeElementos(),120);
		assertEquals(mapa.getEsquinaLargada().getPosicion().getColumna(), 1);
	}
	
	@Test
	public void testCreoUnMapaDe11x12YLaLargadaSeColocaAleatoriamente(){
		Mapa mapa = new Mapa(11,12);
		assertEquals(mapa.cantidadDeElementos(),132);
		assertEquals(mapa.getEsquinaLargada().getPosicion().getColumna(), 1);
	}
	
	@Test
	public void testCreoUnMapaDe15x10YLaLargadaSeColocaAleatoriamente(){
		Mapa mapa = new Mapa(15,10);
		assertEquals(mapa.cantidadDeElementos(),150);
		assertEquals(mapa.getEsquinaLargada().getPosicion().getColumna(),1);
	}
	
	@Test
	public void testCreoUnMapaDe10x12YLaMetaSeColocaEnFormaAleatoria(){
		Mapa mapa = new Mapa(10,12);
		assertEquals(mapa.cantidadDeElementos(),120);
		assertTrue(mapa.getEsquinaMeta().getPosicion().getColumna() == 12);
	}	
}
	

