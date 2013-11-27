package ar.fi.uba.GPSChallenge.Modelo;

public abstract class Nivel {

	protected String rutaALaCarpetaMapas = System.getProperty("user.dir") + System.getProperty("file.separator") + "Mapas" + System.getProperty("file.separator");
	
	protected int movimientosLimite;
	
	protected int multiplicadorDePuntaje;
	
	public Mapa pedirUnMapa(){	
		return new Mapa(1,1);
	} 
	
	public Mapa pedirUnMapaParaTest(){
		return new Mapa(1,1);
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
