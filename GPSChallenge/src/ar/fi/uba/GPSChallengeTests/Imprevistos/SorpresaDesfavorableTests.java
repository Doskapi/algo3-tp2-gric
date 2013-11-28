package ar.fi.uba.GPSChallengeTests.Imprevistos;

import junit.framework.TestCase;
import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaDesfavorable;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class SorpresaDesfavorableTests extends TestCase{
	
	@Test
	public void testCreoUnaSorpresaDesfavorable(){
		SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
		assertNotNull(sorpresaDesfavorable);
	}

	@Test
	public void testSorpresaDesfavorableSumaMovimientos(){
		SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		vehiculo.setCantidadDeMovimientos(10);
		sorpresaDesfavorable.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getCantidadDeMovimientos() == 12 );
	}
	
	@Test
	public void testNoSeAplicaDosVecesLaMismaSorpresa(){
		SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		
		vehiculo.setCantidadDeMovimientos(10);
		sorpresaDesfavorable.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getCantidadDeMovimientos() == 12 );
		sorpresaDesfavorable.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getCantidadDeMovimientos() == 12 );
	}
}	

	