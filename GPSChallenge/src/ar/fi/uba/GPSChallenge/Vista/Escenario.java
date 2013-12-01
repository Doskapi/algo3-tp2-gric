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
	
	PanelConFondo celdas[][] = new PanelConFondo[28][28];
	Image imagenCiudad = new ImageIcon(getClass().getResource("MapaGrande.png")).getImage();
	Image imagenAuto = new ImageIcon(getClass().getResource("Auto.png")).getImage();
	Image imagenCuatroPorCuatro = new ImageIcon(getClass().getResource("CuatroPorCuatroOriginal.png")).getImage();
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
		setLayout(null);
		
		grilla = new PanelConFondo();
		grilla.setBounds(10, 10, 700, 700);
		grilla.setImagen(imagenCiudad);
		
		informacion = new JPanel();
		add(informacion);
		
		titulo = new JPanel();
		add(titulo);
		
		lblGpschallenge = new JLabel("GPSChallenge ");
		lblGpschallenge.setFont(new Font("Dialog", Font.BOLD, 12));
		titulo.add(lblGpschallenge);
		
		JLabel lblHola = new JLabel("HOLA");
		informacion.add(lblHola);
		
		grilla.setLayout(new GridLayout(28, 28, 0, 0));
		add(grilla);
		
        for (int i = 0; i < 28; i++) {
        	for (int j = 0; j < 28; j++) {
        		celdas[i][j] = new PanelConFondo();
                grilla.add(celdas[i][j]);
            }
        }         
     
        for (int i = 0; i < 28; i++) {
        	for (int j = 0 ; j < 28; j++) {
        		celdas[i][j].setImagen(imagenTransparente);
            }
        }
        celdas[0][3].setImagen(imagenAuto);
     
	}
}
	
