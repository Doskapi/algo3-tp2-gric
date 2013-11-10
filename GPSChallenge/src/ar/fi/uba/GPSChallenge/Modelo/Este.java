package ar.fi.uba.GPSChallenge.Modelo;

public class Este extends Rumbo {
	
	public Esquina moverVehiculo(Esquina esquina){
		Posicion posicionInicial = esquina.getPosicion();
		Posicion posicionFinal = posicionInicial.moverAlEste();
		return(new Esquina(posicionFinal));
	}
}