package ar.fi.uba.GPSChallengeTests.Persistor;

import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.xml.bind.JAXBException;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPiquete;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.ObstaculoPolicial;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaCambioDeVehiculo;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.SorpresaFavorable;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Cuadra;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;
import ar.fi.uba.GPSChallenge.Persistencia.*;

public class PersistidorMapaTests extends TestCase {

	@Test
	public void testPersistoUnMapa() throws JAXBException, IOException{
		Mapa mapa = new Mapa();
		mapa.setFilas(10);
		mapa.setColumnas(11);
		mapa.setEsquinaLargada(new Esquina(new Posicion(3,1)));
		mapa.setEsquinaMeta(new Esquina(new Posicion(5,11)));
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(5,6)), new Esquina(new Posicion(5,7)));
		cuadra.agregarImprevisto(new ObstaculoPiquete());
		cuadra.agregarImprevisto(new SorpresaCambioDeVehiculo());
		Cuadra otraCuadra = new Cuadra(new Esquina(new Posicion(8,9)),new Esquina(new Posicion(8,8)));
		otraCuadra.agregarImprevisto(new SorpresaFavorable());
		otraCuadra.agregarImprevisto(new ObstaculoPolicial());
		List<Cuadra> listaDeCuadras = new ArrayList<Cuadra>();
		listaDeCuadras.add(cuadra);
		listaDeCuadras.add(otraCuadra);
		mapa.setCuadras(listaDeCuadras);
		Vehiculo auto = new Vehiculo (new Auto());
		mapa.setVehiculo(auto);
		PersistidorMapa persistidor = new PersistidorMapa();
		String rutaMapa = System.getProperty("user.dir") + System.getProperty("file.separator") + "Mapa.xml";
		persistidor.persistirMapa(mapa, rutaMapa);
		File verificadorDeMapa = new File(rutaMapa); 
		assertTrue(verificadorDeMapa.exists());
	}
	
	@Test
	public void testDespersistoUnMapa(){
		String XML_MAPA = System.getProperty("user.dir") + System.getProperty("file.separator") + "Mapas" + System.getProperty("file.separator") + "Mapa.xml";
		Mapa mapa = new Mapa();
		mapa.setFilas(10);
		mapa.setColumnas(11);
		mapa.setEsquinaLargada(new Esquina(new Posicion(3,1)));
		mapa.setEsquinaMeta(new Esquina(new Posicion(5,11)));
		Cuadra cuadra = new Cuadra(new Esquina(new Posicion(5,6)), new Esquina(new Posicion(5,7)));
		cuadra.agregarImprevisto(new ObstaculoPiquete());
		cuadra.agregarImprevisto(new SorpresaCambioDeVehiculo());
		Cuadra otraCuadra = new Cuadra(new Esquina(new Posicion(8,9)),new Esquina(new Posicion(8,8)));
		otraCuadra.agregarImprevisto(new SorpresaFavorable());
		otraCuadra.agregarImprevisto(new ObstaculoPolicial());
		List<Cuadra> listaDeCuadras = new ArrayList<Cuadra>();
		listaDeCuadras.add(cuadra);
		listaDeCuadras.add(otraCuadra);
		mapa.setCuadras(listaDeCuadras);
		Vehiculo auto = new Vehiculo (new Auto());
		mapa.setVehiculo(auto);
		DespersistidorMapa despersistidor = new DespersistidorMapa();
		Mapa mapaDespersistido = despersistidor.despersistirMapa(XML_MAPA);
		assertEquals(mapaDespersistido,mapa);
	}
}