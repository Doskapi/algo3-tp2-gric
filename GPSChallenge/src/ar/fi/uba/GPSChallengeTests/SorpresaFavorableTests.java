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
}
