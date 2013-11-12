package ar.fi.uba.GPSChallenge.Modelo;

public class Vehiculo {
       
	private Estado estado;
    private Esquina esquina;
    private int movimientos;
       
    public Vehiculo() {
               
    }

    public Vehiculo(Estado estado){
    	this.estado = estado;
        this.movimientos = 0;
    }
       
    public Estado getEstado(){
    	return this.estado;
               
    }
    
    public void setEstado(Estado estado){
    	this.estado = estado;
    }
       
    public int getCantidadDeMovimientos(){
    	return movimientos;
    }
         
    private void sumarMovimientos(){
    	movimientos = (movimientos + 1);
               
    }
       
    public void setCantidadDeMovimientos(int movimientos){
    	this.movimientos = movimientos;
    }
    
    public void colocarEnEsquina(Esquina esquina) {
		this.esquina = esquina;
	}
	
	public Esquina devolverEsquina(){
		return this.esquina;
	}
    
	public void mover(Rumbo rumbo){
		colocarEnEsquina(rumbo.moverVehiculo(devolverEsquina()));
		this.sumarMovimientos();
	}

	public Estado getNuevoEstado(){
		return this.estado.nuevoEstado();
	}

	public String getNombreEstado(){
		return this.estado.getEstado();
	}
}

