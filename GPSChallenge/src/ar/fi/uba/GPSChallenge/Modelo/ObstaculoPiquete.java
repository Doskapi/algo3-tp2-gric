package ar.fi.uba.GPSChallenge.Modelo;

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
	
	public String getTipoImprevistoComoString(){
		String tipoImprevisto = "ObstaculoPiquete";
		return tipoImprevisto;
	}
}
