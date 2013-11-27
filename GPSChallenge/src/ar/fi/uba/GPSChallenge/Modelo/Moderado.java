package ar.fi.uba.GPSChallenge.Modelo;

public class Moderado implements Nivel {

	public Mapa pedirUnMapa(){
		return new Mapa(9,45);
	}
}
