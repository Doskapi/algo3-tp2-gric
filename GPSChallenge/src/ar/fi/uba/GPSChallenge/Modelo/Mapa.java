package ar.fi.uba.GPSChallenge.Modelo;

public class Mapa {
	
	Esquinas esquinas;
	Vehiculo vehiculo;

	public Mapa(int filas, int columnas){
		esquinas = new Esquinas (filas, columnas);
	}
	
	public int getFilas(){
		return(esquinas.getFilas());
	}
	
	public int getColumnas(){
		return(esquinas.getColumnas());
	}

}
