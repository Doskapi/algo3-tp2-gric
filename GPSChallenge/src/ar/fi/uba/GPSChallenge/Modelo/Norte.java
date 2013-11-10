package ar.fi.uba.GPSChallenge.Modelo;

public class Norte extends Rumbo {
	
	public Esquina moverVehiculo(Esquina esquina){
		Posicion posicionInicial = esquina.getPosicion();
		Posicion posicionFinal = posicionInicial.moverAlNorte();
		return(new Esquina(posicionFinal));
	}
}
