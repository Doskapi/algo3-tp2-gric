package ar.fi.uba.GPSChallenge.Modelo;

public class SorpresaFavorable extends Sorpresa {
		
	public int aplicarSorpresa(int cantidadDeMovimientos){
		
		int movimientos = cantidadDeMovimientos;
		cantidadDeMovimientos = (movimientos-(movimientos*20/100));

		return cantidadDeMovimientos;
	}
}
	