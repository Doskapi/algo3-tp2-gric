package ar.fi.uba.GPSChallenge.Modelo;

public class Sur extends Rumbo {
	
	public Esquina moverVehiculo(Esquina esquina){
		Posicion posicionInicial = esquina.getPosicion();
		Posicion posicionFinal = posicionInicial.moverAlSur();
		return(new Esquina(posicionFinal));
	}
}