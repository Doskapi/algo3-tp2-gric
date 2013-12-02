package ar.fi.uba.GPSChallenge.Vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;


public class Escenario extends JPanel {
	
	PanelConFondo celdas[][] = new PanelConFondo[28][28];
	Image imagenCiudad = new ImageIcon(getClass().getResource("MapaGrande.png")).getImage();
//	Image imagenAuto = new ImageIcon(getClass().getResource("Auto.png")).getImage();
//	Image imagenCuatroPorCuatro = new ImageIcon(getClass().getResource("CuatroPorCuatroOriginal.png")).getImage();
	Image imagenTransparente = new ImageIcon(getClass().getResource("ImagenTransparente.png")).getImage();
	PanelConFondo grilla;
	JPanel informacion;
	
	private VistaPrincipal vistaPrincipal;
	private Controlador controlador;
	private JLabel lblNewLabel;
	
	public Escenario(VistaPrincipal vistaPrincipal, Controlador controlador) {
		this.vistaPrincipal = vistaPrincipal;
		this.controlador = controlador;
		setLayout(null);
		
		grilla = new PanelConFondo();
		grilla.setBounds(12, 12, 700, 700);
		grilla.setImagen(imagenCiudad);
		
		informacion = new JPanel();
		add(informacion);
		
		JLabel lblHola = new JLabel("HOLA");
		informacion.add(lblHola);
		
		grilla.setLayout(new GridLayout(28, 28, 0, 0));
		add(grilla);
		
		lblNewLabel = new JLabel("GPSChallenge\n      ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
		lblNewLabel.setBounds(730, 12, 202, 25);
		add(lblNewLabel);
		
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
	}
	
	public void update(Observable t, Object o) {
        Posicion posicionVehiculo;
        Image imagenVehiculo;
        String tipoVehiculo;
        List<Posicion> posicionesARecorrer = new ArrayList<Posicion>();
        for (int i = 1; i < 11; i++){
        	for (int j = 1; j< 11; j++){
        		posicionesARecorrer.add(new Posicion(i,j));
            }
        }
        Mapa mapa = controlador.obtenerMapa();
        posicionVehiculo = mapa.getVehiculo().getEsquina().getPosicion();
        tipoVehiculo = mapa.getVehiculo().getNombreEstado();
        imagenVehiculo = new ImageIcon(getClass().getResource(tipoVehiculo + ".png")).getImage();
        setVehiculoEnPosicion(posicionVehiculo, imagenVehiculo);
        }

	private void setVehiculoEnPosicion(Posicion posicionVehiculo, Image imagenVehiculo) {
		int fila = posicionVehiculo.getFila();
		int columna = posicionVehiculo.getColumna();
		celdas[fila][columna].setImagen(imagenVehiculo);
	}  
}
	
