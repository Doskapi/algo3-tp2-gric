package ar.fi.uba.GPSChallenge.Modelo.Mapa;

import ar.fi.uba.GPSChallenge.Persistencia.DespersistidorMapa;

public class Facil extends Nivel {
	
	final int MAX_CANTIDAD_MAPAS = 10;
	
	public Facil(){
		this.movimientosLimite = 70;
		this.multiplicadorDePuntaje = 1;
		this.tipoNivel = "Facil";
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
		int sorteo = ((int)(Math.random() * MAX_CANTIDAD_MAPAS + 1));
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
