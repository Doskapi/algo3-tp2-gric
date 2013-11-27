package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import java.io.IOException;
import java.util.*;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Persistencia.*;

public class PersistidorEsquinaTests extends TestCase {

	@Test
	public void testPersistoUnaEsquina() throws JAXBException, IOException{
		PersistidorEsquina persistidor = new PersistidorEsquina();
		persistidor.persistirEsquina();
	}
	
	@Test
	public void testDespersistoUnaEsquina(){
		DespersistidorEsquina despersistidor = new DespersistidorEsquina();
		Esquina esquina = despersistidor.despersistirEsquina();
		assertEquals(esquina, new Esquina(new Posicion(1,8)));
	}
}
