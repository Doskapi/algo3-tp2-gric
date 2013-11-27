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
	
	private static String XML_MAPA = System.getProperty("user.dir") + System.getProperty("file.separator") + "Mapa.xml";
	
	public void persistirMapa(Mapa mapa){	
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