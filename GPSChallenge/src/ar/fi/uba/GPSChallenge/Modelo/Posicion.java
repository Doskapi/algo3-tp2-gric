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
	
	public boolean equals(Object otraPosicion){
		Posicion p = (Posicion)otraPosicion;
		return (this.fila == p.fila && this.columna == p.columna);
	}
	
	public int getFila(){
		return this.fila;
	}
	
	public int getColumna(){
		return this.columna;
	}

	public Posicion moverAlNorte() {
		int filaNueva = getFila() - 1;
		int columnaNueva = getColumna();
		return (new Posicion (filaNueva,columnaNueva));
	}

	public Posicion moverAlSur() {
		int filaNueva = getFila() + 1;
		int columnaNueva = getColumna();
		return (new Posicion (filaNueva,columnaNueva));
	}

	public Posicion moverAlEste() {
		int filaNueva = getFila();
		int columnaNueva = getColumna() + 1;
		return (new Posicion (filaNueva,columnaNueva));
	}

	public Posicion moverAlOeste() {
		int filaNueva = getFila();
		int columnaNueva = getColumna() - 1;
		return (new Posicion (filaNueva,columnaNueva));
	}
}

