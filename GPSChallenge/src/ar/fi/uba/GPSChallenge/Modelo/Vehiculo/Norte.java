package ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;

public class Norte extends Rumbo {
	
	public Norte(){
		this.nombre = "Norte";
	}
	
	public Esquina moverVehiculo(Esquina esquina){
		Posicion posicionInicial = esquina.getPosicion();
		Posicion posicionFinal = posicionInicial.moverAlNorte();
		return(new Esquina(posicionFinal));
	}
	
	public String getNombre(){
		return this.nombre;
	}
}
