package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Moto;
import ar.fi.uba.GPSChallenge.Modelo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.ObstaculoPolicial;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo;
import junit.framework.TestCase;

public class ObstaculoPolicialTests extends TestCase {

	@Test
	public void testCreoUnOstaculoPolicial() {
		ObstaculoPolicial obstaculoPolicial = new ObstaculoPolicial();
		assertNotNull (obstaculoPolicial);
	}	
	
	@Test
	public void testUnaMotoRecibePenalizacion(){
		
		ObstaculoPolicial obstaculoPolicial = new ObstaculoPolicial();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPolicial.aplicarImprevistoMetodoParaTesteo(vehiculo, 0.5);
	
		assertTrue(vehiculo.getCantidadDeMovimientos()== 13);
	}

	@Test
	public void testUnaMotoNoRecibePenalizacion(){
		
		ObstaculoPolicial obstaculoPolicial = new ObstaculoPolicial();
		Moto moto = new Moto();
		Vehiculo vehiculo = new Vehiculo(moto);
		
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPolicial.aplicarImprevistoMetodoParaTesteo(vehiculo, 0.9);
		
		assertTrue(vehiculo.getCantidadDeMovimientos() == 10);
	}

	@Test
	public void testUnAutoRecibePenalizacion(){
		
		ObstaculoPolicial obstaculoPolicial = new ObstaculoPolicial();
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPolicial.aplicarImprevistoMetodoParaTesteo(vehiculo, 0.5);
	
		assertTrue(vehiculo.getCantidadDeMovimientos()== 13);
	}

	@Test
	public void testUnAutoNoRecibePenalizacion(){
		
		ObstaculoPolicial obstaculoPolicial = new ObstaculoPolicial();
		Auto auto = new Auto();
		Vehiculo vehiculo = new Vehiculo(auto);
		
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPolicial.aplicarImprevistoMetodoParaTesteo(vehiculo, 0.8);
		
		assertTrue(vehiculo.getCantidadDeMovimientos() == 10);
	}

	@Test
	public void testUnaCuatroPorCuatroRecibePenalizacion(){
		
		ObstaculoPolicial obstaculoPolicial = new ObstaculoPolicial();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPolicial.aplicarImprevistoMetodoParaTesteo(vehiculo, 0.2);
	
		assertTrue(vehiculo.getCantidadDeMovimientos()== 13);
	}

	@Test
	public void testUnaCuatroPorCuatroNoRecibePenalizacion(){
		
		ObstaculoPolicial obstaculoPolicial = new ObstaculoPolicial();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		
		vehiculo.setCantidadDeMovimientos(10);
		obstaculoPolicial.aplicarImprevistoMetodoParaTesteo(vehiculo, 0.7);
		
		assertTrue(vehiculo.getCantidadDeMovimientos() == 10);
	}
}
