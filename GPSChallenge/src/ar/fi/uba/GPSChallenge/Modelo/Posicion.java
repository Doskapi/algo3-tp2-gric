package ar.fi.uba.GPSChallenge.Modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Esquina.class})
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
	
	@XmlElement
	public void setFila(int fila){
		this.fila = fila;
	}
	
	public int getColumna(){
		return this.columna;
	}
	
	@XmlElement
	public void setColumna(int columna){
		this.columna = columna;
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

	public void setPosicionRandom(int filas, int columnas) {
		this.fila = 1 + (int)(Math.random() * filas);
		this.columna = 1 + (int)(Math.random() * columnas);
	}
	
	public Posicion getContiguaRandom(int filas, int columnas) {
		Posicion posicion = new Posicion();
		boolean posicionValida = false;
		while(!posicionValida){
			int sorteo = 1 + (int)(Math.random() * 4);
			switch(sorteo) {
			 case 1: 
				 posicion = new Posicion(this.getFila()-1,this.getColumna());
				 posicionValida = posicion.validarPosicion(filas, columnas);
			     break;
			 case 2: 
				 posicion = new Posicion(this.getFila(),this.getColumna()+1);
				 posicionValida = posicion.validarPosicion(filas, columnas);
			     break;
			 case 3: 
				 posicion = new Posicion(this.getFila()+1,this.getColumna());
				 posicionValida = posicion.validarPosicion(filas, columnas);
			     break;
			 case 4: 
				 posicion = new Posicion(this.getFila(),this.getColumna()-1);
				 posicionValida = posicion.validarPosicion(filas, columnas);
			     break;
			}	
		}
		return posicion;
	}

	private boolean validarPosicion(int filas, int columnas) {
		boolean laPosicionEsValida = false;
		if((this.getFila() > 0) && (this.getFila() <= filas)){
			if((this.getColumna() > 0) && (this.getColumna() <= columnas)){
				laPosicionEsValida = true;
			}
		}
		return laPosicionEsValida;
	}
}

