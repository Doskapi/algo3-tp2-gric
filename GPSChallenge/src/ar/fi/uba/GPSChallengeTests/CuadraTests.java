package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import junit.framework.TestCase;

public class CuadraTests extends TestCase {

	@Test
	public void testCrearCuadraConImprevisto(){
		ObstaculoPozos obstaculoPozo = new ObstaculoPozos();
		Cuadra cuadra = new Cuadra(obstaculoPozo);
		assertNotNull(cuadra);
		assertEquals((cuadra.getImprevistos()).get(0),obstaculoPozo);
	}
	
	@Test
	public void testAplicarImprevistosAlDerecho(){
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		Cuadra cuadra = new Cuadra(obstaculoPozos);
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		cuadra.agregarImprevisto(sorpresaFavorable);
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		vehiculo.setCantidadDeMovimientos(20);
		cuadra.aplicarImprevistosAlDerecho(vehiculo);
		assertEquals(vehiculo.getCantidadDeMovimientos(),19);
	}
	
	@Test
	public void testAplicarImprevistosAlReves(){
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		Cuadra cuadra = new Cuadra(obstaculoPozos);
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		cuadra.agregarImprevisto(sorpresaFavorable);
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		vehiculo.setCantidadDeMovimientos(20);
		cuadra.aplicarImprevistosAlReves(vehiculo);
		assertEquals(vehiculo.getCantidadDeMovimientos(),19);
	}
}