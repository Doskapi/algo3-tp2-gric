package ar.fi.uba.GPSChallenge.Vista;

import ar.fi.uba.GPSChallenge.Vista.VistaPrincipal;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bienvenida extends JPanel {

	private static final long serialVersionUID = 1L;

	public Bienvenida(final VistaPrincipal vistaPrincipal) {
		setLayout(null);
		setBounds(10, 10, 1200, 700);
		
		PanelConFondo pLogo = new PanelConFondo();
		Image imagenLogo = new ImageIcon(getClass().getResource("gpschallenge.gif")).getImage();
		pLogo.setImagen(imagenLogo);
		pLogo.setBounds(270, 15, 655, 455);
//		add(pLogo);
		
		JButton btnUsuarioNuevo = new JButton("Usuario Nuevo");
		btnUsuarioNuevo.setBounds(350, 490, 200, 70);
//		add(btnUsuarioNuevo);
		btnUsuarioNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pNuevoUsuario");
			}
		});

		JButton btnYaSoyUsuario = new JButton("Ya Soy Usuario");
		btnYaSoyUsuario.setBounds(650, 490, 200, 70);
//		add(btnYaSoyUsuario);
		btnYaSoyUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pElegirUsuario");
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(500, 580, 200, 70);
//		add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		add(btnUsuarioNuevo);
		add(btnYaSoyUsuario);
		add(btnSalir);
		add(pLogo);
	}
}
