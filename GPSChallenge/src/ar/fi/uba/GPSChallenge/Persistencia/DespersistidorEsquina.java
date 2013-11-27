package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import ar.fi.uba.GPSChallenge.Modelo.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Posicion;

public class DespersistidorEsquina {
private static String XML_ESQUINA = System.getProperty("user.home") + System.getProperty("file.separator") + "Esquina.xml";
	public Esquina despersistirEsquina(){
		Esquina esquina = new Esquina();
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Unmarshaller m = context.createUnmarshaller();
			File XMLfile = new File(XML_ESQUINA);
			esquina = (Esquina) m.unmarshal(XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return esquina;
	}
}