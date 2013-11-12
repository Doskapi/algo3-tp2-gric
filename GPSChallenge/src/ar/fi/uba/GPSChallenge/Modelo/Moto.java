package ar.fi.uba.GPSChallenge.Modelo;

import ar.fi.uba.GPSChallenge.Modelo.Estado;

public class Moto implements Estado{
	
	public String getEstado(){
		return "Moto";
	
	}
	
	public Estado nuevoEstado(){
		Auto auto = new Auto();
		return auto;
	}
	
}

