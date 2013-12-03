package ar.fi.uba.GPSChallenge.Vista;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Este;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Norte;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Oeste;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Sur;

public class VistaPrincipal implements Observer, KeyListener{

	private JFrame frmGpsChallenge;
	private Controlador controlador;
	public static  CardLayout card = new CardLayout();
	public static  Container contenedor;
	Bienvenida pBienvenida;
	NuevoUsuario pNuevoUsuario;
	ElegirUsuario pElegirUsuario;
	MenuPartida pMenuPartida;
	Puntajes pPuntajes;
	Escenario pEscenario;
	PartidaNueva pPartidaNueva;
	
	public VistaPrincipal(Juego referenciaAlJuego, Controlador controlador) {
		this.controlador = controlador;
		
		frmGpsChallenge = new JFrame();
		frmGpsChallenge.setTitle("GPS Challenge");
		frmGpsChallenge.setSize(1200, 700);
		frmGpsChallenge.setVisible(true);
		frmGpsChallenge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

		frmGpsChallenge.addKeyListener(this);
		frmGpsChallenge.setFocusable(true);
		
		//Para Abrir la Ventana centrada en la pantalla
		Toolkit toolkit = frmGpsChallenge.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frmGpsChallenge.setLocation(size.width/2 - frmGpsChallenge.getWidth()/2,size.height/2 - frmGpsChallenge.getHeight()/2);
		contenedor = frmGpsChallenge.getContentPane();
		contenedor.setBounds(10, 10, 1200, 700);
		
		pBienvenida = new Bienvenida(this);
		pNuevoUsuario = new NuevoUsuario(this, this.controlador);
		pElegirUsuario = new ElegirUsuario(this, this.controlador);
		pMenuPartida = new MenuPartida(this, this.controlador);
		pPuntajes = new Puntajes(this, this.controlador);
		pPartidaNueva = new PartidaNueva(this, this.controlador);
		
		card.addLayoutComponent(pBienvenida, "pBienvenida");
		card.addLayoutComponent(pNuevoUsuario, "pNuevoUsuario");
		card.addLayoutComponent(pElegirUsuario, "pElegirUsuario");
		card.addLayoutComponent(pMenuPartida, "pMenuPartida");
		card.addLayoutComponent(pPuntajes, "pPuntajes");
		card.addLayoutComponent(pPartidaNueva, "pPartidaNueva");
		
		contenedor.add(pBienvenida);
		contenedor.add(pNuevoUsuario);
		contenedor.add(pElegirUsuario);
		contenedor.add(pMenuPartida);
		contenedor.add(pPuntajes);
		contenedor.add(pPartidaNueva);
		
		contenedor.setLayout(card);
        card.show(contenedor, "pBienvenida");
	}

	public void cambiarPanel(String panelAColocar){
		switch(panelAColocar){
			case("pBienvenida"):
				card.show(contenedor, "pBienvenida");
				break;
			case("pNuevoUsuario"):
				card.show(contenedor, "pNuevoUsuario");
				break;
			case("pElegirUsuario"):
				card.show(contenedor, "pElegirUsuario");
				break;
			case("pMenuPartida"):
				card.show(contenedor, "pMenuPartida");
				break;	
			case("pPuntajes"):
				card.show(contenedor, "pPuntajes");
				break;
			case("pPartidaNueva"):
				card.show(contenedor, "pPartidaNueva");
				break;
			case("pEscenario"):
				pEscenario = new Escenario(this, this.controlador);
				card.addLayoutComponent(pEscenario, "pEscenario");
				contenedor.add(pEscenario);
				card.show(contenedor, "pEscenario");
				break;
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {		
	}
	
		@Override
	public void keyPressed(KeyEvent evento) {
		switch(evento.getKeyCode()){
		case(KeyEvent.VK_UP):
			controlador.moverVehiculo(new Norte());
			pEscenario.update();
			break;
		case(KeyEvent.VK_DOWN):
			controlador.moverVehiculo(new Sur());				
			pEscenario.update();
			break;
		case(KeyEvent.VK_RIGHT):
			controlador.moverVehiculo(new Este());
			pEscenario.update();
			break;
		case(KeyEvent.VK_LEFT):
			controlador.moverVehiculo(new Oeste());	
			pEscenario.update();
			break;
		}
	}
	
		@Override
		public void keyReleased(KeyEvent evento) {
	}

		@Override
		public void keyTyped(KeyEvent evento) {
	}
}
