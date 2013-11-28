package ar.fi.uba.GPSChallengeTests.Imprevistos;

import junit.framework.TestCase;
import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaFavorable;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class SorpresaFavorableTests extends TestCase{
	
	@Test
	public void testCreoUnaSorpresaFavorable(){
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		assertNotNull(sorpresaFavorable);
	}

	@Test
	public void testSorpresaFavorableRestaMovimientos(){
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		vehiculo.setCantidadDeMovimientos(10);
		sorpresaFavorable.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getCantidadDeMovimientos() == 8 );
	}
	
	@Test
	public void testNoSeAplicaDosVecesLaMismaSorpresa(){
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		Vehiculo vehiculo = new Vehiculo(cuatroPorCuatro);
		vehiculo.setCantidadDeMovimientos(10);
		
		sorpresaFavorable.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getCantidadDeMovimientos() == 8 );
		sorpresaFavorable.aplicarImprevisto(vehiculo);
		assertTrue(vehiculo.getCantidadDeMovimientos() == 8 );
	}
}	