package ar.fi.uba.GPSChallenge.Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import javax.swing.SwingConstants;

public class MenuPartida extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controlador controlador;
	
	public MenuPartida(final VistaPrincipal vistaPrincipal, final Controlador controlador) {
		setLayout(null);
		setBounds(10, 10, 1200, 700);
		
		this.controlador = controlador;
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(UIManager.getColor("Button.focus"));
		panelCabecera.setLayout(null);
		panelCabecera.setBounds(10, 10, 1200, 60);
		add(panelCabecera);
		
		String nombreDelJugador = this.controlador.pedirNombreDelJugadorActual();
		
		JLabel labelGpsChallenge = new JLabel("GPS Challenge");
		labelGpsChallenge.setHorizontalAlignment(SwingConstants.CENTER);
		labelGpsChallenge.setFont(new Font("Dialog", Font.BOLD, 30));
		labelGpsChallenge.setBounds(445, 12, 300, 35);
		panelCabecera.add(labelGpsChallenge);
		
		JButton btnPartidaNueva = new JButton("Partida Nueva");
		btnPartidaNueva.setBounds(500, 200, 200, 70);
		add(btnPartidaNueva);
		btnPartidaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pPartidaNueva");
			}
		});
		
		JButton btnContinuarConSuPartida = new JButton("Continuar Partida Guardada");
		btnContinuarConSuPartida.setBounds(500, 300, 200, 70);
		add(btnContinuarConSuPartida);
		btnContinuarConSuPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controlador.continuarPartidaGuardada();
				vistaPrincipal.cambiarPanel("pEscenario");
			}
		});
		
		JButton btnVerPuntajes = new JButton("Ver Puntajes");
		btnVerPuntajes.setBounds(500, 400, 200, 70);
		add(btnVerPuntajes);
		btnVerPuntajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pPuntajes");
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(350, 580, 200, 70);
		add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(650, 580, 200, 70);
		add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pBienvenida");
			}
		});
		
		
	}
}
