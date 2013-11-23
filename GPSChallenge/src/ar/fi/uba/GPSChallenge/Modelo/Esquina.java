package ar.fi.uba.GPSChallenge.Modelo;

import ar.fi.uba.GPSChallenge.Modelo.Posicion;

public class Esquina {
	
	private Posicion posicion;
	
	public Esquina(Posicion posicion) {
		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public boolean equals(Object otraEsquina){
		Esquina esquina = (Esquina)otraEsquina;
		return ((this.getPosicion().equals(esquina.getPosicion())));
	}
	
	
}