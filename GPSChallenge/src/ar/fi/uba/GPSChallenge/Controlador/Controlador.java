package ar.fi.uba.GPSChallenge.Controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.fi.uba.GPSChallenge.Modelo.Juego;
import ar.fi.uba.GPSChallenge.Modelo.Jugador;
import ar.fi.uba.GPSChallenge.Modelo.Partida;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Dificil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Facil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Moderado;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Moto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Rumbo;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;
import ar.fi.uba.GPSChallenge.Persistencia.DespersistidorMapa;
import ar.fi.uba.GPSChallenge.Persistencia.DespersistidorPartida;
import ar.fi.uba.GPSChallenge.Persistencia.PersistidorDeJuego;
import ar.fi.uba.GPSChallenge.Persistencia.PersistidorJugador;

public class Controlador {
	
	private Juego referenciaAlJuego;
	
	public Controlador(Juego referenciaAlJuego){
		this.referenciaAlJuego = referenciaAlJuego;
	}
	
	public void crearNuevoJugadorYAsignarloComoActual(String usuarioNuevo) {
		Jugador jugador = new Jugador(usuarioNuevo);
		this.referenciaAlJuego.agregarJugador(jugador);
		this.referenciaAlJuego.setJugadorActual(jugador);
		this.persistirJugador(jugador);
		this.persistirJuego();
	}

	private void persistirJugador(Jugador jugador) {
		PersistidorJugador persistidorJugador = new PersistidorJugador();
		persistidorJugador.persistirJugador(jugador);
		
	}

	private void persistirJuego() {
		PersistidorDeJuego persistidorJuego = new PersistidorDeJuego();
		persistidorJuego.persistirJuego(this.referenciaAlJuego);
		
	}
	
	public void persistirJuegoActual(){
		this.persistirJugador(this.referenciaAlJuego.getJugadorActual());
		this.persistirJuego();
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
		referenciaAlJuego.setJugadorActual(jugadorEncontrado);
	}

	public String pedirNombreDelJugadorActual() {
		return this.referenciaAlJuego.getJugadorActual().getNombre();
	}

	public void elegirDificultadSeleccionada(String dificultadSeleccionada) {
		switch(dificultadSeleccionada){
			case("Facil"):
				this.referenciaAlJuego.getJugadorActual().comenzarPartida(new Facil());
				this.referenciaAlJuego.getJugadorActual().getPartida().setMapa(this.referenciaAlJuego.getJugadorActual().getPartida().getNivel().pedirUnMapa());
				break;
			case("Moderado"):
				this.referenciaAlJuego.getJugadorActual().comenzarPartida(new Moderado());
				this.referenciaAlJuego.getJugadorActual().getPartida().setMapa(this.referenciaAlJuego.getJugadorActual().getPartida().getNivel().pedirUnMapa());
				break;
			case("Dificil"):
				this.referenciaAlJuego.getJugadorActual().comenzarPartida(new Dificil());
				this.referenciaAlJuego.getJugadorActual().getPartida().setMapa(this.referenciaAlJuego.getJugadorActual().getPartida().getNivel().pedirUnMapa());
				break;
		}
	}

	public void elegirVehiculoSeleccionado(String vehiculoSeleccionado) {
		switch(vehiculoSeleccionado){
			case("Auto"):
				this.referenciaAlJuego.getJugadorActual().elegirVehiculo(new Vehiculo(new Auto()));
				break;
			case("4X4"):
				this.referenciaAlJuego.getJugadorActual().elegirVehiculo(new Vehiculo(new CuatroPorCuatro()));
				break;
			case("Moto"):
				this.referenciaAlJuego.getJugadorActual().elegirVehiculo(new Vehiculo(new Moto()));
				break;
		}
	}

	public Mapa obtenerMapa() {
		return(referenciaAlJuego.getJugadorActual().getPartida().getMapa());
	}
	
	public void moverVehiculo(Rumbo rumbo) throws Exception {
		this.referenciaAlJuego.getJugadorActual().moverVehiculo(rumbo);
	}
	
	public String pedirMovimientosLimitesDelNivel() {
		return Integer.toString(this.referenciaAlJuego.getJugadorActual().getPartida().getNivel().getCantidadDeMovimientosLimite());
	}
	
	public String pedirMovimientosRealizados() {
		return Integer.toString(this.referenciaAlJuego.getJugadorActual().getPartida().getMapa().getVehiculo().getCantidadDeMovimientos());
	}
	
	public String pedirPuntajeActualComoString(){
		return (Integer.toString(this.referenciaAlJuego.getJugadorActual().getPartida().calcularPuntaje()));
	}

	public String pedirMovimientosSobrantes() {
		int movimientosLimites = this.referenciaAlJuego.getJugadorActual().getPartida().getNivel().getCantidadDeMovimientosLimite();
		int movimientosRealizados = this.referenciaAlJuego.getJugadorActual().getPartida().getMapa().getVehiculo().getCantidadDeMovimientos();
		return (Integer.toString(movimientosLimites - movimientosRealizados));
	}

	public void continuarPartidaGuardada() {
		Partida partida;
		String laPartidaGuardada = this.referenciaAlJuego.getJugadorActual().getPartidaGuardada();
		DespersistidorPartida despersistidorPartida = new DespersistidorPartida();
		partida = despersistidorPartida.despersistirPartida(laPartidaGuardada);
		this.referenciaAlJuego.getJugadorActual().setPartidaActual(partida);
	}
	
	public boolean estaEnJuego() {
		return (this.referenciaAlJuego.getJugadorActual().getPartida().getEstaEnJuego());
	}

	public int pedirPuntajeActual() {
		return (this.referenciaAlJuego.getJugadorActual().getPartida().calcularPuntaje());
	}

	public void persistirJugadorActual() {
		PersistidorJugador persistidor = new PersistidorJugador();
		persistidor.persistirJugador(this.referenciaAlJuego.getJugadorActual());
		System.out.println("ESTA TRATANDO DE PERSISTIR");
	}
}