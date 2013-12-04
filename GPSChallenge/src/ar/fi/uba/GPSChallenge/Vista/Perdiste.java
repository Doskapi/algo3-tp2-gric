package ar.fi.uba.GPSChallenge.Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;

import ar.fi.uba.GPSChallenge.Controlador.Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Perdiste extends JPanel {

	private VistaPrincipal vistaPrincipal;
	private Controlador controlador;
	
	public Perdiste(final VistaPrincipal vistaPrincipal, Controlador controlador) {
		setLayout(null);
		setBounds(10, 10, 1200, 700);
		
		this.vistaPrincipal = vistaPrincipal;
		this.controlador = controlador;
		
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
		
		JLabel lblperdiste = new JLabel("Perdiste!");
		lblperdiste.setFont(new Font("Dialog", Font.BOLD, 40));
		lblperdiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblperdiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblperdiste.setForeground(new Color(0, 255, 0));
		lblperdiste.setBounds(400, 320, 400, 70);
		add(lblperdiste);
				
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
