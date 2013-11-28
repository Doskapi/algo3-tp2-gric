package ar.fi.uba.GPSChallenge.Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"imprevistos", "esquinaInicial", "esquinaFinal"})
@XmlSeeAlso({Mapa.class})
public class Cuadra {

	private ArrayList<Imprevisto> imprevistos;
	private Esquina esquinaInicial;
	private Esquina esquinaFinal;
	
	public Cuadra(){
	}
	
	public Cuadra(Esquina esquinaInicial, Esquina esquinaFinal){
		this.imprevistos = new ArrayList<Imprevisto>();
		this.setEsquinaInicial(esquinaInicial);
		this.setEsquinaFinal(esquinaFinal);
	}
	
	public ArrayList<Imprevisto> getImprevistos() {
		return this.imprevistos;
	}
	
	@XmlElementWrapper
	@XmlElement(name = "imprevisto")
	public void setImprevistos(ArrayList<Imprevisto> imprevistos){
		this.imprevistos = imprevistos;
	}
	
	
	public void agregarImprevisto(Imprevisto imprevisto) {
		this.imprevistos.add(imprevisto);
	}
	
	
	@XmlElement (name = "esquinaInicial")
	public void setEsquinaInicial(Esquina esquinaInicial){
		this.esquinaInicial = esquinaInicial;
	}
	
	@XmlElement (name = "esquinaFinal")
	public void setEsquinaFinal(Esquina esquinaFinal){
		this.esquinaFinal = esquinaFinal;
	}
	
	public void aplicarImprevistos(Vehiculo vehiculo, Esquina esquinaInicial, Esquina esquinaFinal) {
		if (this.getEsquinaInicial().equals(esquinaInicial) && (this.getEsquinaFinal().equals(esquinaFinal))){
			aplicarImprevistosAlDerecho(vehiculo);
		}
		if (this.getEsquinaInicial().equals(esquinaFinal) && (this.getEsquinaFinal().equals(esquinaInicial))){
			aplicarImprevistosAlReves(vehiculo);
		}
	}
	
	//Se supone al derecho de izquierda a derecha o de arriba a abajo
	public void aplicarImprevistosAlDerecho(Vehiculo vehiculo){
		boolean movimientoPermitido = true;
		int tamanio = this.imprevistos.size();
		if(movimientoPermitido){
			for(int x = 0;x<tamanio;x=x+1){
				(this.imprevistos.get(x)).aplicarImprevisto(vehiculo);
				movimientoPermitido = this.imprevistos.get(x).decidirSiMovimientoEstaPermitido();
			}
		}
	}

	//Se supone al reves de derecha a izquierda o de abajo hacia arriba
	public void aplicarImprevistosAlReves(Vehiculo vehiculo) {
		boolean movimientoPermitido = true;
		int tamanio = this.imprevistos.size();
		if(movimientoPermitido){
			for(int x = (tamanio-1);x>=0;x=x-1){
				(this.imprevistos.get(x)).aplicarImprevisto(vehiculo);
				movimientoPermitido = this.imprevistos.get(x).decidirSiMovimientoEstaPermitido();
			}
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

	public boolean decidirSiMovimientoEstaPermitido() {
		boolean movimientoPermitido = true;
		Imprevisto imprevistoActual;
		Iterator<Imprevisto> iterador = this.imprevistos.iterator();
		while(iterador.hasNext() && movimientoPermitido){
			imprevistoActual = (Imprevisto)iterador.next();
			movimientoPermitido = imprevistoActual.decidirSiMovimientoEstaPermitido();
		}
		return movimientoPermitido;
	}
}