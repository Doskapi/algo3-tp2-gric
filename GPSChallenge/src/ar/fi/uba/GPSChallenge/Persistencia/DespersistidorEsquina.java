package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import ar.fi.uba.GPSChallenge.Modelo.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Posicion;

public class DespersistidorEsquina {

	public Esquina despersistirEsquina(String rutaDelArchivo){
		Esquina esquina = new Esquina();
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Unmarshaller m = context.createUnmarshaller();
			File XMLfile = new File(rutaDelArchivo);
			esquina = (Esquina) m.unmarshal(XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return esquina;
	}
}