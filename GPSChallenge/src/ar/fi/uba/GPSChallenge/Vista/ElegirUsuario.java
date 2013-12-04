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
		setBounds(10, 10, 1200, 700);
		
		JLabel lblElijaSuUsuario = new JLabel("Elija su usuario");
		lblElijaSuUsuario.setFont(new Font("Dialog", Font.BOLD, 30));
		lblElijaSuUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaSuUsuario.setBounds(400, 30, 400, 40);
		add(lblElijaSuUsuario);
		
		botoneraDeUsuarios = new ButtonGroup();
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores = controlador.pedirJugadoresExistentes();
		String nombreJugador;
		Iterator<Jugador> iterador = jugadores.iterator();
		int numeroDePosicion = 70;
		while(iterador.hasNext()){
			numeroDePosicion = numeroDePosicion + 35;
			nombreJugador = iterador.next().getNombre();
			rdbtnNewRadioButton = new JRadioButton(nombreJugador);
			rdbtnNewRadioButton.setFont(new Font("Dialog", Font.BOLD, 16));
			rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
			rdbtnNewRadioButton.setBounds(300, numeroDePosicion, 149, 30);
			botoneraDeUsuarios.add(rdbtnNewRadioButton);
			add(rdbtnNewRadioButton);
		}
		
		JButton btnSeleccionarUsuario = new JButton("Seleccionar Usuario");
		btnSeleccionarUsuario.setBounds(350, 530, 200, 70);
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
		btnVolver.setBounds(650, 530, 200, 70);
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