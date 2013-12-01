package ar.fi.uba.GPSChallenge.Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Jugador;
import javax.swing.JTextArea;

public class Puntajes extends JPanel {

	private static final long serialVersionUID = 1L;

	public Puntajes(final VistaPrincipal vistaPrincipal, Controlador controlador) {
		setLayout(null);
		setBounds(10, 10, 1200, 700);
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(UIManager.getColor("Button.focus"));
		panelCabecera.setBounds(10, 10, 1180, 60);
		add(panelCabecera);
		panelCabecera.setLayout(null);
		
		JLabel labelPuntaje = new JLabel("Puntaje");
		labelPuntaje.setBounds(12, 12, 92, 35);
		panelCabecera.add(labelPuntaje);
		
		JLabel labelGpsChallenge = new JLabel("GPS Challenge");
		labelGpsChallenge.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		labelGpsChallenge.setBounds(251, 12, 169, 35);
		panelCabecera.add(labelGpsChallenge);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(933, 17, 78, 25);
		panelCabecera.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				vistaPrincipal.cambiarPanel("pMenuPartida");
			}
		});	
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("Button.background"));
		textArea.setBounds(293, 168, 585, 391);
		add(textArea);
		List<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores = controlador.pedirJugadoresExistentes();
		Iterator<Jugador> iterador = jugadores.iterator();
		Jugador jugadorAMostrar;
		String puntajesAMostrar = "";
		while(iterador.hasNext()){
			jugadorAMostrar = iterador.next();
			puntajesAMostrar = puntajesAMostrar + jugadorAMostrar.getNombre() + ".................." + jugadorAMostrar.getPuntaje() + "\n";
		}		
		textArea.setText(puntajesAMostrar);
		
	}
}
