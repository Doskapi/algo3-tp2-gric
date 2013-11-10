package ar.fi.uba.GPSChallenge.Modelo;

import ar.fi.uba.GPSChallenge.Modelo.Posicion;

public class Esquina {
	
	private Posicion posicion;
	private boolean hayVehiculo;
	
	public Esquina(){
		this.hayVehiculo = false;
		
	}
	
	public Esquina(Posicion posicion) {
		this.posicion = posicion;
		this.hayVehiculo = false;
	}

	public Posicion getPosicion() {
		
		return posicion;
	}
	
	public boolean hayVehiculo(){
		return this.hayVehiculo;
	}
	
	public void agregarVehiculo(){
		this.hayVehiculo = true;
	}
	
}
	
