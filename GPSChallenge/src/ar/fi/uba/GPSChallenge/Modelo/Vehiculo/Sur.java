package ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;

public class Sur extends Rumbo {
	
	public Sur(){
		this.nombre = "Sur";
	}
	
	public Esquina moverVehiculo(Esquina esquina){
		Posicion posicionInicial = esquina.getPosicion();
		Posicion posicionFinal = posicionInicial.moverAlSur();
		return(new Esquina(posicionFinal));
	}
	
	public String getNombre(){
		return this.nombre;
	}
}