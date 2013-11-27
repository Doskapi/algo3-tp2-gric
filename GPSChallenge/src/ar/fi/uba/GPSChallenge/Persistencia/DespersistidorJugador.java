package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import ar.fi.uba.GPSChallenge.Modelo.Jugador;

public class DespersistidorJugador {

	public Jugador despersistirJugador(String rutaDelArchivo){
		Jugador jugador = new Jugador();		
		try{
			JAXBContext context = JAXBContext.newInstance(Jugador.class);
			Unmarshaller m = context.createUnmarshaller();
			File XMLfile = new File(rutaDelArchivo);
			jugador = (Jugador) m.unmarshal(XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return jugador;
	}
}
