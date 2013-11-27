package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import java.io.IOException;
import java.util.*;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Persistencia.*;

public class PersistidorVehiculoTests extends TestCase {

	@Test
	public void testPersistoUnVehiculo() throws JAXBException, IOException{
		PersistidorVehiculo persistidor = new PersistidorVehiculo();
		persistidor.persistirVehiculo();
	}
	
	@Test
	public void testDespersistoUnVehiculo(){
		DespersistidorVehiculo despersistidor = new DespersistidorVehiculo();
		Vehiculo vehiculoDespersistido = despersistidor.despersistirVehiculo();
		Vehiculo vehiculo = new Vehiculo(new Auto());
		assertEquals(vehiculoDespersistido, vehiculo);
	}
}
