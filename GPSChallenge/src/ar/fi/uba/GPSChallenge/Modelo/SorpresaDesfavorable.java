package ar.fi.uba.GPSChallenge.Modelo;

public class SorpresaDesfavorable extends Sorpresa {
		
		public SorpresaDesfavorable(){
			this.permitirMovimiento = true;
			this.tipoDeImprevisto = "SorpresaDesfavorable";
		}
	
		public void aplicarImprevisto(Vehiculo vehiculo){
	
		if(!(usada)){
			int movimientos = vehiculo.getCantidadDeMovimientos();
			vehiculo.setCantidadDeMovimientos(movimientos+(movimientos*25/100));
			}
		this.usada = true;
	}
}	