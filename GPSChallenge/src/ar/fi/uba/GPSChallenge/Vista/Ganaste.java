package ar.fi.uba.GPSChallenge.Vista;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ganaste extends JPanel {

	private VistaPrincipal vistaPrincipal;
	private Controlador controlador;

	public Ganaste(final VistaPrincipal vistaPrincipal, final Controlador controlador) {
		setLayout(null);
		setBounds(10, 10, 1200, 700);
		
		this.vistaPrincipal = vistaPrincipal;
		this.controlador = controlador;
		
		this.controlador.persistirJugadorActual();
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.focus"));
		panel.setLayout(null);
		panel.setBounds(10, 10, 1200, 60);
		add(panel);
		
		JLabel lblGpschallenge = new JLabel("GPS Challenge");
		lblGpschallenge.setHorizontalAlignment(SwingConstants.CENTER);
		lblGpschallenge.setFont(new Font("Dialog", Font.BOLD, 30));
		lblGpschallenge.setBounds(445, 12, 300, 35);;
		panel.add(lblGpschallenge);
		
		JLabel lblganaste = new JLabel("Ganaste!");
		lblganaste.setFont(new Font("Dialog", Font.BOLD, 40));
		lblganaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblganaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblganaste.setForeground(new Color(0, 255, 0));
		lblganaste.setBounds(400, 120, 400, 70);
		add(lblganaste);
		
		JLabel lblTuPuntajeEs = new JLabel("Te sobraron " + controlador.pedirMovimientosSobrantes() + " movimientos.");
		lblTuPuntajeEs.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTuPuntajeEs.setVerticalAlignment(SwingConstants.CENTER);
		lblTuPuntajeEs.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuPuntajeEs.setBounds(400, 220, 400, 70);
		add(lblTuPuntajeEs);
		
		JLabel lblObtuvisteUnPuntaje = new JLabel("Obtuviste un puntaje de " + controlador.pedirPuntajeActualComoString() + " puntos.");
		lblObtuvisteUnPuntaje.setFont(new Font("Dialog", Font.BOLD, 20));
		lblObtuvisteUnPuntaje.setVerticalAlignment(SwingConstants.CENTER);
		lblObtuvisteUnPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblObtuvisteUnPuntaje.setBounds(300, 400, 600, 70);;
		add(lblObtuvisteUnPuntaje);
		
		JButton btnJugarOtraVez = new JButton("Jugar otra vez");
		btnJugarOtraVez.setBounds(350, 530, 200, 70);
		add(btnJugarOtraVez);
		btnJugarOtraVez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vistaPrincipal.cambiarPanel("pPartidaNueva");
			}
		});
		
		JButton btnVolver = new JButton("Volver al menu");
		btnVolver.setBounds(650, 530, 200, 70);
		add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaPrincipal.cambiarPanel("pMenuPartida");
			}
		});

	}
}
