package ar.fi.uba.GPSChallenge.Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.fi.uba.GPSChallenge.Modelo.Juego;
import ar.fi.uba.GPSChallenge.Modelo.Jugador;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Dificil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Facil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Moderado;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Moto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;
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
			if (nombreJugador.equals(jugadorSeleccionado)){
				jugadorEncontrado = jugadorParaRecorrer;
			}
		}
		referenciaAlJuego.setJugador(jugadorEncontrado);
	}

	public String pedirNombreDelJugadorActual() {
		return this.referenciaAlJuego.getJugador().getNombre();
	}

	public void elegirDificultadSeleccionada(String dificultadSeleccionada) {
		switch(dificultadSeleccionada){
			case("Facil"):
				this.referenciaAlJuego.getJugador().comenzarPartida(new Facil());
				this.referenciaAlJuego.getJugador().getPartida().setMapa(this.referenciaAlJuego.getJugador().getPartida().getNivel().pedirUnMapa());
				break;
			case("Moderado"):
				this.referenciaAlJuego.getJugador().comenzarPartida(new Moderado());
				this.referenciaAlJuego.getJugador().getPartida().setMapa(this.referenciaAlJuego.getJugador().getPartida().getNivel().pedirUnMapa());
				break;
			case("Dificil"):
				this.referenciaAlJuego.getJugador().comenzarPartida(new Dificil());
				this.referenciaAlJuego.getJugador().getPartida().setMapa(this.referenciaAlJuego.getJugador().getPartida().getNivel().pedirUnMapa());
				break;
		}
	}

	public void elegirVehiculoSeleccionado(String vehiculoSeleccionado) {
		switch(vehiculoSeleccionado){
			case("Auto"):
				this.referenciaAlJuego.getJugador().elegirVehiculo(new Vehiculo(new Auto()));
				break;
			case("4X4"):
				this.referenciaAlJuego.getJugador().elegirVehiculo(new Vehiculo(new CuatroPorCuatro()));
				break;
			case("Moto"):
				this.referenciaAlJuego.getJugador().elegirVehiculo(new Vehiculo(new Moto()));
				break;
		}
	}
}