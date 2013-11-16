package ar.fi.uba.GPSChallenge.Modelo;

import java.util.*;

public class Mapa {
	
	private int filas;
	private int columnas;
	private int porcentajeDeImprevistos = 10;
	Esquina largada;
	Esquina meta;
	Vehiculo vehiculo;
	Stack<Obstaculo> obstaculos;
	Stack<Sorpresa> sorpresas;
	List<Cuadra> cuadras;

	public Mapa(int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
		this.setLargada();
		this.setMeta();
		this.obstaculos = new Stack<Obstaculo>();
		this.sorpresas = new Stack<Sorpresa>();
		this.cuadras = new ArrayList<Cuadra>();	
		this.generarObstaculos(this.cantidadDeImprevistosObstaculoAColocar());
		this.generarSorpresas(this.cantidadDeImprevistosSorpresaAColocar());
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
	
	public int getFilas(){
		return this.filas;
	}
	
	public int getColumnas(){
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

	public Posicion getPosicionRandom(int filas, int columnas){
		Posicion posicion = new Posicion();
		posicion.setPosicionRandom(filas, columnas);
		return posicion;
	}
	
	public void generarCuadras() {
		while (this.cuadras.size() < cantidadDeImprevistos()){
			Posicion posicion1 = new Posicion();
			Posicion posicion2 = new Posicion();
			posicion1 = getPosicionRandom(this.filas, this.columnas);
			posicion2 = posicion1.getContiguaRandom();		
			Cuadra cuadra = new Cuadra(new Esquina(posicion1), new Esquina(posicion2));
			
			Iterator<Cuadra> iterador = this.cuadras.iterator();
			boolean encontrada = false;
			Cuadra cuadraActual = new Cuadra();
			while(iterador.hasNext() && !encontrada){
				cuadraActual = iterador.next();
				encontrada = (cuadra.equals(cuadraActual));
			}
			if (!encontrada) {
				if ((this.sorpresas.size() != 0) || (this.obstaculos.size() != 0)){
					this.cuadras.add(cuadra);
				}
			}
		}
	}

	public void generarCuadraMetodoParaTesteo() {
		Esquina esquinaInicial1 = new Esquina(new Posicion(1,2));
		Esquina esquinaFinal1 = new Esquina(new Posicion(2,2));
		Esquina esquinaInicial2 = new Esquina(new Posicion(4,3));
		Esquina esquinaFinal2 = new Esquina(new Posicion(4,4));
		Cuadra cuadra1 = new Cuadra(esquinaInicial1, esquinaFinal1);
		Cuadra cuadra2 = new Cuadra(esquinaInicial2, esquinaFinal2);
		cuadras.add(cuadra1);
		cuadras.add(cuadra2);
	}

	public List<Cuadra> getCuadras() {
		return this.cuadras;
	}

	public List<Imprevisto> seleccionarImprevistos() {
		List<Imprevisto> imprevistosAAsignar = new ArrayList<Imprevisto>();
		
		int aleatorio = 1 + (int)(Math.random() * 3);
		if((this.sorpresas.size() != 0) && (this.obstaculos.size() != 0)){
			switch(aleatorio) {
			 case 1: //Toma uno de los obstáculos
				 imprevistosAAsignar.add(this.obstaculos.pop());
			     break;
			 case 2: //Toma una de las sorpresas
				 imprevistosAAsignar.add(this.sorpresas.pop());
			     break;
			 case 3: //Toma una sorpresa y un obstáculo
				 imprevistosAAsignar = this.devolverImprevistosConUnOrdenAleatorio();
			     break;
			}
		} 		
		if(this.sorpresas.size() == 0){
			 imprevistosAAsignar.add(this.sorpresas.pop());
		}
		if(this.obstaculos.size() == 0){
			 imprevistosAAsignar.add(this.obstaculos.pop());
		}
		return imprevistosAAsignar;
	}

	private List<Imprevisto> devolverImprevistosConUnOrdenAleatorio() {
		int aleatorio = 1 + (int)(Math.random() * 2);
		List<Imprevisto> imprevistosAAsignar = new ArrayList<Imprevisto>();
		switch(aleatorio) {
		 case 1: //Toma primero el obstáculo y luego la sorpresa
			 imprevistosAAsignar.add(this.obstaculos.pop());
			 imprevistosAAsignar.add(this.sorpresas.pop());
		     break;
		 case 2: //Toma primero la sorpresa y luego el obstáculo
			 imprevistosAAsignar.add(this.sorpresas.pop());
			 imprevistosAAsignar.add(this.obstaculos.pop());
		     break;
		}
		return imprevistosAAsignar;
	}
	
	public void moverVehiculo(Rumbo rumbo){
		pasarPorCuadra(rumbo);
		this.vehiculo.mover(rumbo);
	}
	//FALTA VERIFICAR SI EL VEHICULO PASA DERECHO O AL REVES
	public void pasarPorCuadra(Rumbo rumbo){
		Esquina esquinaInicial = this.vehiculo.getEsquina();
		Esquina esquinaFinal = rumbo.moverVehiculo(this.vehiculo.getEsquina());
		Cuadra cuadraAAtravesar = new Cuadra(esquinaInicial, esquinaFinal);
		Iterator<Cuadra> iterador = this.cuadras.iterator();
		while(iterador.hasNext()){
			Cuadra cuadraActual = iterador.next();
			if(cuadraAAtravesar.equals(cuadraActual)){
				cuadraActual.aplicarImprevistos(this.vehiculo, esquinaInicial, esquinaFinal);
			}
		}
	}
}