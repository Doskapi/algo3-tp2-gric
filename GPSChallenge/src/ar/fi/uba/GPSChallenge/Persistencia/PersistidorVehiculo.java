package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ar.fi.uba.GPSChallenge.Modelo.*;

public class PersistidorVehiculo {
	
	private static String XML_VEHICULO = System.getProperty("user.home") + System.getProperty("file.separator") + "Vehiculo.xml";
	
	public void persistirVehiculo(Vehiculo vehiculo){	
		try{
			JAXBContext context = JAXBContext.newInstance(Vehiculo.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(XML_VEHICULO);
			m.marshal(vehiculo, XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}