package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Cuadra;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;

public class PersistidorCuadra {
	
	private static String XML_CUADRA = System.getProperty("user.home") + System.getProperty("file.separator") + "Cuadra.xml";

	public void persistirCuadra(Cuadra cuadra){	
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(XML_CUADRA);
			m.marshal(cuadra, XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}
