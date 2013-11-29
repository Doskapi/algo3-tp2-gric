package ar.fi.uba.GPSChallenge.Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class VistaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal window = new VistaPrincipal();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 735, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelConFondo = new PanelConFondo("Estadio40.jpg");
		
		panelConFondo.setBounds(111, 72, 505, 341);
		frame.getContentPane().add(panelConFondo);
		
		JLabel lblRojoPutoSos = new JLabel("ROJO PUTO SOS DE LA B");
		lblRojoPutoSos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRojoPutoSos.setForeground(new Color(0, 0, 255));
		lblRojoPutoSos.setToolTipText("");
		lblRojoPutoSos.setBounds(234, 26, 338, 22);
		frame.getContentPane().add(lblRojoPutoSos);
	}
}
