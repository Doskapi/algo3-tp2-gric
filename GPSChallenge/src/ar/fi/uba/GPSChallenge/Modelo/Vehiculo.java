package ar.fi.uba.GPSChallenge.Modelo;

public class Vehiculo {
	
	private Estado estado;
	private Esquina esquina;
	
	public Vehiculo() {
		
	}

	public Vehiculo(Estado estado){
		this.estado = estado;
	}
	
	public Estado getEstado(){
		return this.estado;
		
	}

}
