package ar.fi.uba.GPSChallenge.Main;

import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import ar.fi.uba.GPSChallenge.Persistencia.DespersistidorDeJuego;
import ar.fi.uba.GPSChallenge.Vista.VistaPrincipal;

public class Main{
	
	public static void main(String[] args) {
		String rutaAlJuego = System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml";
		Juego juego;
		Controlador controlador;
		VistaPrincipal vistaPrincipal;
		DespersistidorDeJuego despersistidorJuego = new DespersistidorDeJuego();
		juego = despersistidorJuego.despersistirJuego(rutaAlJuego);
		controlador = new Controlador();
		vistaPrincipal = new VistaPrincipal(juego, controlador);
		}
}
