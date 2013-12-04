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
		
		this.vistaPrincipal = vistaPrincipal;
		this.controlador = controlador;
		
		this.controlador.persistirJugadorActual();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(UIManager.getColor("Button.focus"));
		panel.setBounds(0, 0, 450, 59);
		add(panel);
		
		JLabel label = new JLabel("");
		label.setBounds(12, 12, 70, 15);
		panel.add(label);
		
		JLabel lblGpschallenge = new JLabel("GPSChallenge\n");
		lblGpschallenge.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		lblGpschallenge.setBounds(147, 12, 169, 35);
		panel.add(lblGpschallenge);
		
		JLabel lblganaste = new JLabel("Ganaste!");
		lblganaste.setFont(new Font("Dialog", Font.BOLD, 20));
		lblganaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblganaste.setForeground(new Color(0, 255, 0));
		lblganaste.setBounds(160, 90, 118, 34);
		add(lblganaste);
		
		JLabel lblTuPuntajeEs = new JLabel("Te sobraron " + controlador.pedirMovimientosSobrantes() + " movimientos.\n");
		lblTuPuntajeEs.setVerticalAlignment(SwingConstants.TOP);
		lblTuPuntajeEs.setBounds(60, 136, 312, 25);
		add(lblTuPuntajeEs);
		
		JLabel lblObtuvisteUnPuntaje = new JLabel("Obtuviste un puntaje de " + controlador.pedirPuntajeActualComoString() + " puntos.");
		lblObtuvisteUnPuntaje.setBounds(60, 173, 345, 15);
		add(lblObtuvisteUnPuntaje);
		
		JButton btnVolver = new JButton("Volver al menu");
		btnVolver.setBounds(257, 230, 139, 25);
		add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaPrincipal.cambiarPanel("pMenuPartida");
			}
		});
		
		JButton btnJugarOtraVez = new JButton("Jugar otra vez");
		btnJugarOtraVez.setBounds(91, 230, 133, 25);
		add(btnJugarOtraVez);
		btnJugarOtraVez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vistaPrincipal.cambiarPanel("pPartidaNueva");
			}
		});

	}
}
