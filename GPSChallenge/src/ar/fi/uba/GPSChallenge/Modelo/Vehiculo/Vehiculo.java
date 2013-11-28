package ar.fi.uba.GPSChallenge.Modelo.Vehiculo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ar.fi.uba.GPSChallenge.Modelo.Mapa.Esquina;

@XmlRootElement
@XmlType(propOrder = {"estado", "esquina", "cantidadDeMovimientos"})
public class Vehiculo {
       
	private Estado estado;
    private Esquina esquina;
    private int cantidadDeMovimientos;
       
    public Vehiculo(Estado estado){
    	this.estado = estado;
        this.cantidadDeMovimientos = 0;
    }
       
    public Vehiculo() {
	}

	public Estado getEstado(){
    	return this.estado;    
    }
	
	@XmlElement
    public void setEstado(Estado estado){
    	this.estado = estado;
    }
       
    public int getCantidadDeMovimientos(){
    	return this.cantidadDeMovimientos;
    }
         
    private void sumarMovimientos(){
    	cantidadDeMovimientos = (cantidadDeMovimientos + 1);     
    }
      
    @XmlElement
    public void setCantidadDeMovimientos(int movimientos){
    	this.cantidadDeMovimientos = movimientos;
    }
    
    @XmlElement
    public void setEsquina(Esquina esquina){
    	this.esquina = esquina;
    }
    
    public void colocarEnEsquina(Esquina esquina) {
		this.esquina = esquina;
	}
	
	public Esquina getEsquina(){
		return this.esquina;
	}
    
	public void mover(Rumbo rumbo){
		colocarEnEsquina(rumbo.moverVehiculo(getEsquina()));
		this.sumarMovimientos();
	}
	
	public Estado getNuevoEstado(){
		return this.estado.nuevoEstado();
	}
	
	public String getNombreEstado(){
		return this.estado.getTipoEstado();
	}

	public void agarrarPozos(){
		int movimientosAAgregar = this.estado.agarrarPozos();
		this.cantidadDeMovimientos = this.cantidadDeMovimientos + movimientosAAgregar;
	}
	
	public double getProbabilidadDePenalizacion(){
		return this.estado.getProbabilidadDePenalizacion();
	}
	
	public void agarrarPiquete(){
		int movimientosAAgregar = this.estado.devolverPenalizacionPorPasarPorPiquete();
		this.cantidadDeMovimientos = this.cantidadDeMovimientos + movimientosAAgregar;
		}		
	
	public boolean equals(Object otroVehiculo){
		Vehiculo v = (Vehiculo)otroVehiculo;
		return (this.getEstado().getTipoEstado() == v.getEstado().getTipoEstado());
	}
}

