package ar.fi.uba.GPSChallenge.Modelo;

public class Partida {

	private Mapa mapa;
	private Nivel nivel;
	
	public Partida(Nivel nivel) {
		this.setNivel(nivel);
		this.setMapa(this.nivel.pedirUnMapa());
	}

	private void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public void setMapa(Mapa mapa){
		this.mapa= mapa;
	}
	
	public Nivel getNivel() {
		return this.nivel;
	}

	public Mapa getMapa() {
		return this.mapa;
	}
	
	public void agregarVehiculo(Vehiculo vehiculo){
		this.mapa.agregarVehiculo(vehiculo);
	}

	public void moverVehiculo(Rumbo rumbo) {
		this.mapa.moverVehiculo(rumbo);	
	}
	
	public int calcularPuntaje(){
		int cantidadDeMovimientos;
		int puntaje;
		cantidadDeMovimientos = this.mapa.getVehiculo().getCantidadDeMovimientos();
		puntaje = this.nivel.calcularPuntaje(cantidadDeMovimientos);
		return puntaje;
	}
}
