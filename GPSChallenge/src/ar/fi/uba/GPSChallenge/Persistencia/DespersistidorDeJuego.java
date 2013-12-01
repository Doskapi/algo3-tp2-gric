package ar.fi.uba.GPSChallenge.Persistencia;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import ar.fi.uba.GPSChallenge.Modelo.Jugador;

public class DespersistidorDeJuego {
	
			
	public Juego despersistirJuego(String rutaDeArchivo){
		Juego juego = new Juego();
		try{
			JAXBContext context = JAXBContext.newInstance(Juego.class);
			Unmarshaller m = context.createUnmarshaller();
			File XMLfile = new File(rutaDeArchivo);
			juego = (Juego) m.unmarshal(XMLfile);	
			DespersistidorJugador despersistidor = new DespersistidorJugador();
			Iterator <Jugador> iteradorDeJugadores = juego.getJugadores().iterator();
			List<Jugador> listaDeJugadoresDespersistidos = new ArrayList<Jugador>();
			Jugador jugadorActual;
			Jugador jugadorDespersistido;
			while (iteradorDeJugadores.hasNext()){
				jugadorActual = iteradorDeJugadores.next();
				jugadorDespersistido = despersistidor.despersistirJugador(jugadorActual.getRutaASuCarpeta() +  jugadorActual.getNombre() + ".xml");
				listaDeJugadoresDespersistidos.add(jugadorDespersistido);
			}
			juego.setJugadores(listaDeJugadoresDespersistidos);
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
		return juego;
	}		
}

