package ar.fi.uba.GPSChallenge.Modelo;

import java.util.ArrayList;

public class Cuadra {

	private ArrayList<Imprevisto> imprevistos;
	private Esquina esquinaInicial;
	private Esquina esquinaFinal;
	
	public Cuadra(){
	}
	
	public Cuadra(Esquina esquinaInicial, Esquina esquinaFinal){
		this.imprevistos = new ArrayList<Imprevisto>();
		this.esquinaInicial = esquinaInicial;
		this.esquinaFinal = esquinaFinal;
	}

	public ArrayList<Imprevisto> getImprevistos() {
		return this.imprevistos;
	}


	public void agregarImprevisto(Imprevisto imprevisto) {
		this.imprevistos.add(imprevisto);
		
	}
	
	//Se supone al derecho de izquierda a derecha o de arriba a abajo
	public void aplicarImprevistosAlDerecho(Vehiculo vehiculo){
		int tamanio = this.imprevistos.size();
		for(int x = 0;x<tamanio;x=x+1){
			(this.imprevistos.get(x)).aplicarImprevisto(vehiculo);
		}
	}

	//Se supone al reves de derecha a izquierda o de abajo hacia arriba
	public void aplicarImprevistosAlReves(Vehiculo vehiculo) {
		int tamanio = this.imprevistos.size();
		for(int x = (tamanio-1);x>=0;x=x-1){
			(this.imprevistos.get(x)).aplicarImprevisto(vehiculo);
		}
		
	}

	public Esquina getEsquinaInicial() {
		return this.esquinaInicial;
	}

	public Esquina getEsquinaFinal() {
		return this.esquinaFinal;
	}
	
	public boolean equals(Object otraCuadra){
		Cuadra cuadra = (Cuadra)otraCuadra;
		boolean sonIguales = false;
		sonIguales = ((this.getEsquinaInicial().equals(cuadra.getEsquinaInicial())) && (this.getEsquinaFinal().equals(cuadra.getEsquinaFinal())))
				|| ((this.getEsquinaInicial().equals(cuadra.getEsquinaFinal())) && (this.getEsquinaFinal().equals(cuadra.getEsquinaInicial())));
		return sonIguales;
	}
	
	
	
}