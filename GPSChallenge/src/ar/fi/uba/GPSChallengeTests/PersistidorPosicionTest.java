package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.*;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.Posicion;
import ar.fi.uba.GPSChallenge.Persistencia.*;

public class PersistidorPosicionTest extends TestCase {
	
	@Test
	public void testPersistoUnaPosicion() throws JAXBException, IOException{
		Posicion posicion = new Posicion(1,5);
		PersistidorDePosicion persistidor = new PersistidorDePosicion();
		persistidor.persistirPosicion(posicion);
	}
	
	@Test
	public void testDespersistoUnaPosicion(){
		String XML_POSICION = System.getProperty("user.home") + System.getProperty("file.separator") + "Posicion.xml";
		DespersistidorDePosicion despersistidor = new DespersistidorDePosicion();
		Posicion posicion = despersistidor.despersistirPosicion(XML_POSICION);
		assertEquals(posicion, new Posicion(1,5));
	}
}
