package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ar.fi.uba.GPSChallenge.Modelo.Mapa;

public class PersistidorMapa {
		
	public void persistirMapa(Mapa mapa, String rutaDelArchivo){	
		try{
			JAXBContext context = JAXBContext.newInstance(Mapa.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(rutaDelArchivo);
			m.marshal(mapa, XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}