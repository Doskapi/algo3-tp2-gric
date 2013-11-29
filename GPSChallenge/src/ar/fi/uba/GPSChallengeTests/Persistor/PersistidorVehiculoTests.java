package ar.fi.uba.GPSChallengeTests.Persistor;

import junit.framework.TestCase;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;
import ar.fi.uba.GPSChallenge.Persistencia.*;

public class PersistidorVehiculoTests extends TestCase {

	@Test
	public void testPersistoUnVehiculo() throws JAXBException, IOException{
		Vehiculo auto = new Vehiculo(new Auto());
		PersistidorVehiculo persistidor = new PersistidorVehiculo();
		persistidor.persistirVehiculo(auto);
	}
	
	@Test
	public void testDespersistoUnVehiculo(){
		String XML_VEHICULO = System.getProperty("user.home") + System.getProperty("file.separator") + "Vehiculo.xml";
		DespersistidorVehiculo despersistidor = new DespersistidorVehiculo();
		Vehiculo vehiculoDespersistido = despersistidor.despersistirVehiculo(XML_VEHICULO);
		Vehiculo vehiculo = new Vehiculo(new Auto());
		assertEquals(vehiculoDespersistido, vehiculo);
	}
}
