package ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;

public abstract class Rumbo {
	
	protected String nombre;

	public Esquina moverVehiculo(Esquina esquina) {
		return esquina;
	}

	public String getNombre() {
		return nombre;
	}
}

