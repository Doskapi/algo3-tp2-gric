package ar.fi.uba.GPSChallenge.Modelo;

public class ObstaculoPozos extends Obstaculo {
	
	private Vehiculo vehiculo;

	public Estado identificarQueVehiculoEs() {
		return this.vehiculo.getEstado();
	}
	

}
