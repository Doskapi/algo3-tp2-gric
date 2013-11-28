package ar.fi.uba.GPSChallenge.Modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import ar.fi.uba.GPSChallenge.Modelo.Posicion;

@XmlRootElement
@XmlSeeAlso({Cuadra.class, Vehiculo.class})
public class Esquina {
	
	private Posicion posicion;
	
	public Esquina(Posicion posicion) {
		this.posicion = posicion;
	}

	public Esquina() {
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	@XmlElement
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public boolean equals(Object otraEsquina){
		Esquina esquina = (Esquina)otraEsquina;
		return ((this.getPosicion().equals(esquina.getPosicion())));
	}
	
	
}