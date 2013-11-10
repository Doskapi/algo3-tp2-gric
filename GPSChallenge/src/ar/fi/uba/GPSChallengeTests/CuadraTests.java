package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import junit.framework.TestCase;

public class CuadraTests extends TestCase {
	
	@Test
	public void testCrearCuadra(){
		Cuadra cuadra = new Cuadra();
		assertNotNull (cuadra);	
	}



	public void testCreaUnaCuadraConUnObstaculo(){
		Cuadra cuadra = new Cuadra();
		ObstaculoPiquete obstaculoPiquete = new ObstaculoPiquete();
		
		cuadra.setImprevisto(obstaculoPiquete);
		
		assertNotNull(cuadra.getImprevisto());
		
	}
}