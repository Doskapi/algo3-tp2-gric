package ar.fi.uba.GPSChallenge.Modelo;

public class Vehiculo {
	
	private Estado estado;
	
	public Vehiculo() {
		
	}

	public Vehiculo(Estado estado){
		this.estado = estado;
	}
	
	public Estado getEstado(){
		return this.estado;
		
	}

}
