package ar.fi.uba.GPSChallenge.Modelo;

public class SorpresaFavorable extends Sorpresa {
	
	public SorpresaFavorable(){
		this.permitirMovimiento = true;
	}
	
	public void aplicarImprevisto(Vehiculo vehiculo){
		
		if(!(usada)){
			int movimientos = vehiculo.getCantidadDeMovimientos();
			vehiculo.setCantidadDeMovimientos(movimientos-(movimientos*20/100));
			}
		this.usada = true;
	}
}	