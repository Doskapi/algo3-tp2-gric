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
}
