package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import ar.fi.uba.GPSChallenge.Modelo.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Partida;
import ar.fi.uba.GPSChallenge.Modelo.Posicion;

public class PersistidorPartida {
	
	public void persistirPartida(Partida partida, String rutaDelArchivo){	
		partida.persistirMapa(rutaDelArchivo);
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(rutaDelArchivo + System.getProperty("file.separator") + "PartidaGuardada.xml");
			m.marshal(partida, XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}

}
