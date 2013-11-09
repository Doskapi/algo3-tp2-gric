package ar.fi.uba.GPSChallengeTests;
import junit.framework.TestCase;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.SorpresaDesfavorable;


public class SorpresaDesfavorableTests extends TestCase{
	
	@Test
	public void testCreoUnaSorpresaDesfavorable(){
		
		SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
		assertNotNull(sorpresaDesfavorable);

}
}