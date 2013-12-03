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
		
		this.vistaPrincipal = vistaPrincipal;
		this.controlador = controlador;
		
		setLayout(null);
		
		JLabel lblperdiste = new JLabel("¡Perdiste!");
		lblperdiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblperdiste.setForeground(new Color(255, 0, 0));
		lblperdiste.setFont(new Font("Dialog", Font.BOLD, 20));
		lblperdiste.setBounds(159, 118, 131, 34);
		add(lblperdiste);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(UIManager.getColor("Button.focus"));
		panel.setBounds(0, 0, 450, 59);
		add(panel);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(12, 12, 70, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("GPSChallenge\n");
		label_2.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		label_2.setBounds(147, 12, 169, 35);
		panel.add(label_2);
		
		JButton btnJugarOtraVez = new JButton("Jugar otra vez");
		btnJugarOtraVez.setBounds(67, 207, 139, 25);
		add(btnJugarOtraVez);
		btnJugarOtraVez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vistaPrincipal.cambiarPanel("pPartidaNueva");
			}
		});
		
		JButton btnVolver = new JButton("Volver al menu");
		btnVolver.setBounds(243, 207, 139, 25);
		add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaPrincipal.cambiarPanel("pMenuPartida");
			}
		});
	}
}
