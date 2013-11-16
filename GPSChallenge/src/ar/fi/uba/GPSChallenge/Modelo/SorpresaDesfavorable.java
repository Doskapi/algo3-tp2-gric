package ar.fi.uba.GPSChallenge.Modelo;

public class SorpresaDesfavorable extends Sorpresa {
		
		public SorpresaDesfavorable(){
			this.permitirMovimiento = true;
		}
	
		public void aplicarImprevisto(Vehiculo vehiculo){
			int movimientos = vehiculo.getCantidadDeMovimientos();
			vehiculo.setCantidadDeMovimientos(movimientos+(movimientos*25/100));
		}
	}