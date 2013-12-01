package ar.fi.uba.GPSChallenge.Vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import javax.swing.JLabel;
import java.awt.Font;


public class Escenario extends JPanel {
	
	PanelConFondo celdas[][] = new PanelConFondo[30][30];
	Image imagenEsquinas = new ImageIcon(getClass().getResource("Esquinas.jpg")).getImage();
	Image imagenAuto = new ImageIcon(getClass().getResource("Auto.png")).getImage();
	Image imagenTransparente = new ImageIcon(getClass().getResource("ImagenTransparente.png")).getImage();
	PanelConFondo grilla;
	JPanel informacion;
	JPanel titulo;
	
	private VistaPrincipal vistaPrincipal;
	private Controlador controlador;
	private JLabel lblGpschallenge;
	
	public Escenario(VistaPrincipal vistaPrincipal, Controlador controlador) {
		this.vistaPrincipal = vistaPrincipal;
		this.controlador = controlador;
		setLayout(new BorderLayout(0, 0));
		
		grilla = new PanelConFondo();
		grilla.setImagen(imagenEsquinas);
		
		informacion = new JPanel();
		add(informacion, BorderLayout.EAST);
		
		titulo = new JPanel();
		add(titulo, BorderLayout.NORTH);
		
		lblGpschallenge = new JLabel("GPSChallenge ");
		lblGpschallenge.setFont(new Font("Dialog", Font.BOLD, 12));
		titulo.add(lblGpschallenge);
		
		JLabel lblHola = new JLabel("HOLA");
		informacion.add(lblHola);
		grilla.setLayout(new GridLayout(30, 30, 0, 0));
		add(grilla, BorderLayout.CENTER);
		
        for (int i = 0; i < 30; i++) {
        	for (int j = 0; j < 30; j++) {
        		celdas[i][j] = new PanelConFondo();
                grilla.add(celdas[i][j]);
            }
        }         
     
        for (int i = 0; i < 30; i++) {
        	for (int j = 0 ; j < 30; j++) {
        		celdas[i][j].setImagen(imagenTransparente);
            }
        }
        celdas[4][5].setImagen(imagenAuto);
	}
}
	
