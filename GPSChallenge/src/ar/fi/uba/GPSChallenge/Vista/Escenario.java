package ar.fi.uba.GPSChallenge.Vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import ar.fi.uba.GPSChallenge.Controlador.Controlador;
import ar.fi.uba.GPSChallenge.Modelo.Imprevistos.Imprevisto;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Cuadra;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Mapa;
import ar.fi.uba.GPSChallenge.Modelo.Mapa.Posicion;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Este;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Norte;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Oeste;
import ar.fi.uba.GPSChallenge.Modelo.Vehiculo.Sur;

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
	JLabel nombreJugador;
	JLabel lblSuPuntajeEs;
	JLabel lblPuntaje;
	JLabel lblMovimientosLimite;
	JLabel lblMovimientosRealizados;
	JLabel lblCantMovRealizados;
	
	public Escenario(final VistaPrincipal vistaPrincipal, final Controlador controlador) {
		this.vistaPrincipal = vistaPrincipal;
		this.controlador = controlador;
		setLayout(null);
		
		grilla = new PanelConFondo();
		grilla.setBounds(12, 12, 650, 650);
		grilla.setImagen(imagenCiudad);
		
		informacion = new JPanel();
		add(informacion);
		
		grilla.setLayout(new GridLayout(28, 28, 0, 0));
		add(grilla);
		
		lblNewLabel = new JLabel("GPSChallenge\n");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
		lblNewLabel.setBounds(730, 12, 202, 25);
		add(lblNewLabel);
		
		nombreJugador = new JLabel("Jugador: " + this.controlador.pedirNombreDelJugadorActual());
		nombreJugador.setFont(new Font("Dialog", Font.BOLD, 18));
		nombreJugador.setBackground(UIManager.getColor("Button.focus"));
		nombreJugador.setBounds(700, 50, 450, 25);
		add(nombreJugador);
		
		lblSuPuntajeEs = new JLabel("Su Puntaje es: ");
		lblSuPuntajeEs.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSuPuntajeEs.setBackground(UIManager.getColor("Button.focus"));
		lblSuPuntajeEs.setBounds(700, 80, 152, 25);
		add(lblSuPuntajeEs);

		lblPuntaje = new JLabel(this.controlador.pedirPuntajeActualComoString());
		lblPuntaje.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPuntaje.setBounds(867, 83, 70, 15);
		add(lblPuntaje);
		
		lblMovimientosLimite = new JLabel("Movimientos limite: " + this.controlador.pedirMovimientosLimitesDelNivel());
		lblMovimientosLimite.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMovimientosLimite.setBounds(700, 110, 450, 25);
		add(lblMovimientosLimite);
		
		lblMovimientosRealizados = new JLabel("Movimientos realizados: ");
		lblMovimientosRealizados.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMovimientosRealizados.setBounds(700, 140, 251, 25);
		add(lblMovimientosRealizados);
		
		lblCantMovRealizados = new JLabel(this.controlador.pedirMovimientosRealizados());
		lblCantMovRealizados.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCantMovRealizados.setBounds(963, 146, 70, 15);
		add(lblCantMovRealizados);
		
		JButton btnUp = new JButton("UP");
		btnUp.setBounds(800, 301, 117, 25);
		add(btnUp);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controlador.moverVehiculo(new Norte());
					update();
				} catch (Exception e) {
				}
			}
		});
		
		
		JButton btnDown = new JButton("Down");
		btnDown.setBounds(800, 380, 117, 25);
		add(btnDown);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.moverVehiculo(new Sur());
					update();
				} catch (Exception e1) {
				}
			}
		});
		
		JButton btnLeft = new JButton("Left");
		btnLeft.setBounds(730, 338, 117, 25);
		add(btnLeft);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.moverVehiculo(new Oeste());
					update();
				} catch (Exception e1) {
				}
			}
		});
		
		
		JButton btnRight = new JButton("Right");
		btnRight.setBounds(867, 338, 117, 25);
		add(btnRight);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.moverVehiculo(new Este());
					update();

				} catch (Exception e1) {
				}
			}
		});	
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(800, 565, 117, 25);
		add(botonGuardar);
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				controlador.persistirJuegoActual();
				vistaPrincipal.cambiarPanel("pMenuPartida");
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(800, 600, 117, 25);
		add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		escribirDatosDelJugador();
		inicializarTablero();
		dibujarVehiculo();
        mostrarMeta();
        mostrarLargada();
        dibujarImprevistos();
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

	public void mostrarLargada(){
		Posicion posLargada = this.controlador.obtenerMapa().getEsquinaLargada().getPosicion();
		if ((this.controlador.obtenerMapa().getVehiculo().getCantidadDeMovimientos() < 1)){
			switch(this.controlador.obtenerMapa().getVehiculo().getNombreEstado()){
				case "Auto":
					celdas[(posLargada.getFila()-1)*3][(posLargada.getColumna()-1)*3].setImagen("LargadaAuto.png");
					break;
				case "CuatroPorCuatro":
					celdas[(posLargada.getFila()-1)*3][(posLargada.getColumna()-1)*3].setImagen("LargadaCuatroPorCuatro.png");
					break;
				case "Moto":
					celdas[(posLargada.getFila()-1)*3][(posLargada.getColumna()-1)*3].setImagen("LargadaMoto.png");
					break;	
			}
		}else{
			celdas[(posLargada.getFila()-1)*3][(posLargada.getColumna()-1)*3].setImagen("Largada.png");
		}
	}
	
	public void mostrarMeta(){
		Posicion posMeta = this.controlador.obtenerMapa().getEsquinaMeta().getPosicion();
		
		if (this.controlador.obtenerMapa().getVehiculo().getEsquina().getPosicion().equals(posMeta)){
			switch(this.controlador.obtenerMapa().getVehiculo().getNombreEstado()){
				case "Auto":
					celdas[(posMeta.getFila()-1)*3][(posMeta.getColumna()-1)*3].setImagen("MetaAuto.png");
					break;
				case "CuatroPorCuatro":
					celdas[(posMeta.getFila()-1)*3][(posMeta.getColumna()-1)*3].setImagen("MetaCuatroPorCuatro.png");
					break;
				case "Moto":
					celdas[(posMeta.getFila()-1)*3][(posMeta.getColumna()-1)*3].setImagen("MetaMoto.png");
					break;	
			}
		}else{
			celdas[(posMeta.getFila()-1)*3][(posMeta.getColumna()-1)*3].setImagen("Meta.png");
		}
	}
	
	public void escribirDatosDelJugador(){
		lblPuntaje.setText(this.controlador.pedirPuntajeActualComoString());
		lblCantMovRealizados.setText(this.controlador.pedirMovimientosRealizados());
	}
	
	private void dibujarVehiculo() {
		Posicion posicionVehiculo;
		String tipoVehiculo;
		Mapa mapa = controlador.obtenerMapa();
		tipoVehiculo = mapa.getVehiculo().getNombreEstado();
		posicionVehiculo = mapa.getVehiculo().getEsquina().getPosicion();
		imagenVehiculo = new ImageIcon(getClass().getResource(tipoVehiculo + ".png")).getImage();
		int fila = (posicionVehiculo.getFila()-1)*3;
		int columna = (posicionVehiculo.getColumna()-1)*3;
		celdas[fila][columna].setImagen(imagenVehiculo);
	}  
	
	private void dibujarImprevistos() {
		List<Cuadra> cuadrasDelMapa;
		Mapa mapa = controlador.obtenerMapa();
		cuadrasDelMapa = mapa.getCuadras();
		
		System.out.println("cant de cuadras:" + cuadrasDelMapa.size());
		
		Iterator<Cuadra> iteradorDeCuadras = cuadrasDelMapa.iterator();
		
		while(iteradorDeCuadras.hasNext()){
			Cuadra cuadraActual = iteradorDeCuadras.next();
			List<Imprevisto> ImprevistosDeLaCuadraActual;
			ImprevistosDeLaCuadraActual = cuadraActual.getImprevistos();
			
			Posicion posInicial = cuadraActual.getEsquinaInicial().getPosicion();
			Posicion posFinal = cuadraActual.getEsquinaFinal().getPosicion();
			
			System.out.println("cantidad de imprevistos en la cuadra es " + ImprevistosDeLaCuadraActual.size());

			Iterator<Imprevisto> iteradorDeImprevistos = ImprevistosDeLaCuadraActual.iterator();

			if (posInicial.getFila() == posFinal.getFila()){
				if(posInicial.getColumna() < posFinal.getColumna()){
					
					int posicionAdicionalPorLaVista = 1;
					while(iteradorDeImprevistos.hasNext()){
						Imprevisto imprevistoActual	 = iteradorDeImprevistos.next();
						if(!imprevistoActual.getUsada()){
							String tipoDeImprevisto = imprevistoActual	.getTipoDeImprevisto();
							imagenImprevisto = new ImageIcon(getClass().getResource(tipoDeImprevisto + ".png")).getImage();
							celdas[(posInicial.getFila()-1)*3][(posInicial.getColumna()-1)*3 + posicionAdicionalPorLaVista].setImagen(imagenImprevisto);
							++posicionAdicionalPorLaVista;
						}
					}
					
				}else{ // si la columna inicial es mayor
					
					int posicionAdicionalPorLaVista = 1;
					while(iteradorDeImprevistos.hasNext()){
						Imprevisto imprevistoActual	 = iteradorDeImprevistos.next();
						if(!imprevistoActual.getUsada()){
							String tipoDeImprevisto = imprevistoActual	.getTipoDeImprevisto();
							imagenImprevisto = new ImageIcon(getClass().getResource(tipoDeImprevisto + ".png")).getImage();
							celdas[posInicial.getFila()*3][posInicial.getColumna()*3 - posicionAdicionalPorLaVista].setImagen(imagenImprevisto);
							++posicionAdicionalPorLaVista;
						}
					}
				}
				
			}else { // si las columnas son iguales
				if(posInicial.getFila() < posFinal.getFila()){
					
					int posicionAdicionalPorLaVista = 1;
					while(iteradorDeImprevistos.hasNext()){
						Imprevisto imprevistoActual	 = iteradorDeImprevistos.next();
						if(!imprevistoActual.getUsada()){
							String tipoDeImprevisto = imprevistoActual	.getTipoDeImprevisto();
							imagenImprevisto = new ImageIcon(getClass().getResource(tipoDeImprevisto + ".png")).getImage();
							celdas[((posInicial.getFila()-1)*3) + posicionAdicionalPorLaVista][((posInicial.getColumna()-1)*3)].setImagen(imagenImprevisto);
							++posicionAdicionalPorLaVista;
						}
					}
					
				}else{ // si la columna inicial es mayor
					
					int posicionAdicionalPorLaVista = 1;
					while(iteradorDeImprevistos.hasNext()){
						Imprevisto imprevistoActual	 = iteradorDeImprevistos.next();
						if(!imprevistoActual.getUsada()){
							String tipoDeImprevisto = imprevistoActual	.getTipoDeImprevisto();
							imagenImprevisto = new ImageIcon(getClass().getResource(tipoDeImprevisto + ".png")).getImage();
							celdas[((posInicial.getFila()-1)*3) - posicionAdicionalPorLaVista][((posInicial.getColumna()-1)*3)].setImagen(imagenImprevisto);
							++posicionAdicionalPorLaVista;
						}
					}
				}
			}	
		}
	}
	
	public void update() {
	    Posicion posicionVehiculo;
	    Image imagenVehiculo;
	    String tipoVehiculo;
	    if(controlador.estaEnJuego()){	
	    	limpiarTablero();
	    	Mapa mapa = controlador.obtenerMapa();
	    	posicionVehiculo = mapa.getVehiculo().getEsquina().getPosicion();
	    	tipoVehiculo = mapa.getVehiculo().getNombreEstado();
	    	escribirDatosDelJugador();
	    	mostrarLargada();
	    	mostrarMeta();
	    	dibujarVehiculo();
	    	dibujarImprevistos();
	    }
	    else{
	    	if(controlador.pedirPuntajeActual() == 0){
	    		vistaPrincipal.cambiarPanel("pPerdiste");
	    	}
	    	else{
	    		vistaPrincipal.cambiarPanel("pGanaste");
	    	}
	    }
	}
}
	
