package ar.fi.uba.GPSChallenge.Vista;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import java.awt.BorderLayout;

public class VistaPrincipal implements Observer{

	private JFrame frmGpsChallenge;
	private Controlador controlador;
	private Juego referenciaAlJuego;
	private Bienvenida pBienvenida;
	private NuevoUsuario pNuevoUsuario;
	public static CardLayout card = new CardLayout();
	public static Container contenedor;

	public VistaPrincipal(Juego referenciaAlJuego, Controlador controlador) {
		initialize();
		this.referenciaAlJuego = referenciaAlJuego;
		this.controlador = controlador;
	}

	private void initialize() {
		frmGpsChallenge = new JFrame();
		frmGpsChallenge.setTitle("GPS Challenge");
		frmGpsChallenge.setSize(1200, 700);
		frmGpsChallenge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		// Para Abrir la Ventana centrada en la pantalla
		Toolkit toolkit = frmGpsChallenge.getToolkit();
		Dimension size = toolkit.getScreenSize();
		frmGpsChallenge.setLocation(size.width/2 - frmGpsChallenge.getWidth()/2,size.height/2 - frmGpsChallenge.getHeight()/2);
		
		contenedor 	= new Container();
		contenedor.setLayout(new BorderLayout());
		contenedor.setVisible(true);
		frmGpsChallenge.getContentPane().add(contenedor);
		
		
		this.pNuevoUsuario = new NuevoUsuario(this.referenciaAlJuego, this.controlador);
		pNuevoUsuario.setBounds(100, 100, 800, 500);
		contenedor.add(pNuevoUsuario);
		
		
		this.pBienvenida = new Bienvenida(this.referenciaAlJuego, this.controlador, pNuevoUsuario);
		pBienvenida.setBounds(100, 100, 800, 500);
		contenedor.add(pBienvenida);
	}

	
//	public void escucharBotonNuevoUsuario(){
//		
//		NuevoUsuario pNuevoUsuario = new NuevoUsuario(this.referenciaAlJuego, this.controlador);
//		
//		if(!pBienvenida.getVisibilidad()){
//			pBienvenida.setVisible(false);
//			pNuevoUsuario.setVisible(true);
//			pNuevoUsuario.setBounds(0, 0, 500, 300);
//			contenedor.add(pNuevoUsuario);
//		}
//		
//	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
}
