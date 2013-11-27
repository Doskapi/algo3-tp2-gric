package ar.fi.uba.GPSChallenge.Modelo;

import java.io.File;
import ar.fi.uba.GPSChallenge.Persistencia.DespersistidorMapa;

public class Facil extends Nivel {
	
	final int MAX_CANTIDAD_MAPAS = 3;
	
	public Facil(){
		this.movimientosLimite = 70;
		this.multiplicadorDePuntaje = 1;
	}
	
	public Mapa pedirUnMapa(){
		DespersistidorMapa despersistidor = new DespersistidorMapa();
		Mapa mapa = despersistidor.despersistirMapa(rutaALaCarpetaMapas + System.getProperty("file.separator") + "Facil" + Integer.toString(this.pedirNumeroDeMapaAleatorio()) + ".xml");
		return mapa;
	}
	
	
	//Este método es sólo para testeo
	public Mapa pedirUnMapaParaTest(){
		DespersistidorMapa despersistidor = new DespersistidorMapa();
		Mapa mapa = despersistidor.despersistirMapa(rutaALaCarpetaMapas + System.getProperty("file.separator") + "Facil1.xml");
		return mapa;
	}
	
	private int pedirNumeroDeMapaAleatorio(){
		int sorteo = ( 1 + (int)(Math.random() * ((MAX_CANTIDAD_MAPAS -1) + 1) ));
		return sorteo;
	}
}
