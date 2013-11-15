package ar.fi.uba.GPSChallenge.Modelo;

public class SorpresaDesfavorable extends Sorpresa {
		
		public void aplicarImprevisto(Vehiculo vehiculo){
			int movimientos = vehiculo.getCantidadDeMovimientos();
			vehiculo.setCantidadDeMovimientos(movimientos+(movimientos*25/100));
		}
	}