package ar.fi.uba.GPSChallenge.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Juego;
import ar.fi.uba.GPSChallenge.Modelo.Jugador;

public class ElegirUsuario extends JPanel {
	
	private Juego referenciaAlJuego;
	private Controlador controlador;

	public ElegirUsuario(final VistaPrincipal vistaPrincipal, Juego referenciaAlJuego, Controlador controlador) {
		setLayout(null);
		
		JLabel lblElijaSuUsuario = new JLabel("Elija su usuario");
		lblElijaSuUsuario.setBounds(144, 24, 156, 15);
		add(lblElijaSuUsuario);
		
		JRadioButton rdbtnNewRadioButton;
		ButtonGroup botoneraDeUsuarios = new ButtonGroup();
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores = controlador.pedirJugadoresExistentes();
		String nombreJugador;
		Iterator<Jugador> iterador = jugadores.iterator();
		int numeroDePosicion = 70;
		while(iterador.hasNext()){
			numeroDePosicion = numeroDePosicion + 24;
			nombreJugador = iterador.next().getNombre();
			rdbtnNewRadioButton = new JRadioButton(nombreJugador);
			rdbtnNewRadioButton.setBounds(134, numeroDePosicion, 149, 23);
			botoneraDeUsuarios.add(rdbtnNewRadioButton);
			add(rdbtnNewRadioButton);
		}
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(244, 230, 175, 25);
		add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pBienvenida");
			}
		});

		JButton btnSeleccionarUsuario = new JButton("Seleccionar Usuario");
		btnSeleccionarUsuario.setBounds(39, 230, 175, 25);
		add(btnSeleccionarUsuario);
	}
}
