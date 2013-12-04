package ar.fi.uba.GPSChallenge.Modelo.Imprevistos;

import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class SorpresaDesfavorable extends Sorpresa {
		
	public SorpresaDesfavorable(){
		this.permitirMovimiento = true;
		this.tipoDeImprevisto = "SorpresaDesfavorable";
	}
		
	public boolean getUsada() {
		return this.usada;
	}
	
	public void aplicarImprevisto(Vehiculo vehiculo){
		if(!(usada)){
			int movimientos = vehiculo.getCantidadDeMovimientos();
			vehiculo.setCantidadDeMovimientos(movimientos+(movimientos*25/100));
			}
		this.usada = true;
	}
}	