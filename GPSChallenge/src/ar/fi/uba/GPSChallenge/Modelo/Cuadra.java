package ar.fi.uba.GPSChallenge.Modelo;

import java.util.ArrayList;

public class Cuadra {

	private ArrayList<Imprevisto> imprevistos;
	
	public Cuadra(Imprevisto imprevisto){
		this.imprevistos = new ArrayList<Imprevisto>();
		this.imprevistos.add(imprevisto);
	}

	public ArrayList<Imprevisto> getImprevistos() {
		return imprevistos;
	}


	public void agregarImprevisto(Imprevisto imprevisto) {
		imprevistos.add(imprevisto);
		
	}
	
	//Se supone al derecho de izquierda a derecha o de arriba a abajo
	public void aplicarImprevistosAlDerecho(Vehiculo vehiculo){
		int tamanio = imprevistos.size();
		for(int x = 0;x<tamanio;x=x+1){
			(imprevistos.get(x)).aplicarImprevisto(vehiculo);
		}
	}

	//Se supone al reves de derecha a izquierda o de abajo hacia arriba
	public void aplicarImprevistosAlReves(Vehiculo vehiculo) {
		int tamanio = imprevistos.size();
		for(int x = (tamanio-1);x>=0;x=x-1){
			(imprevistos.get(x)).aplicarImprevisto(vehiculo);
		}
		
	}
	
	
	
}