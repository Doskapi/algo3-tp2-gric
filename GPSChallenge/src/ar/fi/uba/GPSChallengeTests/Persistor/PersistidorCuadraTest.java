package ar.fi.uba.GPSChallengeTests.Persistor;

import junit.framework.TestCase;
import java.io.IOException;
import java.util.*;
import javax.xml.bind.JAXBException;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.*;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.*;
import ar.fi.uba.GPSChallenge.Persistencia.*;

public class PersistidorCuadraTest extends TestCase {

	@Test
	public void testPersistoUnaCuadra() throws JAXBException, IOException{
		Esquina esquinaInicial = new Esquina(new Posicion(1,3));
		Esquina esquinaFinal = new Esquina(new Posicion(1,4));
		Cuadra cuadra = new Cuadra(esquinaInicial, esquinaFinal);
		cuadra.agregarImprevisto(new ObstaculoPolicial());
		cuadra.agregarImprevisto(new SorpresaFavorable());
		PersistidorCuadra persistidor = new PersistidorCuadra();
		persistidor.persistirCuadra(cuadra);
	}
	
	@Test
	public void testDespersistoUnaPosicion(){
		String XML_CUADRA = System.getProperty("user.home") + System.getProperty("file.separator") + "Cuadra.xml";
		List<Imprevisto> imprevistosCuadra1 = new ArrayList<Imprevisto>();
		List<Imprevisto> imprevistosCuadra2 = new ArrayList<Imprevisto>();
		DespersistidorCuadra despersistidor = new DespersistidorCuadra();
		Cuadra cuadra = despersistidor.despersistirCuadra(XML_CUADRA);
		Cuadra otraCuadra = new Cuadra(new Esquina(new Posicion(1,3)), new Esquina(new Posicion(1,4)));
		otraCuadra.agregarImprevisto(new ObstaculoPolicial());
		otraCuadra.agregarImprevisto(new SorpresaFavorable());
		assertEquals(cuadra, otraCuadra);
		imprevistosCuadra1 = cuadra.getImprevistos();
		imprevistosCuadra2 = cuadra.getImprevistos();
		assertEquals(imprevistosCuadra1.get(0), imprevistosCuadra2.get(0));
		assertEquals(imprevistosCuadra1.get(1), imprevistosCuadra2.get(1));
	}
}