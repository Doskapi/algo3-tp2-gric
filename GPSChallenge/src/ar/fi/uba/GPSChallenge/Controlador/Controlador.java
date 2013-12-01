package ar.fi.uba.GPSChallenge.Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ar.fi.uba.GPSChallenge.Modelo.*;
import ar.fi.uba.GPSChallenge.Persistencia.PersistidorDeJuego;
import ar.fi.uba.GPSChallenge.Persistencia.PersistidorJugador;

public class Controlador {
	
	private Juego referenciaAlJuego;
	
	public Controlador(Juego referenciaAlJuego){
		this.referenciaAlJuego = referenciaAlJuego;
	}
	
	public void crearNuevoJugador(String usuarioNuevo) {
		Jugador jugador = new Jugador(usuarioNuevo);
		this.referenciaAlJuego.agregarJugador(jugador);
		this.persistirJuego();
		this.persistirJugador(jugador);
	}

	private void persistirJugador(Jugador jugador) {
		PersistidorJugador persistidorJugador = new PersistidorJugador();
		persistidorJugador.persistirJugador(jugador);
		
	}

	private void persistirJuego() {
		PersistidorDeJuego persistidorJuego = new PersistidorDeJuego();
		persistidorJuego.persistirJuego(this.referenciaAlJuego);
		
	}

	public List<Jugador> pedirJugadoresExistentes() {
		return(this.referenciaAlJuego.getJugadores());
	}

	public void elegirUsuarioSeleccionado(String jugadorSeleccionado) {
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores = this.pedirJugadoresExistentes();
		String nombreJugador;
		Jugador jugadorEncontrado = new Jugador();
		Jugador jugadorParaRecorrer = new Jugador();
		Iterator<Jugador> iterador = jugadores.iterator();
		while(iterador.hasNext()){
			jugadorParaRecorrer = iterador.next();
			nombreJugador = jugadorParaRecorrer.getNombre();
			if (nombreJugador == jugadorSeleccionado){
				jugadorEncontrado = jugadorParaRecorrer;
			}
		}
		referenciaAlJuego.setJugador(jugadorEncontrado);
	}

	public String pedirNombreDelJugadorActual() {
		return this.referenciaAlJuego.getJugador().getNombre();
	}
}