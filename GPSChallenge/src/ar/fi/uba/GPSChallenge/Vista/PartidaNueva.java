package ar.fi.uba.GPSChallenge.Vista;

import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;

import ar.fi.uba.GPSChallenge.Controlador.Controlador;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

public class PartidaNueva extends JPanel {

	private VistaPrincipal vistaPrincipal;
	private Controlador controlador;

	public PartidaNueva(final VistaPrincipal vistaPrincipal, final Controlador controlador) {
		
		this.vistaPrincipal = vistaPrincipal;
		this.controlador = controlador;
		
		setLayout(null);
		setBounds(10, 10, 1200, 700);
		
		JPanel panelDeDificultad = new JPanel();
		panelDeDificultad.setBounds(45, 97, 136, 97);
		add(panelDeDificultad);
		
		JPanel panelDeVehiculo = new JPanel();
		panelDeVehiculo.setBounds(268, 97, 136, 97);
		add(panelDeVehiculo);
		
		JLabel labelSeleccioneDificultad = new JLabel("Seleccione dificultad:");
		labelSeleccioneDificultad.setLabelFor(panelDeDificultad);
		panelDeDificultad.setLayout(null);
		
		final ButtonGroup botoneraDificultad = new ButtonGroup();
		
		JRadioButton botonFacil = new JRadioButton("Fácil");
		botonFacil.setBounds(8, 8, 149, 23);
		panelDeDificultad.add(botonFacil);
		botoneraDificultad.add(botonFacil);
		
		JRadioButton botonModerado = new JRadioButton("Moderado");
		botonModerado.setBounds(8, 35, 149, 23);
		panelDeDificultad.add(botonModerado);
		botoneraDificultad.add(botonModerado);
		
		JRadioButton botonDificil = new JRadioButton("Dificil");
		botonDificil.setBounds(8, 62, 149, 23);
		panelDeDificultad.add(botonDificil);
		botoneraDificultad.add(botonDificil);
		
		labelSeleccioneDificultad.setBounds(45, 71, 163, 22);
		add(labelSeleccioneDificultad);
		
		JLabel labelSeleccioneVehculo = new JLabel("Seleccione vehículo:");
		labelSeleccioneVehculo.setLabelFor(panelDeVehiculo);
		panelDeVehiculo.setLayout(null);

		final ButtonGroup botoneraVehiculo = new ButtonGroup();
		
		JRadioButton botonMoto = new JRadioButton("Moto");
		botonMoto.setBounds(8, 8, 149, 23);
		panelDeVehiculo.add(botonMoto);
		botoneraVehiculo.add(botonMoto);
		
		JRadioButton botonCuatroPorCuatro = new JRadioButton("4X4");
		botonCuatroPorCuatro.setBounds(8, 35, 149, 23);
		panelDeVehiculo.add(botonCuatroPorCuatro);
		botoneraVehiculo.add(botonCuatroPorCuatro);
		
		JRadioButton botonAuto = new JRadioButton("Auto");
		botonAuto.setBounds(8, 62, 149, 23);
		panelDeVehiculo.add(botonAuto);
		botoneraVehiculo.add(botonAuto);
		
		labelSeleccioneVehculo.setBounds(268, 75, 152, 15);
		add(labelSeleccioneVehculo);
		
		JButton botonJugar = new JButton("Jugar");
		botonJugar.setBounds(166, 230, 117, 25);
		add(botonJugar);
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dificultadSeleccionada = getTextDelBtnSeleccionado(botoneraDificultad);
				controlador.elegirDificultadSeleccionada(dificultadSeleccionada);
				String vehiculoSeleccionado = getTextDelBtnSeleccionado(botoneraVehiculo);
				controlador.elegirVehiculoSeleccionado(vehiculoSeleccionado);
				vistaPrincipal.cambiarPanel("pEscenario");
			}
		});
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBorder(null);
		panelCabecera.setBackground(UIManager.getColor("Button.focus"));
		panelCabecera.setBounds(0, 0, 450, 59);
		add(panelCabecera);
		panelCabecera.setLayout(null);
		
		JLabel labelNombreDelUsuario = new JLabel("");
		labelNombreDelUsuario.setBounds(12, 12, 70, 15);
		panelCabecera.add(labelNombreDelUsuario);
		
		JLabel labelNuevapartida = new JLabel("NuevaPartida");
		labelNuevapartida.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		labelNuevapartida.setBounds(147, 12, 169, 35);
		panelCabecera.add(labelNuevapartida);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(360, 12, 78, 25);
		panelCabecera.add(botonVolver);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaPrincipal.cambiarPanel("pMenuPartida");
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
