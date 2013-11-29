package ar.fi.uba.GPSChallenge.Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import javax.swing.JTextPane;

public class NuevoUsuario extends JPanel {

	private Juego referenciaAlJuego;
	private Controlador controlador;
	
	public NuevoUsuario(Juego referenciaAlJuego, Controlador controlador){
		setLayout(null);
		setVisible(true);

		this.referenciaAlJuego = referenciaAlJuego;
		this.controlador = controlador;


		JLabel lblPorFavorElija = new JLabel("Por favor elija un nombre");
		lblPorFavorElija.setBounds(67, 35, 465, 61);
		lblPorFavorElija.setFont(new Font("Dialog", Font.BOLD, 26));
		add(lblPorFavorElija);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(124, 199, 137, 25);
		add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			
			}
		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(302, 199, 117, 25);
		add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		JTextPane textNuevoUsuario = new JTextPane();
		textNuevoUsuario.setFont(new Font("Dialog", Font.ITALIC, 12));
		textNuevoUsuario.setText("Su nombre");
		textNuevoUsuario.setBounds(204, 128, 137, 25);
		add(textNuevoUsuario);

	}
}
