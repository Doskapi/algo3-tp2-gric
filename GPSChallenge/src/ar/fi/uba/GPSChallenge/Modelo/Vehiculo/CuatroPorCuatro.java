package ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Estado;

public class CuatroPorCuatro extends Estado{
	
	private double probabilidadDePenalizacion = 0.3;
	
	public CuatroPorCuatro(){
		this.tipoEstado = "CuatroPorCuatro";
	}
	
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
	
	public double getProbabilidadDePenalizacion(){
		return probabilidadDePenalizacion;
	}
	
	public boolean puedeMoverse(){
		return false;
	}
	
	public int devolverPenalizacionPorPasarPorPiquete(){
		int movimientos = 0;
		return movimientos;
	}
	
	public int devolverPenalizacionPorPasarPorControlPolicial(){
		int movimientos = 3;
		return movimientos;
	}
}