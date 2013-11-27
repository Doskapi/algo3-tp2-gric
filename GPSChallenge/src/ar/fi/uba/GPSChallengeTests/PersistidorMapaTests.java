package ar.fi.uba.GPSChallengeTests;

import junit.framework.TestCase;
import java.io.IOException;
import java.util.*;

import javax.xml.bind.JAXBException;
import org.junit.Test;
import ar.fi.uba.GPSChallenge.Modelo.*;
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
		persistidor.persistirMapa(mapa);
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