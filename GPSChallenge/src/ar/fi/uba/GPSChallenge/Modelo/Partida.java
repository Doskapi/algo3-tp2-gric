package ar.fi.uba.GPSChallenge.Modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Dificil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Facil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Moderado;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Nivel;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Rumbo;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;
import ar.fi.uba.GPSChallenge.Persistencia.PersistidorMapa;

@XmlRootElement
@XmlType(propOrder = {"rutaMapa", "nivel"})
public class Partida {

	private Mapa mapa;
	private String rutaMapa;
	private Nivel nivel;
	private int puntajeActual;
	private boolean estaEnJuego;
	
	public Partida(){
		this.mapa = new Mapa(1,1);
		this.puntajeActual = 0;
		this.estaEnJuego = true;
	}
	
	public Partida(Nivel nivel) {
		this.setNivel(nivel);
		this.setMapa(this.nivel.pedirUnMapa());
		this.puntajeActual = 0;
		this.estaEnJuego = true;
	}
	
	@XmlElement
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public void setMapa(Mapa mapa){
		this.mapa= mapa;
	}
	
	@XmlElement
	public void setRutaMapa(String rutaMapa){
		this.rutaMapa = rutaMapa;
	}
	
	public Nivel getNivel() {
		return this.nivel;
	}
	
	@XmlTransient
	public Mapa getMapa() {
		return this.mapa;
	}
	
	public String getRutaMapa(){
		return this.rutaMapa;
	}
	
	public void agregarVehiculo(Vehiculo vehiculo){
		this.mapa.agregarVehiculo(vehiculo);
	}

	public void moverVehiculo(Rumbo rumbo) throws Exception {
		if(getMapa().getEsquinaMeta().equals(getMapa().getVehiculo().getEsquina())){
			this.estaEnJuego = false;
		}
		else{
			this.mapa.moverVehiculo(rumbo);				
		}
	}
	
	public int calcularPuntaje(){
		int cantidadDeMovimientos;
		int puntaje;
		cantidadDeMovimientos = this.mapa.getVehiculo().getCantidadDeMovimientos();
		puntaje = this.nivel.calcularPuntaje(cantidadDeMovimientos);
		return puntaje;
	}

	public void persistirMapa(String rutaASuCarpeta) {
		this.rutaMapa = rutaASuCarpeta + "Mapa.xml";
		PersistidorMapa persistidor = new PersistidorMapa();
		persistidor.persistirMapa(this.mapa,this.rutaMapa);
	}
	
	public boolean equals(Object otraPartida){
		Partida partida = (Partida)otraPartida;
		Boolean sonIguales = false;
		sonIguales = ((this.getMapa().equals(partida.getMapa())) && (this.getNivel().getTipoNivel() == partida.getNivel().getTipoNivel()));
		return (sonIguales);
	}

	public Nivel getDificultad() {
		return this.nivel;
	}

	public int getPuntajeActual() {
		return this.puntajeActual;
	}
	
	@XmlTransient
	public void setPuntajeActual(int puntajeActual){
		this.puntajeActual = puntajeActual;
	}
	
	public boolean getEstaEnJuego(){
		return this.estaEnJuego;
	}
	
	@XmlTransient
	public void setEstaEnJuego(boolean estaEnJuego){
		this.estaEnJuego = estaEnJuego;
	}
}
