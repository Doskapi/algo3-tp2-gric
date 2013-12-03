package ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;

public class Este extends Rumbo {
	
	public Este(){
		this.nombre = "Este";
	}
	
	public Esquina moverVehiculo(Esquina esquina){
		Posicion posicionInicial = esquina.getPosicion();
		Posicion posicionFinal = posicionInicial.moverAlEste();
		return(new Esquina(posicionFinal));
	}
	
	public String getNombre(){
		return this.nombre;
	}
}