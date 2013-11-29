package ar.fi.uba.GPSChallenge.Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;

public class VistaPrincipal {

	private JFrame frmGpsChallenge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal window = new VistaPrincipal();
					window.frmGpsChallenge.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGpsChallenge = new JFrame();
		frmGpsChallenge.setTitle("GPS Challenge");
		frmGpsChallenge.setBounds(100, 100, 800, 500);
		frmGpsChallenge.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGpsChallenge.getContentPane().setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(232, 12, 324, 59);
		lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 50));
		frmGpsChallenge.getContentPane().add(lblBienvenido);
		
		JButton btnUsuarioNuevo = new JButton("Usuario Nuevo");
		btnUsuarioNuevo.setBounds(165, 214, 151, 64);
		frmGpsChallenge.getContentPane().add(btnUsuarioNuevo);
		
		JButton btnYaSoyUsuario = new JButton("Ya Soy Usuario");
		btnYaSoyUsuario.setBounds(418, 214, 151, 64);
		frmGpsChallenge.getContentPane().add(btnYaSoyUsuario);
	}
}
