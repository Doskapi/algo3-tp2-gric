package ar.fi.uba.GPSChallenge.Modelo;

public abstract class Imprevisto {
	
	protected boolean permitirMovimiento;

	public void aplicarImprevisto(Vehiculo vehiculo){	
	}

	public boolean decidirSiMovimientoEstaPermitido() {
		return permitirMovimiento;
	}
}
