package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import ar.fi.uba.GPSChallenge.Modelo.Jugador;

public class PersistidorJugador {
	


	public void persistirJugador() {
		Jugador jugador = new Jugador("Martin");
		
		//el string deberia llegarle al metodo para que juego pueda persistir o despersistir al jugador
		String rutaDelArchivo = jugador.getPartidaGuardada();
		
		try{
			JAXBContext context = JAXBContext.newInstance(Jugador.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(rutaDelArchivo);
			m.marshal(jugador, XMLfile);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}		
	}
}
