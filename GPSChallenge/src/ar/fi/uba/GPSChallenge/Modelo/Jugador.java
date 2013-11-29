package ar.fi.uba.GPSChallenge.Modelo;

import java.io.File;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Nivel;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Rumbo;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;
import ar.fi.uba.GPSChallenge.Persistencia.PersistidorPartida;

@XmlRootElement
@XmlType(propOrder = {"nombre","puntaje","partidaGuardada","rutaASuCarpeta"})
public class Jugador {
	
	private String nombre;
	private int puntaje;
	private Partida partidaActual;
	private String partidaGuardada;
	private String rutaASuCarpeta;
	
	public Jugador(){
	}
	
	public Jugador(String nombre){
		this.setNombre(nombre);
		this.setPuntaje(0);
		this.generarRutaASuCarpeta();
		File creadorDeCarpeta = new File(this.rutaASuCarpeta);
		creadorDeCarpeta.mkdir();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public Partida getPartida(){
		return this.partidaActual;
	}
	
	public void comenzarPartida(Nivel nivel){
		this.partidaActual = new Partida(nivel);
	}
	
	@XmlElement
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	@XmlElement
	public void setPuntaje(int puntaje){
		this.puntaje = puntaje;
	}
	
	public String getPartidaGuardada(){
		return this.partidaGuardada;
	}
	
	@XmlElement
	public void setPartidaGuardada(String partidaGuardada){
		this.partidaGuardada = partidaGuardada;
	}
	
	public String getRutaASuCarpeta (){
		return this.rutaASuCarpeta;
	}

	@XmlElement
	public void setRutaASuCarpeta (String rutaASuCarpeta){
		this.rutaASuCarpeta = rutaASuCarpeta;
	}
	
	private void generarRutaASuCarpeta(){
		this.rutaASuCarpeta = System.getProperty("user.dir") + System.getProperty("file.separator") + "Jugadores" + System.getProperty("file.separator") + this.getNombre() + System.getProperty("file.separator");
	}
	
	public void elegirVehiculo(Vehiculo vehiculo) {
		this.partidaActual.agregarVehiculo(vehiculo);	
	}
	
	public void moverVehiculo(Rumbo rumbo) throws Exception{
		this.partidaActual.moverVehiculo(rumbo);
	}
	
	public Posicion pedirPosicionDelVehiculo(){
		return (this.partidaActual.getMapa().getVehiculo().getEsquina().getPosicion());
	}
	
	public void calcularPuntaje(){
		int puntajeActual = (this.partidaActual.calcularPuntaje());
		if (puntajeActual > this.puntaje){
			this.puntaje = puntajeActual;
		}	
	}
	
	public void persistirPartida(){
		PersistidorPartida persistidor = new PersistidorPartida();
		persistidor.persistirPartida(this.partidaActual,this.rutaASuCarpeta);
		this.partidaGuardada = rutaASuCarpeta + System.getProperty("file.separator") + "PartidaGuardada.xml";
		
	}
	
}
