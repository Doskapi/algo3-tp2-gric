package ar.fi.uba.GPSChallenge.Modelo;

import java.util.Stack;

public class Mapa {
	
	private int filas;
	private int columnas;
	private int porcentajeDeImprevistos = 10;
	Esquina largada;
	Esquina meta;
	Vehiculo vehiculo;
	Stack<Obstaculo> obstaculos;
	Stack<Sorpresa> sorpresas;

	public Mapa(int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
		setLargada();
		setMeta();
		this.obstaculos = new Stack<Obstaculo>();
		this.sorpresas = new Stack<Sorpresa>();
		
	}

	private void setLargada() {
		int columnaLargada = 1;
		int filaLargada = this.filas / 2;
		Esquina esquinaLargada = new Esquina(new Posicion(filaLargada, columnaLargada));
		setEsquinaLargada(esquinaLargada);
	}
	
	private void setMeta() {
		int columnaMeta = this.columnas;
		int filaMeta = (1 + (int)(Math.random() * ((this.filas - 1) + 1)));
		Esquina esquinaMeta = new Esquina(new Posicion(filaMeta, columnaMeta));
		setEsquinaMeta(esquinaMeta);
	}
	
	public void setEsquinaLargada(Esquina esquina){
		this.largada = esquina;
	}
	
	public void setEsquinaMeta(Esquina esquina){
		this.meta = esquina;
	}
	
	public Esquina getEsquinaMeta(){
		return(this.meta);
	}
	
	public Esquina getEsquinaLargada(){
		return(this.largada);
	}

	public int cantidadDeElementos(){
		return((this.filas) * (this.columnas));
	}
	
	public int cantidadFilas(){
		return this.filas;
	}
	
	public int cantidadColumnas(){
		return this.columnas;
	}

	public void agregarVehiculo(Vehiculo vehiculo){
		this.vehiculo = vehiculo;
	}
	
	public Vehiculo devolverVehiculo(){
		return(this.vehiculo);
	}

	public int cantidadDeImprevistos(){
		return ((((this.filas*this.columnas)* this.porcentajeDeImprevistos))/100);
	}

	
	public int cantidadDeImprevistosSorpresaAColocar() {
		return (cantidadDeImprevistos()/2);
	}
	
	public int cantidadDeImprevistosObstaculoAColocar() {
		return (cantidadDeImprevistos()/2);
	}
	
	public void generarObstaculos(int cantidadDeObstaculos){
		int sorteo;
		for (int i = 0; i < cantidadDeObstaculos; i++){
			sorteo = 1 + (int)(Math.random() * 3);
			switch(sorteo) {
			 case 1: 
			     this.obstaculos.add(new ObstaculoPiquete());
			     break;
			 case 2: 
			     this.obstaculos.add(new ObstaculoPolicial());
			     break;
			 case 3: 
			     this.obstaculos.add(new ObstaculoPozos());
			     break;
			}	
		}
	}
	
	public void generarSorpresas(int cantidadDeSorpresas){
		int sorteo;
		for (int i = 0; i < cantidadDeSorpresas; i++){
			sorteo = 1 + (int)(Math.random() * 3);
			switch(sorteo) {
			 case 1: 
			     this.sorpresas.add(new SorpresaCambioDeVehiculo());
			     break;
			 case 2: 
			     this.sorpresas.add(new SorpresaDesfavorable());
			     break;
			 case 3: 
			     this.sorpresas.add(new SorpresaFavorable());
			     break;
			}	
		}
	}
	
	public Stack<Obstaculo> obtenerObstaculos(){
		return(this.obstaculos);
	}
	
	public Stack<Sorpresa> obtenerSorpresas(){
		return(this.sorpresas);
	}

}