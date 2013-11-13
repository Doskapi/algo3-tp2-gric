package ar.fi.uba.GPSChallenge.Modelo;

public class ObstaculoPozos extends Obstaculo {

	private int movimientosDePenalizacion = 3;
	
	public void ObstaculosPozos(){
	}

	public void aplicarImprevisto(Vehiculo vehiculo){
		
		int movimientosDelVehiculo = vehiculo.getCantidadDeMovimientos();
		movimientosDelVehiculo = movimientosDelVehiculo + this.movimientosDePenalizacion;
		if (vehiculo.getNombreEstado() != "CuatroPorCuatro"){
			vehiculo.setCantidadDeMovimientos(movimientosDelVehiculo);
		}
	}
}
