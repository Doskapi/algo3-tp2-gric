package ar.fi.uba.GPSChallenge.Modelo;

import ar.fi.uba.GPSChallenge.Modelo.Estado;

public class CuatroPorCuatro implements Estado{
	
	public String getEstado(){
		return "CuatroPorCuatro";
	}	

	public Estado nuevoEstado(){
		Moto moto = new Moto();
		return moto;
	}
	
	public int agarrarPozos(){
		int movimientos = 0;
		return movimientos;
	}
}
