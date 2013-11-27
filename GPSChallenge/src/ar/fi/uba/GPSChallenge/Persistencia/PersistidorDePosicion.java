package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ar.fi.uba.GPSChallenge.Modelo.*;

public class PersistidorDePosicion {
	
	private static String XML_POSICION = System.getProperty("user.home") + System.getProperty("file.separator") + "Posicion.xml";
	
	public void persistirPosicion() throws JAXBException, IOException{
		Posicion posicion = new Posicion(1,5);
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(XML_POSICION);
			m.marshal(posicion, XMLfile);
			m.marshal(posicion, System.out);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}