
package ar.fi.uba.GPSChallenge.Modelo;

public class SorpresaCambioDeVehiculo extends Sorpresa {
	
	public SorpresaCambioDeVehiculo(){
		this.permitirMovimiento = true;
		this.tipoDeImprevisto = "SopresaCambioDeVehiculo";
	}
	
	public void aplicarImprevisto(Vehiculo vehiculo){
		
		if(!(usada)){
			Estado estadoModificado = vehiculo.getNuevoEstado();
			vehiculo.setEstado(estadoModificado);
			
		}
		this.usada = true;
	}
}
