package ar.fi.uba.GPSChallenge.Modelo;

import java.util.ArrayList;

public class Cuadra {

	private ArrayList<Imprevisto> imprevistos;
	
	public Cuadra(Imprevisto imprevisto){
		ArrayList<Imprevisto> imprevistos = new ArrayList<Imprevisto>();
		
	}

	public ArrayList<Imprevisto> getImprevisto() {
		return imprevistos;
	}

	public void setImprevisto(Imprevisto imprevisto) {
		this.imprevistos.add(imprevisto);
	}
	
	
}