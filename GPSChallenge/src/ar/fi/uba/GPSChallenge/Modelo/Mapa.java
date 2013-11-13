package ar.fi.uba.GPSChallenge.Modelo;

public class Mapa {
	
	private int filas;
	private int columnas;
	Esquina largada;
	Esquina meta;
	Vehiculo vehiculo;

	public Mapa(int filas, int columnas){
		this.filas = filas;
		this.columnas = columnas;
		setLargada();
		setMetaEnFormaAleatoria();
	}

	private void setLargada() {
		int columnaLargada = 1;
		int filaLargada = this.filas / 2;
		Esquina esquinaLargada = new Esquina(new Posicion(filaLargada, columnaLargada));
		setEsquinaLargada(esquinaLargada);
	}
	
	private void setMetaEnFormaAleatoria() {
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

	public int dimensiones(){
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
	
}