package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;

public class EsquinasTests extends TestCase {
	
	@Test
	public void testCreoEsquinasDe10x10(){
		Esquinas esquinas = new Esquinas (10,10);
		Esquina esquina = esquinas.devolverEsquina(3,2);
		assertFalse(esquina.hayVehiculo());
	}
	
	@Test
	public void testCreoEsquinasDe10x10YChequeoBordeSuperior(){
		Esquinas esquinas = new Esquinas (10,10);
		Esquina esquina = esquinas.devolverEsquina(10,10);
		assertFalse(esquina.hayVehiculo());
	}
	
	@Test
	public void testCreoEsquinasDe10x10YChequeoBordeInferior(){
		Esquinas esquinas = new Esquinas (10,10);
		Esquina esquina = esquinas.devolverEsquina(1,1);
		assertFalse(esquina.hayVehiculo());
	}
}
