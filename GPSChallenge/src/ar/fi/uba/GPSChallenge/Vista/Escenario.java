package ar.fi.uba.GPSChallenge.Vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.Imprevisto;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Cuadra;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;

@SuppressWarnings("serial")
public class Escenario extends JPanel {
	
	PanelConFondo celdas[][] = new PanelConFondo[28][28];
	Image imagenCiudad = new ImageIcon(getClass().getResource("Mapa.png")).getImage();
	Image imagenTransparente = new ImageIcon(getClass().getResource("ImagenTransparente.png")).getImage();
	Image imagenVehiculo;
	Image imagenImprevisto;
	PanelConFondo grilla;
	JPanel informacion;
	
	private VistaPrincipal vistaPrincipal;
	private Controlador controlador;
	private JLabel lblNewLabel;
	
	public Escenario(VistaPrincipal vistaPrincipal, final Controlador controlador) {
		this.vistaPrincipal = vistaPrincipal;
		this.controlador = controlador;
		setLayout(null);
		
		grilla = new PanelConFondo();
		grilla.setBounds(12, 12, 650, 650);
		grilla.setImagen(imagenCiudad);
		//grilla.addKeyListener(this);
		//grilla.setFocusable(true);
		
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
		
		inicializarTablero();
        dibujarVehiculo();
//        dibujarImprevistos();       
	}
	
	public void inicializarTablero(){
		for (int i = 0; i < 28; i++) {
        	for (int j = 0; j < 28; j++) {
        		celdas[i][j] = new PanelConFondo();
                grilla.add(celdas[i][j]);
            }
        }         
        limpiarTablero();
	}
	
	public void limpiarTablero(){
		for (int i = 0; i < 28; i++) {
        	for (int j = 0 ; j < 28; j++) {
        		celdas[i][j].setImagen(imagenTransparente);
            }
        }
	}
	
	private void dibujarVehiculo() {
		Posicion posicionVehiculo;
		String tipoVehiculo;
		Mapa mapa = controlador.obtenerMapa();
		tipoVehiculo = mapa.getVehiculo().getNombreEstado();
		posicionVehiculo = mapa.getVehiculo().getEsquina().getPosicion();
		imagenVehiculo = new ImageIcon(getClass().getResource(tipoVehiculo + ".png")).getImage();
		int fila = posicionVehiculo.getFila()*3;
		int columna = posicionVehiculo.getColumna()*3;
		celdas[fila][columna].setImagen(imagenVehiculo);
	}  

//	
//	private void dibujarImprevistos() {
//		List<Cuadra> cuadrasDelMapa;
//		Mapa mapa = controlador.obtenerMapa();
//		cuadrasDelMapa = mapa.getCuadras();
//		
//		Iterator<Cuadra> iteradorDeCuadras = cuadrasDelMapa.iterator();
//		while(iteradorDeCuadras.hasNext()){
//			Cuadra cuadraActual = iteradorDeCuadras.next();
//			List<Imprevisto> ImptrvistosDeLaCuadraActual;
//			ImptrvistosDeLaCuadraActual = cuadraActual.getImprevistos();
//			
//			Posicion posInicial = cuadraActual.getEsquinaInicial().getPosicion();
//			Posicion posFinal = cuadraActual.getEsquinaFinal().getPosicion();
//			
//			Iterator<Imprevisto> iteradorDeImprevistos = ImptrvistosDeLaCuadraActual.iterator();
//
//			if (posInicial.getFila() == posFinal.getFila()){
//				if(posInicial.getColumna() < posFinal.getColumna()){
//					
//					int posicionAdicionalPorLaVista = 1;
//					while(iteradorDeImprevistos.hasNext()){
//						Imprevisto imprvistoActual = iteradorDeImprevistos.next();
//						String tipoDeImprevisto = imprvistoActual.getTipoDeImprevisto();
//						imagenImprevisto = new ImageIcon(getClass().getResource(tipoDeImprevisto + ".png")).getImage();
//						celdas[posInicial.getFila()][posInicial.getColumna() + posicionAdicionalPorLaVista].setImagen(imagenImprevisto);
//						++posicionAdicionalPorLaVista;
//					}
//					
//				}else{ // si la columna inicial es mayor
//					
//					int posicionAdicionalPorLaVista = 1;
//					while(iteradorDeImprevistos.hasNext()){
//						Imprevisto imprvistoActual = iteradorDeImprevistos.next();
//						String tipoDeImprevisto = imprvistoActual.getTipoDeImprevisto();
//						imagenImprevisto = new ImageIcon(getClass().getResource(tipoDeImprevisto + ".png")).getImage();
//						celdas[posInicial.getFila()][posInicial.getColumna() - posicionAdicionalPorLaVista].setImagen(imagenImprevisto);
//						++posicionAdicionalPorLaVista;
//					}
//				}
//			}else { // si las columnas son iguales
//				if(posInicial.getFila() < posFinal.getFila()){
//					
//					int posicionAdicionalPorLaVista = 1;
//					while(iteradorDeImprevistos.hasNext()){
//						Imprevisto imprvistoActual = iteradorDeImprevistos.next();
//						String tipoDeImprevisto = imprvistoActual.getTipoDeImprevisto();
//						imagenImprevisto = new ImageIcon(getClass().getResource(tipoDeImprevisto + ".png")).getImage();
//						celdas[posInicial.getFila() + posicionAdicionalPorLaVista][posInicial.getColumna()].setImagen(imagenImprevisto);
//						++posicionAdicionalPorLaVista;
//					}
//					
//				}else{ // si la columna inicial es mayor
//					
//					int posicionAdicionalPorLaVista = 1;
//					while(iteradorDeImprevistos.hasNext()){
//						Imprevisto imprvistoActual = iteradorDeImprevistos.next();
//						String tipoDeImprevisto = imprvistoActual.getTipoDeImprevisto();
//						imagenImprevisto = new ImageIcon(getClass().getResource(tipoDeImprevisto + ".png")).getImage();
//						celdas[posInicial.getFila() - posicionAdicionalPorLaVista][posInicial.getColumna()].setImagen(imagenImprevisto);
//						++posicionAdicionalPorLaVista;
//					}
//				}
//			}	
//		}
//	}
	
	public void update() {
	    Posicion posicionVehiculo;
	    Image imagenVehiculo;
	    String tipoVehiculo;
	    limpiarTablero();
	    Mapa mapa = controlador.obtenerMapa();
	    posicionVehiculo = mapa.getVehiculo().getEsquina().getPosicion();
	    tipoVehiculo = mapa.getVehiculo().getNombreEstado();
	    dibujarVehiculo();
	}
}