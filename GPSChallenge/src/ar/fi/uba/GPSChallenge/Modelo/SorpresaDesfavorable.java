package ar.fi.uba.GPSChallenge.Modelo;

public class SorpresaDesfavorable extends Sorpresa {

	public void aplicarSorpresa(int cantidadDeMovimientos) {

		int movimientos = cantidadDeMovimientos;
		cantidadDeMovimientos = (movimientos+(movimientos*25/100));
		
	}
	

}
