package ar.fi.uba.GPSChallenge.Main;

import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import ar.fi.uba.GPSChallenge.Persistencia.DespersistidorDeJuego;
import ar.fi.uba.GPSChallenge.Vista.VistaPrincipal;

public class Main{
	
	private static String rutaAlJuego;
	
	public static void main(String[] args) {
		rutaAlJuego = System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml";
		Juego juego;
		Controlador controlador;
		DespersistidorDeJuego despersistidorJuego = new DespersistidorDeJuego();
		juego = despersistidorJuego.despersistirJuego(rutaAlJuego);
		controlador = new Controlador(juego);
		VistaPrincipal vistaPrincipal = new VistaPrincipal(juego, controlador);
		}
}
