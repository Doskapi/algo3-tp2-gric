package ar.fi.uba.GPSChallengeTests.Mapa;

import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPiquete;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPolicial;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPozos;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaCambioDeVehiculo;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaDesfavorable;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaFavorable;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Cuadra;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;
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
	public void testCreoUnaCuadraConUnImprevistoSorpresaFavorable(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		SorpresaFavorable sorpresa = new SorpresaFavorable();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(sorpresa);
		assertNotNull(cuadra.getImprevistos().get(0));
		assertEquals(cuadra.getImprevistos().get(0), sorpresa);
	}
	
	@Test
	public void testCreoUnaCuadraConUnImprevistoSorpresaDesfavorable(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(sorpresaDesfavorable);
		assertNotNull(cuadra.getImprevistos().get(0));
		assertEquals(cuadra.getImprevistos().get(0), sorpresaDesfavorable);
	}
	
	@Test
	public void testCreoUnaCuadraConUnImprevistoSorpresaCambioDeVehiculo(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(sorpresaCambioDeVehiculo);
		assertNotNull(cuadra.getImprevistos().get(0));
		assertEquals(cuadra.getImprevistos().get(0), sorpresaCambioDeVehiculo);
	}
	
	@Test
	public void testCreoUnaCuadraConUnImprevistoObstaculoPolicial(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		ObstaculoPolicial obstaculoPolicial = new ObstaculoPolicial();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(obstaculoPolicial);
		assertNotNull(cuadra.getImprevistos().get(0));
		assertEquals(cuadra.getImprevistos().get(0), obstaculoPolicial);
	}
	
	@Test
	public void testCreoUnaCuadraConUnImprevistoObstaculoPiquete(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(obstaculoPiquete);
		assertNotNull(cuadra.getImprevistos().get(0));
		assertEquals(cuadra.getImprevistos().get(0), obstaculoPiquete);
	}
	
	@Test
	public void testCreoUnaCuadraConUnImprevistoObstaculoPozos(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		ObstaculoPozos obstaculoPozos = new ObstaculoPozos();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(obstaculoPozos);
		assertNotNull(cuadra.getImprevistos().get(0));
		assertEquals(cuadra.getImprevistos().get(0), obstaculoPozos);
	}
	
	@Test
	public void testCreoUnaCuadraConDosSorpresasFavorables(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		SorpresaFavorable sorpresa1 = new SorpresaFavorable();
		SorpresaFavorable sorpresa2 = new SorpresaFavorable();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(sorpresa1);
		cuadra.agregarImprevisto(sorpresa2);
		assertEquals(cuadra.getImprevistos().size(), 2);
		assertEquals(cuadra.getImprevistos().get(0), sorpresa1);
		assertEquals(cuadra.getImprevistos().get(1), sorpresa2);
	}
	
	@Test
	public void testCreoUnaCuadraConDosSorpresasDesfavorables(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		SorpresaDesfavorable sorpresaDesfavorable1 = new SorpresaDesfavorable();
		SorpresaDesfavorable sorpresaDesfavorable2 = new SorpresaDesfavorable();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(sorpresaDesfavorable1);
		cuadra.agregarImprevisto(sorpresaDesfavorable2);
		assertEquals(cuadra.getImprevistos().size(), 2);
		assertEquals(cuadra.getImprevistos().get(0), sorpresaDesfavorable1);
		assertEquals(cuadra.getImprevistos().get(1), sorpresaDesfavorable2);
	}
	
	@Test
	public void testCreoUnaCuadraConDosSorpresasCambioDeVehiculo(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo1 = new SorpresaCambioDeVehiculo();
		SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo2 = new SorpresaCambioDeVehiculo();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(sorpresaCambioDeVehiculo1);
		cuadra.agregarImprevisto(sorpresaCambioDeVehiculo2);
		assertEquals(cuadra.getImprevistos().size(), 2);
		assertEquals(cuadra.getImprevistos().get(0), sorpresaCambioDeVehiculo1);
		assertEquals(cuadra.getImprevistos().get(1), sorpresaCambioDeVehiculo2);
	}
	
	@Test
	public void testCreoUnaCuadraConDosObstaculosPoliciales(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		ObstaculoPolicial policia1 = new ObstaculoPolicial();
		ObstaculoPolicial policia2 = new ObstaculoPolicial();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(policia1);
		cuadra.agregarImprevisto(policia2);
		assertEquals(cuadra.getImprevistos().size(), 2);
		assertEquals(cuadra.getImprevistos().get(0), policia1);
		assertEquals(cuadra.getImprevistos().get(1), policia2);
	}
	
	@Test
	public void testCreoUnaCuadraConDosObstaculosPiquetes(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		ObstaculoPiquete piquete1 = new ObstaculoPiquete();
		ObstaculoPiquete piquete2 = new ObstaculoPiquete();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(piquete1);
		cuadra.agregarImprevisto(piquete2);
		assertEquals(cuadra.getImprevistos().size(), 2);
		assertEquals(cuadra.getImprevistos().get(0), piquete1);
		assertEquals(cuadra.getImprevistos().get(1), piquete2);
	}
	
	@Test
	public void testCreoUnaCuadraConDosObstaculosPozos(){
		Esquina esquinaInicial = new Esquina(new Posicion(2,1));
		Esquina esquinaFinal = new Esquina(new Posicion(2,2));
		ObstaculoPozos pozo1 = new ObstaculoPozos();
		ObstaculoPozos pozo2 = new ObstaculoPozos();
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(pozo1);
		cuadra.agregarImprevisto(pozo2);
		assertEquals(cuadra.getImprevistos().size(), 2);
		assertEquals(cuadra.getImprevistos().get(0), pozo1);
		assertEquals(cuadra.getImprevistos().get(1), pozo2);
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
	
