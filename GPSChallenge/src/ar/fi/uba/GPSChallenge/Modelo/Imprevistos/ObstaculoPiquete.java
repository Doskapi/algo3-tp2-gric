package ar.fi.uba.GPSChallenge.Modelo.Imprevistos;

import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;

public class ObstaculoPiquete extends Obstaculo {

	public ObstaculoPiquete(){
		this.permitirMovimiento = true;
		this.tipoDeImprevisto = "ObstaculoPiquete";
	}
	
	public void aplicarImprevisto(Vehiculo vehiculo){
		vehiculo.agarrarPiquete();
		
		if (!(vehiculo.getEstado().puedeMoverse())) {
			this.permitirMovimiento = false;
		}
	}
}
