package ar.fi.uba.GPSChallenge.Controlador;

import java.awt.event.ActionListener;
import java.util.List;

import ar.fi.uba.GPSChallenge.Modelo.*;

public class Controlador {
	
	private Juego referenciaAlJuego;
	
	public Controlador(Juego referenciaAlJuego){
		this.referenciaAlJuego = referenciaAlJuego;
	}
	
	public void crearNuevoJugador(String usuarioNuevo) {
		Jugador jugador = new Jugador(usuarioNuevo);
		this.referenciaAlJuego.agregarJugador(jugador);
	}

	public List<Jugador> pedirJugadoresExistentes() {
		return(this.referenciaAlJuego.getJugadores());
	}
}
