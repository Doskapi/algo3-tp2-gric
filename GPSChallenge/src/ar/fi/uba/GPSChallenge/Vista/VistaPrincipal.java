package ar.fi.uba.GPSChallenge.Vista;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import java.awt.BorderLayout;

public class VistaPrincipal implements Observer{

	private JFrame frmGpsChallenge;
	private Controlador controlador;
	private Juego referenciaAlJuego;
	public static  CardLayout card = new CardLayout();
	public static  Container contenedor;
	Bienvenida pBienvenida;
	NuevoUsuario pNuevoUsuario;
	ElegirUsuario pElegirUsuario;
	MenuPartida pMenuPartida;
	
	public VistaPrincipal(Juego referenciaAlJuego, Controlador controlador) {
		this.referenciaAlJuego = referenciaAlJuego;
		this.controlador = controlador;
		
		frmGpsChallenge = new JFrame();
		frmGpsChallenge.setTitle("GPS Challenge");
		frmGpsChallenge.setSize(1200, 700);
		frmGpsChallenge.setVisible(true);
		frmGpsChallenge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		//Para Abrir la Ventana centrada en la pantalla
		Toolkit toolkit = frmGpsChallenge.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frmGpsChallenge.setLocation(size.width/2 - frmGpsChallenge.getWidth()/2,size.height/2 - frmGpsChallenge.getHeight()/2);
		contenedor = frmGpsChallenge.getContentPane();
		contenedor.setBounds(10, 10, 1200, 700);
		
		pBienvenida = new Bienvenida(this, this.referenciaAlJuego,this.controlador);
		pNuevoUsuario = new NuevoUsuario(this, this.referenciaAlJuego,this.controlador);
		pElegirUsuario = new ElegirUsuario(this, this.referenciaAlJuego,this.controlador);
		pMenuPartida = new MenuPartida(this, this.referenciaAlJuego,this.controlador);
		
		card.addLayoutComponent(pBienvenida, "pBienvenida");
		card.addLayoutComponent(pNuevoUsuario, "pNuevoUsuario");
		card.addLayoutComponent(pElegirUsuario, "pElegirUsuario");
		card.addLayoutComponent(pMenuPartida, "pMenuPartida");
		
		contenedor.add(pBienvenida);
		contenedor.add(pNuevoUsuario);
		contenedor.add(pElegirUsuario);
		contenedor.add(pMenuPartida);
		
		contenedor.setLayout(card);
        card.show(contenedor, "pBienvenida");
	}

	public void cambiarPanel(String panelAColocar){
		if (panelAColocar == "pBienvenida"){
			 card.show(contenedor, "pBienvenida");
		}
		if (panelAColocar == "pNuevoUsuario"){
			card.show(contenedor, "pNuevoUsuario");
		}
		if (panelAColocar == "pElegirUsuario"){
			card.show(contenedor, "pElegirUsuario");
		}
		if (panelAColocar == "pMenuPartida"){
			card.show(contenedor, "pMenuPartida");
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
}
