package ar.fi.uba.GPSChallenge.Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;

public class MenuPartida extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controlador controlador;
	
	public MenuPartida(final VistaPrincipal vistaPrincipal, Controlador controlador) {
		setLayout(null);
		setBounds(10, 10, 1200, 700);
		
		this.controlador = controlador;
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(UIManager.getColor("Button.focus"));
		panelCabecera.setBounds(10, 10, 1180, 60);
		add(panelCabecera);
		panelCabecera.setLayout(null);
		
		String nombreDelJugador = this.controlador.pedirNombreDelJugadorActual();
		JLabel labelNombreDelUsuario = new JLabel(nombreDelJugador);
		labelNombreDelUsuario.setBounds(12, 12, 92, 35);
		panelCabecera.add(labelNombreDelUsuario);
		
		JLabel labelGpsChallenge = new JLabel("GPS Challenge");
		labelGpsChallenge.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		labelGpsChallenge.setBounds(251, 12, 169, 35);
		panelCabecera.add(labelGpsChallenge);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(572, 19, 78, 25);
		add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		JButton btnPartidaNueva = new JButton("Partida Nueva");
		btnPartidaNueva.setBounds(445, 130, 310, 55);
		add(btnPartidaNueva);
		btnPartidaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pPartidaNueva");
			}
		});
		
		JButton btnContinuarConSuPartida = new JButton("Continuar con su Partida Guardada");
		btnContinuarConSuPartida.setBounds(445, 195, 310, 55);
		add(btnContinuarConSuPartida);
		btnContinuarConSuPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pPartida");
			}
		});
		
		JButton btnVerPuntajes = new JButton("Ver Puntajes");
		btnVerPuntajes.setBounds(445, 260, 310, 55);
		add(btnVerPuntajes);
		btnVerPuntajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pVerPuntajes");
			}
		});
		
		
	}
}
