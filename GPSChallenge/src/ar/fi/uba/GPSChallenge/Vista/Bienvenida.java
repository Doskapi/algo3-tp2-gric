package ar.fi.uba.GPSChallenge.Vista;

import ar.fi.uba.GPSChallenge.Vista.VistaPrincipal;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bienvenida extends JPanel {

	private static final long serialVersionUID = 1L;

	public Bienvenida(final VistaPrincipal vistaPrincipal) {
		setLayout(null);
		setBounds(10, 10, 1200, 700);
		
		JLabel label = new JLabel("Bienvenido");
		label.setBounds(67, 35, 315, 59);
		label.setFont(new Font("Dialog", Font.BOLD, 50));
		add(label);

		JButton btnUsuarioNuevo = new JButton("Usuario Nuevo");
		btnUsuarioNuevo.setBounds(74, 161, 137, 25);
		add(btnUsuarioNuevo);
		btnUsuarioNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pNuevoUsuario");
			}
		});

		JButton btnYaSoyUsuario = new JButton("Ya Soy Usuario");
		btnYaSoyUsuario.setBounds(242, 161, 140, 25);
		add(btnYaSoyUsuario);
		btnYaSoyUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pElegirUsuario");
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(166, 199, 117, 25);
		add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
	}
}
