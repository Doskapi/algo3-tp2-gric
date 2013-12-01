package ar.fi.uba.GPSChallenge.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Jugador;

public class ElegirUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JRadioButton rdbtnNewRadioButton;
	private ButtonGroup botoneraDeUsuarios;

	public ElegirUsuario(final VistaPrincipal vistaPrincipal, final Controlador controlador) {
		setLayout(null);
		setBounds(10, 10, 1180, 680);
		
		JLabel lblElijaSuUsuario = new JLabel("Elija su usuario");
		lblElijaSuUsuario.setBounds(144, 24, 156, 15);
		add(lblElijaSuUsuario);
		
		botoneraDeUsuarios = new ButtonGroup();
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
		
		JButton btnSeleccionarUsuario = new JButton("Seleccionar Usuario");
		btnSeleccionarUsuario.setBounds(39, 230, 175, 25);
		add(btnSeleccionarUsuario);
		btnSeleccionarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String jugadorSeleccionado = getTextDelBtnSeleccionadp(botoneraDeUsuarios);
				controlador.elegirUsuarioSeleccionado(jugadorSeleccionado);
				vistaPrincipal.cambiarPanel("pMenuPartida");
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(244, 230, 175, 25);
		add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pBienvenida");
			}
		});
	}
	
	public String getTextDelBtnSeleccionadp(ButtonGroup bGroup) {
        for (Enumeration<AbstractButton> todosLosBotones = bGroup.getElements(); todosLosBotones.hasMoreElements();) {
            AbstractButton boton = todosLosBotones.nextElement();
            if (boton.isSelected()) {
                return boton.getText();
            }
        }
        return null;
	}
}