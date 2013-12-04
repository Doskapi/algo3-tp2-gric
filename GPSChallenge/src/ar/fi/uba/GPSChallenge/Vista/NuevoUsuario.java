package ar.fi.uba.GPSChallenge.Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import ar.fi.uba.GPSChallenge.Controlador.Controlador;

public class NuevoUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane textNuevoUsuario;
	
	public NuevoUsuario(final VistaPrincipal vistaPrincipal, final Controlador controlador){
		setLayout(null);
		setBounds(10, 10, 1200, 700);
	
		JLabel lblPorFavorElija = new JLabel("Por favor, elija un nombre");
		lblPorFavorElija.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorFavorElija.setBounds(300, 30, 600, 40);
		lblPorFavorElija.setFont(new Font("Dialog", Font.PLAIN, 30));
		add(lblPorFavorElija);

		textNuevoUsuario = new JTextPane();
		textNuevoUsuario.setFont(new Font("Dialog", Font.PLAIN, 20));
		textNuevoUsuario.setBounds(400, 200, 400, 30);
		textNuevoUsuario.setBorder(BorderFactory.createLineBorder(Color.black));
		add(textNuevoUsuario);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(350, 530, 200, 70);
		add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String usuarioNuevo;
				usuarioNuevo = textNuevoUsuario.getText();
				controlador.crearNuevoJugadorYAsignarloComoActual(usuarioNuevo);
				vistaPrincipal.cambiarPanel("pMenuPartida");
			}
		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(650, 530, 200, 70);
		add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pBienvenida");
			}
		});


	}
}
