package ar.fi.uba.GPSChallenge.Vista;

import java.awt.Container;
import java.awt.EventQueue;
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
	private Container contenedor;
	private Bienvenida pBienvenida;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego juego = new Juego();
					Controlador controlador = new Controlador();
					VistaPrincipal window = new VistaPrincipal(juego,controlador);
					window.frmGpsChallenge.setVisible(true);
					window.escucharBotonNuevoUsuario();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaPrincipal(Juego referenciaAlJuego, Controlador controlador) {
		initialize();
		this.referenciaAlJuego = referenciaAlJuego;
		this.controlador = controlador;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGpsChallenge = new JFrame();
		frmGpsChallenge.setTitle("GPS Challenge");
		frmGpsChallenge.setBounds(100, 100, 800, 500);
		frmGpsChallenge.getContentPane().setLayout(new BorderLayout(0, 0));
		frmGpsChallenge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		contenedor 	= new Container();
		contenedor.setLayout(new BorderLayout());
		contenedor.setVisible(true);
		frmGpsChallenge.getContentPane().add(contenedor);
		this.pBienvenida = new Bienvenida(this.referenciaAlJuego, this.controlador);
		pBienvenida.setBounds(0, 0, 0, 0);
		contenedor.add(pBienvenida);
	}

	public void escucharBotonNuevoUsuario(){
		
		NuevoUsuario pNuevoUsuario = new NuevoUsuario(this.referenciaAlJuego, this.controlador);
		
		if(!pBienvenida.getVisibilidad()){
			System.out.println("aaaa");
			pNuevoUsuario.setBounds(0, 0, 0, 0);
			contenedor.add(pNuevoUsuario);
		}
		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
}
