package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import ar.fi.uba.GPSChallenge.Persistencia.DespersistidorDeJuego;
import junit.framework.TestCase;

public class ControladorTests extends TestCase {
	
	@Test
	public void testElControladorEligeElJugadorActual(){
		Juego juego;
		DespersistidorDeJuego despersistidorJuego = new DespersistidorDeJuego();
		juego = despersistidorJuego.despersistirJuego(System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml");
		Controlador controlador = new Controlador(juego);
		controlador.elegirUsuarioSeleccionado("PedroTest");
		assertEquals(juego.getJugador().getNombre(), "PedroTest");
	}
}
