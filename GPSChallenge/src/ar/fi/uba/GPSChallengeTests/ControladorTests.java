package ar.fi.uba.GPSChallengeTests;

import org.junit.Test;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Dificil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Facil;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Moderado;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Auto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.CuatroPorCuatro;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Moto;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Vehiculo;
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
	
	@Test
	public void testElControladorEligeElNivelDeDificultadFacil(){
		Juego juego;
		DespersistidorDeJuego despersistidorJuego = new DespersistidorDeJuego();
		juego = despersistidorJuego.despersistirJuego(System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml");
		Controlador controlador = new Controlador(juego);
		controlador.elegirUsuarioSeleccionado("PedroTest");
		controlador.elegirDificultadSeleccionada("Facil");
		assertEquals(juego.getJugador().getPartida().getDificultad(), new Facil());
	}
	
	@Test
	public void testElControladorEligeElNivelDeDificultadModerado(){
		Juego juego;
		DespersistidorDeJuego despersistidorJuego = new DespersistidorDeJuego();
		juego = despersistidorJuego.despersistirJuego(System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml");
		Controlador controlador = new Controlador(juego);
		controlador.elegirUsuarioSeleccionado("PedroTest");
		controlador.elegirDificultadSeleccionada("Moderado");
		assertEquals(juego.getJugador().getPartida().getDificultad(), new Moderado());
	}
	
	@Test
	public void testElControladorEligeElNivelDeDificultadDificil(){
		Juego juego;
		DespersistidorDeJuego despersistidorJuego = new DespersistidorDeJuego();
		juego = despersistidorJuego.despersistirJuego(System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml");
		Controlador controlador = new Controlador(juego);
		controlador.elegirUsuarioSeleccionado("PedroTest");
		controlador.elegirDificultadSeleccionada("Dificil");
		assertEquals(juego.getJugador().getPartida().getDificultad(), new Dificil());
	}
	
	@Test
	public void testElControladorEligeElNivelDeDificultadYSeSeteaUnMapaEnLaPartida(){
		Juego juego;
		DespersistidorDeJuego despersistidorJuego = new DespersistidorDeJuego();
		juego = despersistidorJuego.despersistirJuego(System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml");
		Controlador controlador = new Controlador(juego);
		controlador.elegirUsuarioSeleccionado("PedroTest");
		controlador.elegirDificultadSeleccionada("Dificil");
		assertNotNull(juego.getJugador().getPartida().getMapa());
	}
	
	@Test
	public void testElControladorEligeUnVehiculoAuto(){
		Juego juego;
		DespersistidorDeJuego despersistidorJuego = new DespersistidorDeJuego();
		juego = despersistidorJuego.despersistirJuego(System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml");
		Controlador controlador = new Controlador(juego);
		controlador.elegirUsuarioSeleccionado("PedroTest");
		controlador.elegirDificultadSeleccionada("Dificil");
		controlador.elegirVehiculoSeleccionado("Auto");
		assertEquals(juego.getJugador().getPartida().getMapa().getVehiculo(), new Vehiculo(new Auto()));
	}
	
	@Test
	public void testElControladorEligeUnVehiculoCuatroPorCuatro(){
		Juego juego;
		DespersistidorDeJuego despersistidorJuego = new DespersistidorDeJuego();
		juego = despersistidorJuego.despersistirJuego(System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml");
		Controlador controlador = new Controlador(juego);
		controlador.elegirUsuarioSeleccionado("PedroTest");
		controlador.elegirDificultadSeleccionada("Dificil");
		controlador.elegirVehiculoSeleccionado("4X4");
		assertEquals(juego.getJugador().getPartida().getMapa().getVehiculo(), new Vehiculo(new CuatroPorCuatro()));
	}
	
	@Test
	public void testElControladorEligeUnVehiculoMoto(){
		Juego juego;
		DespersistidorDeJuego despersistidorJuego = new DespersistidorDeJuego();
		juego = despersistidorJuego.despersistirJuego(System.getProperty("user.dir") + System.getProperty("file.separator") + "Juego.xml");
		Controlador controlador = new Controlador(juego);
		controlador.elegirUsuarioSeleccionado("PedroTest");
		controlador.elegirDificultadSeleccionada("Dificil");
		controlador.elegirVehiculoSeleccionado("Moto");
		assertEquals(juego.getJugador().getPartida().getMapa().getVehiculo(), new Vehiculo(new Moto()));
	}
}
