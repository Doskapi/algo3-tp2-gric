package ar.fi.uba.GPSChallenge.Modelo;

public class Partida {

	private Mapa mapa;
	private Nivel nivel;
	
	public Partida(Nivel nivel) {
		this.setNivel(nivel);
		this.nivel.pedirUnMapa();
	}

	private void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public Mapa getMapa() {
		return this.mapa;
	}

}
