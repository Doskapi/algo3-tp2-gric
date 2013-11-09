package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;
import junit.framework.TestCase;
import ar.fi.uba.GPSChallenge.Modelo.Imprevisto;


public class ImprevistoTest extends TestCase {

	@Test
	public void testCreoImprevistos() {
		Imprevisto imprevisto = new Imprevisto();
		assertNotNull(imprevisto);
	}
	
}
