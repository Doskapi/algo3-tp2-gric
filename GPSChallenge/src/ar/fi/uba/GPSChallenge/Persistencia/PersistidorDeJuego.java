package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import ar.fi.uba.GPSChallenge.Modelo.Jugador;

public class PersistidorDeJuego {
	private static String XML_JUEGO = System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml";
	
	public void persistirJuego(Juego juego){	
		try{
			JAXBContext context = JAXBContext.newInstance(Juego.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File XMLfile = new File(XML_JUEGO);
			m.marshal(juego, XMLfile);
			
			List<Jugador> ListaDeJugadores = new ArrayList<Jugador>();
			ListaDeJugadores = juego.getJugadores();
			Iterator<Jugador> iteradorDeJugadores = ListaDeJugadores.iterator();
		
			PersistidorJugador persistidor = new PersistidorJugador();
			while (iteradorDeJugadores.hasNext()){
				persistidor.persistirJugador(iteradorDeJugadores.next());
			}
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}
