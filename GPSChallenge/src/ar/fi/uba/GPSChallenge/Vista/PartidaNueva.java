package ar.fi.uba.GPSChallenge.Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import ar.fi.uba.GPSChallenge.Controlador.Controlador;

public class PartidaNueva extends JPanel {

	private VistaPrincipal vistaPrincipal;
	private Controlador controlador;

	public PartidaNueva(final VistaPrincipal vistaPrincipal,final Controlador controlador) {
		setLayout(null);
		setBounds(10, 10, 1200, 700);

		this.vistaPrincipal = vistaPrincipal;
		this.controlador = controlador;

		JPanel panelCabecera = new JPanel();
		panelCabecera.setBorder(null);
		panelCabecera.setBackground(UIManager.getColor("Button.focus"));
		panelCabecera.setBounds(10, 10, 1200, 60);
		add(panelCabecera);
		panelCabecera.setLayout(null);

		JLabel labelNombreDelUsuario = new JLabel(this.controlador.pedirNombreDelJugadorActual());
		labelNombreDelUsuario.setBounds(12, 12, 120, 15);
		panelCabecera.add(labelNombreDelUsuario);

		JLabel labelNuevapartida = new JLabel("NuevaPartida");
		labelNuevapartida.setFont(new Font("Dialog", Font.BOLD, 30));
		labelNuevapartida.setHorizontalAlignment(SwingConstants.CENTER);
		labelNuevapartida.setBounds(445, 12, 300, 35);
		panelCabecera.add(labelNuevapartida);
		
		JPanel panelDeDificultad = new JPanel();
		panelDeDificultad.setBounds(250, 110, 300, 400);
		panelDeDificultad.setBorder(BorderFactory.createLineBorder(Color.black));
		panelDeDificultad.setLayout(null);
		add(panelDeDificultad);

		JLabel labelSeleccioneDificultad = new JLabel("Seleccione dificultad:");
		labelSeleccioneDificultad.setFont(new Font("Dialog", Font.PLAIN, 20));
		labelSeleccioneDificultad.setBounds(250, 75, 300, 30);
		add(labelSeleccioneDificultad);

		final ButtonGroup botoneraDificultad = new ButtonGroup();

		JRadioButton botonFacil = new JRadioButton("Facil");
		botonFacil.setFont(new Font("Dialog", Font.PLAIN, 15));
		botonFacil.setBounds(8, 8, 149, 23);
		panelDeDificultad.add(botonFacil);
		botoneraDificultad.add(botonFacil);

		JRadioButton botonModerado = new JRadioButton("Moderado");
		botonModerado.setFont(new Font("Dialog", Font.PLAIN, 15));
		botonModerado.setBounds(8, 35, 149, 23);
		panelDeDificultad.add(botonModerado);
		botoneraDificultad.add(botonModerado);

		JRadioButton botonDificil = new JRadioButton("Dificil");
		botonDificil.setFont(new Font("Dialog", Font.PLAIN, 15));
		botonDificil.setBounds(8, 62, 149, 23);
		panelDeDificultad.add(botonDificil);
		botoneraDificultad.add(botonDificil);
		
		JPanel panelDeVehiculo = new JPanel();
		panelDeVehiculo.setBounds(650, 110, 300, 400);
		panelDeVehiculo.setBorder(BorderFactory.createLineBorder(Color.black));
		panelDeVehiculo.setLayout(null);
		add(panelDeVehiculo);

		JLabel labelSeleccioneVehculo = new JLabel("Seleccione vehiculo:");
		labelSeleccioneVehculo.setBounds(650, 75, 300, 30);
		labelSeleccioneVehculo.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(labelSeleccioneVehculo);

		final ButtonGroup botoneraVehiculo = new ButtonGroup();

		JRadioButton botonMoto = new JRadioButton("Moto");
		botonMoto.setFont(new Font("Dialog", Font.PLAIN, 15));
		botonMoto.setBounds(8, 10, 149, 23);
		panelDeVehiculo.add(botonMoto);
		botoneraVehiculo.add(botonMoto);

		JRadioButton botonCuatroPorCuatro = new JRadioButton("4X4");
		botonCuatroPorCuatro.setFont(new Font("Dialog", Font.PLAIN, 15));
		botonCuatroPorCuatro.setBounds(8, 40, 149, 23);
		panelDeVehiculo.add(botonCuatroPorCuatro);
		botoneraVehiculo.add(botonCuatroPorCuatro);

		JRadioButton botonAuto = new JRadioButton("Auto");
		botonAuto.setFont(new Font("Dialog", Font.PLAIN, 15));
		botonAuto.setBounds(8, 70, 149, 23);
		panelDeVehiculo.add(botonAuto);
		botoneraVehiculo.add(botonAuto);

		JButton botonJugar = new JButton("Jugar");
		botonJugar.setBounds(350, 530, 200, 70);
		add(botonJugar);
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dificultadSeleccionada = getTextDelBtnSeleccionado(botoneraDificultad);
				controlador
						.elegirDificultadSeleccionada(dificultadSeleccionada);
				String vehiculoSeleccionado = getTextDelBtnSeleccionado(botoneraVehiculo);
				controlador.elegirVehiculoSeleccionado(vehiculoSeleccionado);
				vistaPrincipal.cambiarPanel("pEscenario");
			}
		});

		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(650, 530, 200, 70);
		add(botonVolver);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaPrincipal.cambiarPanel("pMenuPartida");
			}
		});
	}

	public String getTextDelBtnSeleccionado(ButtonGroup bGroup) {
		for (Enumeration<AbstractButton> todosLosBotones = bGroup.getElements(); todosLosBotones
				.hasMoreElements();) {
			AbstractButton boton = todosLosBotones.nextElement();
			if (boton.isSelected()) {
				return boton.getText();
			}
		}
		return null;
	}
}
