package ar.fi.uba.GPSChallenge.Modelo;

import ar.fi.uba.GPSChallenge.Persistencia.DespersistidorMapa;

public class Moderado extends Nivel {

	
	final int MAX_CANTIDAD_MAPAS = 3;
	
	public Moderado(){
		this.movimientosLimite = 50;
		this.multiplicadorDePuntaje = 2;
	}
	
	public Mapa pedirUnMapa(){
		DespersistidorMapa despersistidor = new DespersistidorMapa();
		Mapa mapa = despersistidor.despersistirMapa(rutaALaCarpetaMapas + System.getProperty("file.separator") + "Moderado" + Integer.toString(this.pedirNumeroDeMapaAleatorio()) + ".xml");
		return mapa;
	}
	
	//Este método es sólo para testeo
	public Mapa pedirUnMapaParaTest(){
		DespersistidorMapa despersistidor = new DespersistidorMapa();
		Mapa mapa = despersistidor.despersistirMapa(rutaALaCarpetaMapas + System.getProperty("file.separator") + "Moderado1.xml");
		return mapa;
	}
	
	private int pedirNumeroDeMapaAleatorio(){
		int sorteo = ( 1 + (int)(Math.random() * ((MAX_CANTIDAD_MAPAS -1) + 1) ));
		return sorteo;
	}
}
