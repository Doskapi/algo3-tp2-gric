package ar.fi.uba.GPSChallenge.Modelo;

public abstract class Nivel {

	protected String rutaALaCarpetaMapas = System.getProperty("user.dir") + System.getProperty("file.separator") + "Mapas" + System.getProperty("file.separator");
	
	public Mapa pedirUnMapa(){	
		return new Mapa(1,1);
	} 

}
