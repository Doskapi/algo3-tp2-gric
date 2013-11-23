package ar.fi.uba.GPSChallenge.Modelo;

public class ObstaculoPolicial extends Obstaculo {
	
	public ObstaculoPolicial(){
		this.permitirMovimiento = true;
	}
	
	public void aplicarImprevisto(Vehiculo vehiculo){
		
		double sorteoProbabilidad = Math.random();
		
		if (sorteoProbabilidad <= (vehiculo.getProbabilidadDePenalizacion())){
		
			int movimientosDelVehiculo = vehiculo.getCantidadDeMovimientos();
			movimientosDelVehiculo = movimientosDelVehiculo + vehiculo.getEstado().devolverPenalizacionPorPasarPorControlPolicial();
			vehiculo.setCantidadDeMovimientos(movimientosDelVehiculo);		
		}
	}

	//El método que sigue es sólo para ser utilizado en pruebas
	
	public void aplicarImprevistoMetodoParaTesteo(Vehiculo vehiculo, double probabilidadEstatica){
		
		if (probabilidadEstatica <= (vehiculo.getProbabilidadDePenalizacion())){
		
			int movimientosDelVehiculo = vehiculo.getCantidadDeMovimientos();
			movimientosDelVehiculo = movimientosDelVehiculo + vehiculo.getEstado().devolverPenalizacionPorPasarPorControlPolicial();
			vehiculo.setCantidadDeMovimientos(movimientosDelVehiculo);		
		}
	}

}
