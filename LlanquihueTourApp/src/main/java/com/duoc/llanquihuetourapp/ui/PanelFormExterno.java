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
import com.duoc.llanquihuetourapp.model.ColaboradorExterno;
import com.duoc.llanquihuetourapp.model.Rut;

public class PanelFormExterno extends JPanel {

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtRut;
	private JTextField txtEmpresa;
	private JTextField txtGiro;
	private GestorEntidades gestorEntidades;

	public PanelFormExterno( GestorEntidades gestor ){

		super();

		this.gestorEntidades = gestor;
		setLayout(new GridLayout( 9, 2, 10, 10));
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

		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmpresa.setSize( 60, 60);
		this.txtEmpresa = new JTextField();
		this.txtEmpresa.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblGiro = new JLabel("Giro:");
		lblGiro.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGiro.setSize( 60, 60);
		this.txtGiro = new JTextField();
		this.txtGiro.setFont(new Font("Monospaced", Font.PLAIN, 16));

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
		add(lblEmpresa);
		add(this.txtEmpresa);
		add(lblGiro);
		add(this.txtGiro);

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
		this.txtEmpresa.setText("");
		this.txtGiro.setText("");
	}

	private void guardarFormulario(){
		try {
			ColaboradorExterno externo = new ColaboradorExterno(
				this.txtNombre.getText().trim()+" "+this.txtApellido.getText().trim(),
				this.txtEmail.getText().trim(),
				this.txtTelefono.getText().trim(),
				this.txtDireccion.getText().trim(),
				new Rut(this.txtRut.getText().trim()),
				this.txtEmpresa.getText().trim(),
				this.txtGiro.getText().trim()
			);

			this.gestorEntidades.agregarEntidad(externo);

			JOptionPane.showMessageDialog( this, "Colaborador externo registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

			ResetFormulario();

		} catch (Exception e) {
			System.out.println("Exception at new ColaboradorExterno: " + e.getMessage());
			JOptionPane.showMessageDialog( this, e.getMessage(), "Dato de formulario inválido", JOptionPane.ERROR_MESSAGE);
		}
	}

}