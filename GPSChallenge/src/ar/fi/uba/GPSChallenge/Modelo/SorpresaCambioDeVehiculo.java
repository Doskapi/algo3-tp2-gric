
package ar.fi.uba.GPSChallenge.Modelo;

public class SorpresaCambioDeVehiculo extends Sorpresa {
	
	public void aplicarImprevisto(Vehiculo vehiculo){
		
		Estado estadoModificado = vehiculo.getNuevoEstado();
		vehiculo.setEstado(estadoModificado);
		
	}
}
