package ar.fi.uba.GPSChallenge.Modelo;

import java.io.File;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"nombre","puntaje","partidaGuardada"})
public class Jugador {
	
	private String nombre;
	private int puntaje;
	private String partidaGuardada;
	
	public Jugador(){
	}
	
	public Jugador(String nombre){
		this.nombre = nombre;
		this.puntaje = 0;
		File carpetaDelJugador = new File(nombre);
		carpetaDelJugador.mkdir();
		String direccionDeLaCarpeta = carpetaDelJugador.getAbsolutePath();
		File archivoDelJugador = new File( direccionDeLaCarpeta + "/PartidaDe" + nombre + ".xml");
		this.partidaGuardada = archivoDelJugador.getAbsolutePath();
	}
	
	public String getNombre(){
		return this.nombre;
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
	
}
