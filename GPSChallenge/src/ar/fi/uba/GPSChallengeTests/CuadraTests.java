package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import junit.framework.TestCase;

public class CuadraTests extends TestCase {

	@Test
	public void testCrearCuadra(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		assertNotNull(cuadra);
		assertEquals(cuadra.getEsquinaInicial(),esquinaInicial);
		assertEquals(cuadra.getEsquinaFinal(),esquinaFinal);
	}
	
	@Test
	public void testAplicarImprevistosAlDerecho(){
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,1)), new Esquina(new Posicion(2,2)));
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		cuadra.agregarImprevisto(obstaculoPozos);
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
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(2,1)), new Esquina(new Posicion(2,2)));
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		cuadra.agregarImprevisto(obstaculoPozos);
		cuadra.agregarImprevisto(sorpresaFavorable);
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		vehiculo.setCantidadDeMovimientos(20);
		cuadra.aplicarImprevistosAlReves(vehiculo);
		assertEquals(vehiculo.getCantidadDeMovimientos(),19);
	}
	
	@Test
	public void testDosCuadrasSonIgualesCuandoCuandoCoicidenEsquinaInicialYEsquinaFinal(){
		Cuadra cuadra1 = new Cuadra(new Esquina(new Posicion(2,1)), new Esquina(new Posicion(2,2)));
		Cuadra cuadra2 = new Cuadra(new Esquina(new Posicion(2,1)), new Esquina(new Posicion(2,2)));
		assertEquals(cuadra1, cuadra2);
	}
	
	@Test
	public void testDosCuadrasSonIgualesCuandoCuandoEsquinaInicialYEsquinaFinalEstanInvertidos(){
		Cuadra cuadra1 = new Cuadra(new Esquina(new Posicion(2,1)), new Esquina(new Posicion(2,2)));
		Cuadra cuadra2 = new Cuadra(new Esquina(new Posicion(2,2)), new Esquina(new Posicion(2,1)));
		assertEquals(cuadra1, cuadra2);
	}
		
		
}
	
