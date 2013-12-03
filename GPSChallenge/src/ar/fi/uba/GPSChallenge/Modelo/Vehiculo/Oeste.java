package ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;

public class Oeste extends Rumbo {
	
	public Oeste(){
		this.nombre = "Oeste";
	}
	
	public Esquina moverVehiculo(Esquina esquina){
		Posicion posicionInicial = esquina.getPosicion();
		Posicion posicionFinal = posicionInicial.moverAlOeste();
		return(new Esquina(posicionFinal));
	}
	
	public String getNombre(){
		return this.nombre;
	}
}