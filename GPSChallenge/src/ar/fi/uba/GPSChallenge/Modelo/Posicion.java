package ar.fi.uba.GPSChallenge.Modelo;

public class Posicion {

	private int fila;
	private int columna;
	
	
	public Posicion(){
		
	}
	
	public Posicion(int columna, int fila){
		this.fila = fila;
		this.columna = columna;
	
	}
	
	public boolean equals(Object otraPosicion){
		Posicion p = (Posicion)otraPosicion;
		return (this.fila == p.fila && this.columna == p.columna);
	}

}


