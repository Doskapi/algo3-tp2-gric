package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.SorpresaFavorable;

public class SorpresaFavorableTests extends TestCase{
	
	@Test
	public void testCreoUnaSorpresaFavorable(){
		
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		assertNotNull(sorpresaFavorable);

	}

	@Test
	public void testSorpresaFavorableRestaMovimientos(){
	
		SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
		int cantidadDeMovimientos = 10;
		
		sorpresaFavorable.aplicarSorpresa(cantidadDeMovimientos);
		
		assertTrue(cantidadDeMovimientos == 8);
	
	}
}	