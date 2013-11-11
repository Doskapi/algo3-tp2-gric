package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.SorpresaDesfavorable;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

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
}	

	