package com.duoc.llanquihuetourapp.ui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.duoc.llanquihuetourapp.data.GestorEntidades;
import com.duoc.llanquihuetourapp.model.Conductor;
import com.duoc.llanquihuetourapp.model.Rut;
import com.duoc.llanquihuetourapp.model.Vehiculo;

public class PanelFormVehiculo extends JPanel {

	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPatente;
	private JTextField txtColor;
	private JTextField txtAnnio;
	private JTextField txtKms;
	private JTextField txtResponsable; // Nombre-Apellido
	private JTextField txtRutResponsable; // Rut
	private GestorEntidades gestorEntidades;

	public PanelFormVehiculo( GestorEntidades gestor ){
		super();

		this.gestorEntidades = gestor;
		setLayout(new GridLayout(9, 2, 10, 10));
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
		crearCampos();
		crearBotones();

	}


	private void crearCampos(){

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMarca.setSize( 60, 60);
		this.txtMarca = new JTextField();
		this.txtMarca.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblModelo.setSize( 60, 60);
		this.txtModelo = new JTextField();
		this.txtModelo.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblPatente = new JLabel("Patente:");
		lblPatente.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPatente.setSize( 60, 60);
		this.txtPatente = new JTextField();
		this.txtPatente.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Arial", Font.PLAIN, 18));
		lblColor.setSize( 60, 60);
		this.txtColor = new JTextField();
		this.txtColor.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblAnnio = new JLabel("Año:");
		lblAnnio.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAnnio.setSize( 60, 60);
		this.txtAnnio = new JTextField();
		this.txtAnnio.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblKms = new JLabel("Kilometraje (Km):");
		lblKms.setFont(new Font("Arial", Font.PLAIN, 18));
		lblKms.setSize( 60, 60);
		this.txtKms = new JTextField();
		this.txtKms.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblResponsable = new JLabel("Responsable:");
		lblResponsable.setFont(new Font("Arial", Font.PLAIN, 18));
		lblResponsable.setSize( 60, 60);
		this.txtResponsable = new JTextField();
		this.txtResponsable.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblRutResponsable = new JLabel("Rut del Resp. (ej: 10111000-1):");
		lblRutResponsable.setFont(new Font("Arial", Font.PLAIN, 18));
		lblRutResponsable.setSize( 60, 60);
		this.txtRutResponsable = new JTextField();
		this.txtRutResponsable.setFont(new Font("Monospaced", Font.PLAIN, 16));

		add(lblMarca);
		add(this.txtMarca);
		add(lblModelo);
		add(this.txtModelo);
		add(lblPatente);
		add(this.txtPatente);
		add(lblColor);
		add(this.txtColor);
		add(lblAnnio);
		add(this.txtAnnio);
		add(lblKms);
		add(this.txtKms);
		add(lblResponsable);
		add(this.txtResponsable);
		add(lblRutResponsable);
		add(this.txtRutResponsable);

	}

	private void crearBotones() {

		JButton btnRegistrar    = new JButton("GUARDAR");
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 15));
		JButton btnReset    = new JButton("LIMPIAR");
		btnReset.setFont(new Font("Arial", Font.PLAIN, 15));

		btnRegistrar.addActionListener(e->guardarFormulario());
		btnReset.addActionListener(e->ResetFormulario());

		add(btnRegistrar);
		add(btnReset);
	}

	private void ResetFormulario(){
		this.txtMarca.setText("");
		this.txtModelo.setText("");
		this.txtPatente.setText("");
		this.txtColor.setText("");
		this.txtAnnio.setText("");
		this.txtKms.setText("");
		this.txtResponsable.setText("");
		this.txtRutResponsable.setText("");
		this.txtMarca.requestFocusInWindow();
	}

	private void guardarFormulario(){

		try {
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setMarca(this.txtMarca.getText().trim());
			vehiculo.setModelo(this.txtModelo.getText().trim());
			vehiculo.setPatente(this.txtPatente.getText().trim());
			vehiculo.setColor(this.txtColor.getText().trim());
			vehiculo.setAnnio(Integer.parseInt(this.txtAnnio.getText().trim()));
			vehiculo.setKms(Integer.parseInt(this.txtKms.getText().trim()));
			Conductor responsable = new Conductor( this.txtResponsable.getText().trim(), "", "", new Rut(this.txtRutResponsable.getText().trim()), "" );
			vehiculo.setResponsable(responsable);
			this.gestorEntidades.agregarEntidad(vehiculo);

			JOptionPane.showMessageDialog( this, "Vehículo registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

			ResetFormulario();

		} catch (Exception e) {
			System.out.println("Exception at new Vehiculo: " + e.getMessage());
			JOptionPane.showMessageDialog( this, e.getMessage(), "Dato de formulario inválido", JOptionPane.ERROR_MESSAGE);
		}

	}

}