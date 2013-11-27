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
		PersistidorDePosicion persistidor = new PersistidorDePosicion();
		persistidor.persistirPosicion();
	}
	
	@Test
	public void testDespersistoUnaPosicion(){
		DespersistidorDePosicion despersistidor = new DespersistidorDePosicion();
		Posicion posicion = despersistidor.despersistirPosicion();
		assertEquals(posicion, new Posicion(1,5));
	}
}
