package ar.fi.uba.GPSChallenge.Modelo;

public class Posicion {

	private int fila;
	private int columna;
	
	
	public Posicion(){
		
	}
	
	public Posicion(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
	
	}
	
	public boolean equals(Posicion otraPosicion){
		Posicion p = (Posicion)otraPosicion;
		return (this.fila == p.fila && this.columna == p.columna);
	}

}


