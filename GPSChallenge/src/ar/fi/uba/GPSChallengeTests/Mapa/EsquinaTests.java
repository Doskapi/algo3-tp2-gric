package ar.fi.uba.GPSChallengeTests.Mapa;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Este;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Norte;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Oeste;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Rumbo;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Sur;

public class EsquinaTests extends TestCase {
	
	@Test
	public void testCreoUnaEsquina(){
		Esquina esquina = new Esquina();
		assertNotNull(esquina);
	}
	
	@Test
	public void testCrearUnaEsquinaConUnaPosicion(){
		Posicion posicion = new Posicion(2,1);
		Esquina esquina = new Esquina(posicion);
		assertEquals(esquina.getPosicion(),posicion);
	}
	
	@Test
	public void testUnaEsquinaDevuelveSuPosicion(){
		Posicion posicion1 = new Posicion(2,1);
		Esquina esquina = new Esquina(posicion1);
		Posicion posicion2 = esquina.getPosicion();
		assertEquals(posicion2 ,posicion1);
	}
	
	@Test
	public void testDosEsquinasSonIgualesCuandoSusPosicionesSonIguales(){
		Posicion posicion1 = new Posicion(4,2);
		Posicion posicion2 = new Posicion(4,2);
		Esquina esquina1 = new Esquina(posicion1);
		Esquina esquina2 = new Esquina(posicion2);
		assertEquals(esquina1, esquina2);
	}
	
	@Test
	public void testCreoUnaEsquinaEnUnaPosicionYElRumboNorteObtieneLaEsquinaSiguiente(){
		Posicion posicionInicial = new Posicion(3,2);
		Posicion posicionFinal = new Posicion(2,2);
		Esquina esquinaInicial = new Esquina(posicionInicial);
		Esquina esquinaFinal = new Esquina(posicionFinal);
		Rumbo norte = new Norte();
		esquinaInicial = norte.moverVehiculo(esquinaInicial);
		assertEquals(esquinaInicial, esquinaFinal);
	}
	
	@Test
	public void testCreoUnaEsquinaEnUnaPosicionYElRumboSurObtieneLaEsquinaSiguiente(){
		Posicion posicionInicial = new Posicion(3,2);
		Posicion posicionFinal = new Posicion(4,2);
		Esquina esquinaInicial = new Esquina(posicionInicial);
		Esquina esquinaFinal = new Esquina(posicionFinal);
		Rumbo sur = new Sur();
		esquinaInicial = sur.moverVehiculo(esquinaInicial);
		assertEquals(esquinaInicial, esquinaFinal);
	}
	
	@Test
	public void testCreoUnaEsquinaEnUnaPosicionYElRumboEsteObtieneLaEsquinaSiguiente(){
		Posicion posicionInicial = new Posicion(3,2);
		Posicion posicionFinal = new Posicion(3,3);
		Esquina esquinaInicial = new Esquina(posicionInicial);
		Esquina esquinaFinal = new Esquina(posicionFinal);
		Rumbo este = new Este();
		esquinaInicial = este.moverVehiculo(esquinaInicial);
		assertEquals(esquinaInicial, esquinaFinal);
	}
	
	@Test
	public void testCreoUnaEsquinaEnUnaPosicionYElRumboOesteObtieneLaEsquinaSiguiente(){
		Posicion posicionInicial = new Posicion(3,2);
		Posicion posicionFinal = new Posicion(3,1);
		Esquina esquinaInicial = new Esquina(posicionInicial);
		Esquina esquinaFinal = new Esquina(posicionFinal);
		Rumbo oeste = new Oeste();
		esquinaInicial = oeste.moverVehiculo(esquinaInicial);
		assertEquals(esquinaInicial, esquinaFinal);
	}
}
