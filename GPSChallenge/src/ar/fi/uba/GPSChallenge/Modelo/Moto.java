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
	
	public int agarrarPozos(){
		int movimientos = 3;
		return movimientos;
	}

	public double getProbabilidadDePenalizacion(){
		double probabilidadDePenalizacion = 0.8;
		return probabilidadDePenalizacion;
	}
	
	public boolean puedeMoverse(){
		return true;
	}
	
	public int devolverPenalizacionPorPasarPorPiquete(){
		int movimientos = 2;
		return movimientos;
	}

}

