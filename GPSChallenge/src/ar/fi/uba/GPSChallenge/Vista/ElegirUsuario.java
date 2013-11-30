package ar.fi.uba.GPSChallenge.Vista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ElegirUsuario extends JPanel {

	public ElegirUsuario() {
		setLayout(null);
		
		JButton btnSeleccionarUsuario = new JButton("Seleccionar Usuario");
		btnSeleccionarUsuario.setBounds(144, 212, 175, 25);
		add(btnSeleccionarUsuario);
		
		JLabel lblElijaSuUsuario = new JLabel("Elija su usuario");
		lblElijaSuUsuario.setBounds(144, 24, 156, 15);
		add(lblElijaSuUsuario);
		
		ButtonGroup botoneraDeUsuarios = new ButtonGroup();
				
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(134, 70, 149, 23);
		botoneraDeUsuarios.add(rdbtnNewRadioButton);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(134, 108, 149, 23);
		botoneraDeUsuarios.add(rdbtnNewRadioButton_1);
		add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(134, 149, 149, 23);
		botoneraDeUsuarios.add(rdbtnNewRadioButton_2);
		add(rdbtnNewRadioButton_2);

	}
}
