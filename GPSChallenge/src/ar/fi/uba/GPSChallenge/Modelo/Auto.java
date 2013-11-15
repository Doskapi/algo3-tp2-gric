package ar.fi.uba.GPSChallenge.Modelo;

import ar.fi.uba.GPSChallenge.Modelo.Estado;

public class Auto implements Estado{
	
	public String getEstado(){
		return "Auto";
	}	
	
	public Estado nuevoEstado(){
		CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
		return cuatroPorCuatro;
	}
	
	public int agarrarPozos(){
		int movimientos = 3;
		return movimientos;
	}
	
	public double getProbabilidadDePenalizacion(){
		double probabilidadDePenalizacion = 0.5;
		return probabilidadDePenalizacion;
	}

}