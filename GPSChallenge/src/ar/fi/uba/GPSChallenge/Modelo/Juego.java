package ar.fi.uba.GPSChallenge.Modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Juego extends Observable {
	
	private List<Jugador> jugadores;
	private Jugador jugadorActual;
	
	public Juego(){
		this.jugadorActual = new Jugador();
		this.jugadores = new ArrayList<Jugador>();
		String rutaDeCarpetaJugadores = System.getProperty("user.dir") + System.getProperty("file.separator") + "Jugadores";
		File creadorDeCarpeta = new File(rutaDeCarpetaJugadores);
		creadorDeCarpeta.mkdir();	
	}
	
	@XmlElementWrapper(name = "listajugadores")
	@XmlElement(name = "jugador")
	public void setJugadores(List<Jugador> jugadores){
		this.jugadores = jugadores;
	}
	
	public void agregarJugador(Jugador jugador){
		this.jugadores.add(jugador);
	}
	
	public List<Jugador> getJugadores(){
		return this.jugadores;
	}
	
	@XmlTransient
	public void setJugador(Jugador jugador){
		this.jugadorActual = jugador;
	}
	
	public Jugador getJugador(){
		return this.jugadorActual;
	}
	
	public boolean equals(Object otroJuego){
		Juego juego = (Juego) otroJuego;
		boolean sonIguales = true;
		sonIguales = this.getJugadores().size() == juego.getJugadores().size();
		return (sonIguales);
	}
	
	public void actualizarObservadores(){
		setChanged();
		notifyObservers();
	}
}
