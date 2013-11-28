package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;

public class DespersistidorDePosicion {
	
	public Posicion despersistirPosicion(String rutaDelArchivo){
		Posicion posicion = new Posicion();
		try{
			JAXBContext context = JAXBContext.newInstance(Posicion.class);
			Unmarshaller m = context.createUnmarshaller();
			File XMLfile = new File(rutaDelArchivo);
			posicion = (Posicion) m.unmarshal(XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return posicion;
	}
}