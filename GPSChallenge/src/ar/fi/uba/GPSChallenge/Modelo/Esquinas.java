package ar.fi.uba.GPSChallenge.Modelo;

import java.util.*;

public class Esquinas {
	
	List<ArrayList<Esquina>> esquinas = new ArrayList<ArrayList<Esquina>>();
	int filas;
	int columnas;
	
	public Esquinas(int filas, int columnas){
		
		for(int i = 1; i <= filas; i++){
			ArrayList<Esquina> contenido = new ArrayList<Esquina>();
			for(int j = 1; j <= columnas; j++){
				contenido.add(new Esquina());
			}
			esquinas.add(contenido);
			}
		this.filas = filas;
		this.columnas = columnas;
	}
	
	public int getFilas(){
		return (this.filas);
	}
	
	public int getColumnas(){
		return (this.columnas);
	}
	
	public Esquina devolverEsquina (int fila, int columna){
		List<Esquina> aux = esquinas.get(fila - 1);
		return (aux.get(columna - 1));
	}

}