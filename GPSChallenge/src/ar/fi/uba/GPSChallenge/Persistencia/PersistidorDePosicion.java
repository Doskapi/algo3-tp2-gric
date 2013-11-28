package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;

public class PersistidorDePosicion {
	
	private static String XML_POSICION = System.getProperty("user.home") + System.getProperty("file.separator") + "Posicion.xml";
	
	public void persistirPosicion(Posicion posicion) throws JAXBException, IOException{
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(XML_POSICION);
			m.marshal(posicion, XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}