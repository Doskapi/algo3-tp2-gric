package ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "tipoEstado")
@XmlSeeAlso({Vehiculo.class})
public class Estado {

	protected String tipoEstado;
	
	public Estado(){
		this.tipoEstado = "Estado";
	}

	public String getTipoEstado(){
		return tipoEstado;
	}
	
	@XmlElement
	public void setTipoEstado(String tipoEstado){
		this.tipoEstado = tipoEstado;
	}
	
	public Estado nuevoEstado(){
		Estado estado = new Estado();
		return estado;
	}

	public int agarrarPozos(){
		return 0;
	}

	public double getProbabilidadDePenalizacion(){
		return 0;
	}
	
	public int devolverPenalizacionPorPasarPorPiquete(){
		return 0;
	}
	
	public  int devolverPenalizacionPorPasarPorControlPolicial(){
		return 0;
	}
	
	public boolean puedeMoverse(){
		return false;
	}
}
