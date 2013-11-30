package ar.fi.uba.GPSChallenge.Vista;

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
	private Container contenedor;
	private Bienvenida pBienvenida;
	private NuevoUsuario pNuevoUsuario;
	private ElegirUsuario pElegirUsuario;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego juego = new Juego();
					Controlador controlador = new Controlador();
					VistaPrincipal window = new VistaPrincipal(juego,controlador);
					window.frmGpsChallenge.setVisible(true);
//					window.escucharBotonNuevoUsuario();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

		this.pBienvenida = new Bienvenida(this, this.referenciaAlJuego,this.controlador);
		pBienvenida.setBounds(10, 10, 1180, 680);
		contenedor.add(pBienvenida);
		
		this.pNuevoUsuario = new NuevoUsuario(this, this.referenciaAlJuego,this.controlador);
		pNuevoUsuario.setBounds(10, 10, 1180, 680);
		pNuevoUsuario.setVisible(false);
		contenedor.add(pNuevoUsuario);
		
		this.pElegirUsuario = new ElegirUsuario(this, this.referenciaAlJuego,this.controlador);
		pElegirUsuario.setBounds(10, 10, 1180, 680);
		pElegirUsuario.setVisible(false);
		contenedor.add(pElegirUsuario);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
}
