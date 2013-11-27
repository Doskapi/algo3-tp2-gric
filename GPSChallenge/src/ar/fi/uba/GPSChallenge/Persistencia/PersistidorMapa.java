package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ar.fi.uba.GPSChallenge.Modelo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Cuadra;
import ar.fi.uba.GPSChallenge.Modelo.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.ObstaculoPiquete;
import ar.fi.uba.GPSChallenge.Modelo.ObstaculoPolicial;
import ar.fi.uba.GPSChallenge.Modelo.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.SorpresaCambioDeVehiculo;
import ar.fi.uba.GPSChallenge.Modelo.SorpresaFavorable;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

public class PersistidorMapa {
	
	private static String XML_MAPA = System.getProperty("user.home") + System.getProperty("file.separator") + "Mapa.xml";
	
	public void persistirMapa(){	
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
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(XML_MAPA);
			m.marshal(mapa, XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}