package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Persistencia.*;

public class PersistidorEsquinaTests extends TestCase {

	@Test
	public void testPersistoUnaEsquina() throws JAXBException, IOException{
		Esquina esquina = new Esquina(new Posicion(1,8));
		PersistidorEsquina persistidor = new PersistidorEsquina();
		persistidor.persistirEsquina(esquina);
	}
	
	@Test
	public void testDespersistoUnaEsquina(){
		String XML_ESQUINA = System.getProperty("user.home") + System.getProperty("file.separator") + "Esquina.xml";
		DespersistidorEsquina despersistidor = new DespersistidorEsquina();
		Esquina esquina = despersistidor.despersistirEsquina(XML_ESQUINA);
		assertEquals(esquina, new Esquina(new Posicion(1,8)));
	}
}
