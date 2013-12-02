package ar.fi.uba.GPSChallenge.Modelo.Mapa;

import ar.fi.uba.GPSChallenge.Persistencia.DespersistidorMapa;

public class Dificil extends Nivel {

	final int MAX_CANTIDAD_MAPAS = 10;
	
	public Dificil(){
		this.movimientosLimite = 30;
		this.multiplicadorDePuntaje = 3;
		this.tipoNivel = "Dificil";
	}
	
	public Mapa pedirUnMapa(){
		DespersistidorMapa despersistidor = new DespersistidorMapa();
		Mapa mapa = despersistidor.despersistirMapa(rutaALaCarpetaMapas + System.getProperty("file.separator") + "Dificil" + Integer.toString(this.pedirNumeroDeMapaAleatorio()) + ".xml");
		return mapa;
	}
	
	//Este método es sólo para testeo
	public Mapa pedirUnMapaParaTest(){
		DespersistidorMapa despersistidor = new DespersistidorMapa();
		Mapa mapa = despersistidor.despersistirMapa(rutaALaCarpetaMapas + System.getProperty("file.separator") + "Dificil1.xml");
		return mapa;
	}
	
	private int pedirNumeroDeMapaAleatorio(){
		int sorteo = ( 1 + (int)(Math.random() * ((MAX_CANTIDAD_MAPAS -1) + 1) ));
		return sorteo;
	}
	
	public int calcularPuntaje(int cantidadDeMovimientos){
		int puntaje;
		puntaje = ((this.movimientosLimite - cantidadDeMovimientos) * multiplicadorDePuntaje);
		if (puntaje <= 0){
			return 0;
		}
		else{
			return puntaje;
		}
	}
}