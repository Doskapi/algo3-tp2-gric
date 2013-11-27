package ar.fi.uba.GPSChallenge.Modelo;

import java.util.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.soap.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@XmlRootElement
@XmlType(propOrder = {"filas","columnas","esquinaLargada","esquinaMeta","vehiculo","cuadras"})
public class Mapa implements Serializable{

	private static final long serialVersionUID = 1L;
	private int filas;
	private int columnas;
	Esquina esquinaLargada;
	Esquina esquinaMeta;
	Vehiculo vehiculo;
	List<Cuadra> cuadras;

	public Mapa(){
		this.cuadras = new ArrayList<Cuadra>();
	}
	
	public Mapa(int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
		this.setLargada();
		this.setMeta();
		this.cuadras = new ArrayList<Cuadra>();	
	}
	
	public void setLargada() {
		int columnaLargada = 1;
		int filaLargada = (1 + (int)(Math.random() * ((this.filas - 1) + 1)));
		Esquina esquinaLargada = new Esquina(new Posicion(filaLargada, columnaLargada));
		setEsquinaLargada(esquinaLargada);
	}
	
	public void setMeta() {
		int columnaMeta = this.columnas;
		int filaMeta = (1 + (int)(Math.random() * ((this.filas - 1) + 1)));
		Esquina esquinaMeta = new Esquina(new Posicion(filaMeta, columnaMeta));
		setEsquinaMeta(esquinaMeta);
	}
	
	@XmlElement(name = "esquinaLargada")
	public void setEsquinaLargada(Esquina esquina){
		this.esquinaLargada = esquina;
	}
	
	@XmlElement(name = "esquinaMeta")
	public void setEsquinaMeta(Esquina esquina){
		this.esquinaMeta = esquina;
	
	}
	
	public void agregarCuadra(Cuadra cuadra){
		this.cuadras.add(cuadra);
	}
	
	@XmlElementWrapper
	@XmlElement(name = "cuadras")
	public void setCuadras(List<Cuadra> listaDeCuadras){
		this.cuadras = listaDeCuadras;
	}
	
	public Esquina getEsquinaMeta(){
		return(this.esquinaMeta);
	}
	
	public Esquina getEsquinaLargada(){
		return(this.esquinaLargada);
	}

	public int cantidadDeElementos(){
		return((this.filas) * (this.columnas));
	}
	
	public int getFilas(){
		return this.filas;
	}
	
	public int getColumnas(){
		return this.columnas;
	}
	
	@XmlElement (name = "filas")
	public void setFilas(int filas){
		this.filas = filas;
	}
	
	@XmlElement (name = "columnas")
	public void setColumnas(int columnas){
		this.columnas = columnas;
	}
	
	@XmlElement (name = "vehiculo")
	public void setVehiculo(Vehiculo vehiculo){
		this.vehiculo = vehiculo;
	}
	
	public void agregarVehiculo(Vehiculo vehiculo){
		this.vehiculo = vehiculo;
		this.vehiculo.setEsquina(this.esquinaLargada);
	}
	
	public Vehiculo getVehiculo(){
		return(this.vehiculo);
	}
	
	public List<Cuadra> getCuadras() {
		return this.cuadras;
	}

	public void moverVehiculo(Rumbo rumbo){
		boolean movimientoPermitido = true;
		movimientoPermitido = pasarPorCuadra(rumbo);
		if (movimientoPermitido){
			this.vehiculo.mover(rumbo);
		}
	}
	
	public boolean pasarPorCuadra(Rumbo rumbo){
		Esquina esquinaInicial = this.vehiculo.getEsquina();
		Esquina esquinaFinal = rumbo.moverVehiculo(this.vehiculo.getEsquina());
		boolean movimientoPermitido = true;
		Cuadra cuadraAAtravesar = new Cuadra(esquinaInicial, esquinaFinal);
		Iterator<Cuadra> iterador = this.cuadras.iterator();
		while(iterador.hasNext()){
			Cuadra cuadraActual = iterador.next();
			if(cuadraAAtravesar.equals(cuadraActual)){
				cuadraActual.aplicarImprevistos(this.vehiculo, esquinaInicial, esquinaFinal);
				movimientoPermitido = cuadraActual.decidirSiMovimientoEstaPermitido();
			}
		}
		return movimientoPermitido;
	}
	
	public boolean equals(Object otroMapa){
		Mapa mapa = (Mapa)otroMapa;
		return (this.getFilas() == mapa.getFilas() && this.getColumnas() == mapa.getColumnas()
				&& this.getVehiculo().equals(mapa.getVehiculo()) && this.getCuadras().equals(mapa.getCuadras()));
	}
}