package ar.fi.uba.GPSChallenge.Modelo;

public class SorpresaFavorable extends Sorpresa {
		
	public void aplicarSorpresa(int cantidadDeMovimientos){
		
		int movimientos = cantidadDeMovimientos;
		cantidadDeMovimientos = (movimientos-(movimientos*20/100));
	}
}
	