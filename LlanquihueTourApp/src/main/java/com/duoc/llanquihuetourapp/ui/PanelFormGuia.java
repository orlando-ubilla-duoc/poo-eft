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
import com.duoc.llanquihuetourapp.model.GuiaTuristico;
import com.duoc.llanquihuetourapp.model.Rut;

public class PanelFormGuia extends JPanel {

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtRut;
	private JTextField txtAgencia;
	private GestorEntidades gestorEntidades;

	public PanelFormGuia( GestorEntidades gestor ){

		super();

		this.gestorEntidades = gestor;
		setLayout(new GridLayout(8, 2, 10, 10));
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));

		crearCampos();
		crearBotones();
	}

	private void crearCampos(){

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNombre.setSize( 60, 60);
		this.txtNombre = new JTextField();
		this.txtNombre.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 18));
		lblApellido.setSize( 60, 60);
		this.txtApellido = new JTextField();
		this.txtApellido.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTelefono.setSize( 60, 60);
		this.txtTelefono = new JTextField();
		this.txtTelefono.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmail.setSize( 60, 60);
		this.txtEmail = new JTextField();
		this.txtEmail.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDireccion.setSize( 60, 60);
		this.txtDireccion = new JTextField();
		this.txtDireccion.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblRut = new JLabel("Rut (ej: 10111000-1):");
		lblRut.setFont(new Font("Arial", Font.PLAIN, 18));
		lblRut.setSize( 60, 60);
		this.txtRut = new JTextField();
		this.txtRut.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblAgencia = new JLabel("Agencia de Turismo:");
		lblAgencia.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAgencia.setSize( 60, 60);
		this.txtAgencia = new JTextField();
		this.txtAgencia.setFont(new Font("Monospaced", Font.PLAIN, 16));

		add(lblNombre);
		add(this.txtNombre);
		add(lblApellido);
		add(this.txtApellido);
		add(lblTelefono);
		add(this.txtTelefono);
		add(lblEmail);
		add(this.txtEmail);
		add(lblDireccion);
		add(this.txtDireccion);
		add(lblRut);
		add(this.txtRut);
		add(lblAgencia);
		add(this.txtAgencia);

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
		this.txtNombre.setText("");
		this.txtApellido.setText("");
		this.txtTelefono.setText("");
		this.txtEmail.setText("");
		this.txtDireccion.setText("");
		this.txtRut.setText("");
		this.txtAgencia.setText("");
	}

	private void guardarFormulario() {
		try {
			GuiaTuristico guia = new GuiaTuristico(
				this.txtNombre.getText().trim()+" "+this.txtApellido.getText().trim(),
				this.txtEmail.getText().trim(),
				this.txtTelefono.getText().trim(),
				this.txtDireccion.getText().trim(),
				new Rut(this.txtRut.getText().trim()),
				this.txtAgencia.getText().trim()
			);

			this.gestorEntidades.agregarEntidad(guia);

			JOptionPane.showMessageDialog( this, "Guía turístico registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

			ResetFormulario();

		} catch (Exception e) {
			System.out.println("Exception at new GuiaTuristico: " + e.getMessage());
			JOptionPane.showMessageDialog( this, e.getMessage(), "Dato de formulario inválido", JOptionPane.ERROR_MESSAGE);
		}
	}
}