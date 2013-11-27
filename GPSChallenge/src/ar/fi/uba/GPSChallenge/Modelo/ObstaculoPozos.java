package ar.fi.uba.GPSChallenge.Modelo;

public class ObstaculoPozos extends Obstaculo {

	public ObstaculoPozos(){
		this.permitirMovimiento = true;
		this.tipoDeImprevisto = "ObstaculoPozos";
	}
	
	public void aplicarImprevisto(Vehiculo vehiculo){
		vehiculo.agarrarPozos();
	}
}
