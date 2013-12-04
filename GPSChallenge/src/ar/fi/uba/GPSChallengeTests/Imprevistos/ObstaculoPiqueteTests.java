package ar.fi.uba.GPSChallengeTests.Imprevistos;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPiquete;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Moto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;
import junit.framework.TestCase;

public class ObstaculoPiqueteTests extends TestCase {

	@Test
	public void testCreoUnOstaculoPiquete() {
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		assertNotNull (obstaculoPiquete);
	}

	@Test
	public void testUnaMotoRecibePenalizacion(){
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPiquete.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getCantidadDeMovimientos()== 12);
	}

	@Test
	public void testUnAutoNoRecibePenalizacion(){
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPiquete.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getCantidadDeMovimientos()== 10);
	}
	
	@Test
	public void testUnaCuatroPorCuatroRecibePenalizacion(){
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPiquete.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getCantidadDeMovimientos()== 10);
	}

	@Test
	public void testUnaMotoPuedeMoverse(){
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPiquete.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getEstado().puedeMoverse());
	}

	@Test
	public void testUnAutoNoPuedeMoverse(){
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPiquete.aplicarImprevisto(vehiculo);
		assertFalse(vehiculo.getEstado().puedeMoverse());
	}
	
	@Test
	public void testUnaCuatroPorCuatroNoPuedeMoverse(){
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPiquete.aplicarImprevisto(vehiculo);
		assertFalse(vehiculo.getEstado().puedeMoverse());
	}
	
	@Test
	public void testUnaMotoPuedeMoversePasandoDosVecesPorElMismoPiquete(){
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPiquete.aplicarImprevisto(vehiculo);
		obstaculoPiquete.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getEstado().puedeMoverse());
	}
}
