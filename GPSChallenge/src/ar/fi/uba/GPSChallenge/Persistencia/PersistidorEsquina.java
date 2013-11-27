package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ar.fi.uba.GPSChallenge.Modelo.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Posicion;

public class PersistidorEsquina {
	
	private static String XML_ESQUINA = System.getProperty("user.home") + System.getProperty("file.separator") + "Esquina.xml";
	
	public void persistirEsquina(){	
		Esquina esquina = new Esquina(new Posicion(1,8));
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(XML_ESQUINA);
			m.marshal(esquina, XMLfile);
			m.marshal(esquina, System.out);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}