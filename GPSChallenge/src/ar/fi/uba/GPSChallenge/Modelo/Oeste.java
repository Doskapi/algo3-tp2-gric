package ar.fi.uba.GPSChallenge.Modelo;

public class Oeste extends Rumbo {
	
	public Esquina moverVehiculo(Esquina esquina){
		Posicion posicionInicial = esquina.getPosicion();
		Posicion posicionFinal = posicionInicial.moverAlOeste();
		return(new Esquina(posicionFinal));
	}
}