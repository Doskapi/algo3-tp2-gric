package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;

import ar.fi.uba.GPSChallenge.Modelo.Imprevisto;
import junit.framework.TestCase;

public class ImprevistoTest extends TestCase {

	@Test
	public void testCreoImprevistos() {
		Imprevisto imprevisto = new Imprevisto();
		assertNotNull(imprevisto);
	}
	
}
