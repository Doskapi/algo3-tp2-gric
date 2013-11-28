package ar.fi.uba.GPSChallenge.Modelo.Imprevistos;

import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class ObstaculoPozos extends Obstaculo {

	public ObstaculoPozos(){
		this.permitirMovimiento = true;
		this.tipoDeImprevisto = "ObstaculoPozos";
	}
	
	public void aplicarImprevisto(Vehiculo vehiculo){
		vehiculo.agarrarPozos();
	}
}
