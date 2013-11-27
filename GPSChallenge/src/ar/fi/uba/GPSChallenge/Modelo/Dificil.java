package ar.fi.uba.GPSChallenge.Modelo;

public class Dificil implements Nivel {

	public Mapa pedirUnMapa(){
		return new Mapa(9,45);
	}
}