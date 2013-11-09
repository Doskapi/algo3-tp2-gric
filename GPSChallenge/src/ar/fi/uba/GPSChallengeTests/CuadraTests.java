package ar.fi.uba.GPSChallengeTests;
import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.*;

import java.util.ArrayList;
import junit.framework.TestCase;

public class CuadraTests extends TestCase {
	
	@Test
	public void testCrearCuadra(){
		Cuadra cuadra = new Cuadra();
		assertNotNull (cuadra);	
	}
	

}
