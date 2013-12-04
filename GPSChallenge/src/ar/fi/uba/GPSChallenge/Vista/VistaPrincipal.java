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
	Perdiste pPerdiste;
	Ganaste pGanaste;
	
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
		pPartidaNueva = new PartidaNueva(this, this.controlador);

		card.addLayoutComponent(pBienvenida, "pBienvenida");
		card.addLayoutComponent(pNuevoUsuario, "pNuevoUsuario");
		card.addLayoutComponent(pElegirUsuario, "pElegirUsuario");
		card.addLayoutComponent(pMenuPartida, "pMenuPartida");
		card.addLayoutComponent(pPartidaNueva, "pPartidaNueva");
		
		contenedor.add(pBienvenida);
		contenedor.add(pNuevoUsuario);
		contenedor.add(pElegirUsuario);
		contenedor.add(pMenuPartida);
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
				pPuntajes = new Puntajes(this, this.controlador);
				card.addLayoutComponent(pPuntajes, "pPuntajes");
				contenedor.add(pPuntajes);
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
			case("pPerdiste"):
				pPerdiste = new Perdiste(this, this.controlador);
				card.addLayoutComponent(pPerdiste, "pPerdiste");
				contenedor.add(pPerdiste);
				card.show(contenedor, "pPerdiste");
				break;
			case("pGanaste"):
				pGanaste = new Ganaste(this, this.controlador);
				card.addLayoutComponent(pGanaste, "pGanaste");
				contenedor.add(pGanaste);
				card.show(contenedor, "pGanaste");
		}
	}
	
	@Override
	public void keyPressed(KeyEvent evento) {
		switch(evento.getKeyCode()){
		case(KeyEvent.VK_UP):
			try {
				controlador.moverVehiculo(new Norte());
			} catch (Exception e) {
			}
			pEscenario.update();
			break;
		case(KeyEvent.VK_DOWN):
			try {
				controlador.moverVehiculo(new Sur());
			} catch (Exception e) {
			}				
			pEscenario.update();
			break;
		case(KeyEvent.VK_RIGHT):
			try {
				controlador.moverVehiculo(new Este());
			} catch (Exception e) {
			}
			pEscenario.update();
			break;
		case(KeyEvent.VK_LEFT):
			try {
				controlador.moverVehiculo(new Oeste());
			} catch (Exception e) {
			}	
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

		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
		}

}
