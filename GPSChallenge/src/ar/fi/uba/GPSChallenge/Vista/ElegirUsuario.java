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
import javax.swing.SwingConstants;
import java.awt.Font;

public class ElegirUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JRadioButton rdbtnNewRadioButton;
	private ButtonGroup botoneraDeUsuarios;

	public ElegirUsuario(final VistaPrincipal vistaPrincipal, final Controlador controlador) {
		setLayout(null);
		setBounds(10, 10, 1180, 680);
		
		JLabel lblElijaSuUsuario = new JLabel("Elija su usuario");
		lblElijaSuUsuario.setFont(new Font("Dialog", Font.BOLD, 20));
		lblElijaSuUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaSuUsuario.setBounds(518, 29, 250, 20);
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
			rdbtnNewRadioButton.setBounds(600, numeroDePosicion, 149, 23);
			botoneraDeUsuarios.add(rdbtnNewRadioButton);
			add(rdbtnNewRadioButton);
		}
		
		JButton btnSeleccionarUsuario = new JButton("Seleccionar Usuario");
		btnSeleccionarUsuario.setBounds(451, 550, 175, 25);
		add(btnSeleccionarUsuario);
		btnSeleccionarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (botoneraDeUsuarios.getSelection() != null){
				String jugadorSeleccionado = getTextDelBtnSeleccionado(botoneraDeUsuarios);
				controlador.elegirUsuarioSeleccionado(jugadorSeleccionado);
				vistaPrincipal.cambiarPanel("pMenuPartida");
				}
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(658, 550, 175, 25);
		add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pBienvenida");
			}
		});
	}
	
	public String getTextDelBtnSeleccionado(ButtonGroup bGroup) {
        for (Enumeration<AbstractButton> todosLosBotones = bGroup.getElements(); todosLosBotones.hasMoreElements();) {
            AbstractButton boton = todosLosBotones.nextElement();
            if (boton.isSelected()) {
                return boton.getText();
            }
        }
        return null;
	}
}