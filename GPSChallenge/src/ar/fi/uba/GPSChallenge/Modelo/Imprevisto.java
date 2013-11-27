package ar.fi.uba.GPSChallenge.Modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "tipoDeImprevisto")
@XmlSeeAlso({Cuadra.class})
public class Imprevisto {
	
	protected String tipoDeImprevisto;
	protected boolean permitirMovimiento;
	
	public void aplicarImprevisto(Vehiculo vehiculo){	
	}

	public boolean decidirSiMovimientoEstaPermitido() {
		return permitirMovimiento;
	}
	
	@XmlElement
	public String getTipoDeImprevisto(){
		return tipoDeImprevisto;
	}
	
	public void setTipoDeImprevisto(String tipo){
		this.tipoDeImprevisto = tipo;
	}
}
