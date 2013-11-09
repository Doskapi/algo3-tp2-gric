package ar.fi.uba.GPSChallenge.Modelo;

import java.util.List;
import java.util.ArrayList;

public class Cuadra {

	private List<Imprevisto> imprevistos;
	
	public Cuadra(){
		setImprevistos(new ArrayList<Imprevisto>());
	}

	public List<Imprevisto> getImprevistos() {
		return imprevistos;
	}

	public void setImprevistos(List<Imprevisto> imprevistos) {
		this.imprevistos = imprevistos;
	}
	
	
}