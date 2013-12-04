package ar.fi.uba.GPSChallenge.Modelo.Imprevistos;

import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class SorpresaFavorable extends Sorpresa {
	
	public SorpresaFavorable(){
		this.permitirMovimiento = true;
		this.tipoDeImprevisto = "SorpresaFavorable";
	}
	
	public boolean getUsada() {
		return this.usada;
	}
	
	public void aplicarImprevisto(Vehiculo vehiculo){
		if(!(usada)){
			int movimientos = vehiculo.getCantidadDeMovimientos();
			vehiculo.setCantidadDeMovimientos(movimientos-(movimientos*20/100));
			}
		this.usada = true;
	}
}	