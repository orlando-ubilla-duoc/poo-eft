package com.duoc.llanquihuetourapp.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.duoc.llanquihuetourapp.data.GestorDatos;
import com.duoc.llanquihuetourapp.model.actores.Cliente;
import com.duoc.llanquihuetourapp.model.actores.Guia;
import com.duoc.llanquihuetourapp.model.actores.Persona;
import com.duoc.llanquihuetourapp.model.actores.Proveedor;
import com.duoc.llanquihuetourapp.model.actores.Rut;

/**
 * Clase que representa la ventana de ingreso de datos, con formulario dinámico según tipo de registro,
 * y una grilla para ver los registro ya existentes.
 * @author	Orlando Ubilla
 * @since	EFT
 */
public class VistaIngreso {

	private JFrame ventana;
	private JFrame framePadre;
	private JPanel panelFormulario;
	private JComboBox<String> tipoEntidad;
	private GestorDatos gestorDatos;
	// default fields
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtRut;
	private JTextField customField1;
	private JTextField customField2;
	private JLabel lblCustom1;
	private JLabel lblCustom2;
	private DefaultTableModel gridModel;


	public VistaIngreso(JFrame padre, GestorDatos gestor, String titulo) {
		this.framePadre  = padre;
		this.gestorDatos = gestor;
		this.ventana     = new JFrame(titulo);
		this.ventana.setSize(800,512);
		this.ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.ventana.setLocationRelativeTo(null);
		this.ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.PAGE_AXIS));
		this.ventana.setResizable(false);
		ConfigurarComponentes();

		// registro evento al cerrar esta ventana
		this.ventana.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				if( getVentanaPadre()!=null ){
					getVentanaPadre().setVisible(true); // vuelve a mostrar ventana padre
				}
			}

			@Override
			public void windowClosed(WindowEvent e){
				if( getVentanaPadre()!=null ){
					getVentanaPadre().setVisible(true); // vuelve a mostrar ventana padre
				}
			}
		});

		this.ventana.setVisible(true);
	}

	public JFrame getVentanaPadre(){
		return this.framePadre;
	}

	private void ConfigurarComponentes(){

		// Panel para campos de texto
		JPanel panelSelectOption = new JPanel();
		panelSelectOption.setLayout(new GridLayout( 1, 4 , 10, 10));
		panelSelectOption.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		panelSelectOption.setPreferredSize(new Dimension(800, 40));
		panelSelectOption.setMaximumSize(new Dimension(800, 40));

		// Panel para campos de texto
		this.panelFormulario = new JPanel();
		this.panelFormulario.setLayout(new GridLayout( 4, 4, 10, 10));
		this.panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Inicializa elemento para seleccionar tipo de registro
		String opcionesCbx[] = { "Seleccionar tipo", "GUIA_TURISTICO", "CLIENTE", "PROVEEDOR"};
		this.tipoEntidad = new JComboBox<>(opcionesCbx);
		this.tipoEntidad.setFont(new Font("Monospaced", Font.PLAIN, 16));
		JLabel lblTipo = new JLabel("Tipo de registro:");
		lblTipo.setSize( 100, 50);
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 18));

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btnCancelar = new JButton("Salir");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));

		panelSelectOption.add(lblTipo);
		panelSelectOption.add(this.tipoEntidad);
		panelSelectOption.add(btnGuardar);
		panelSelectOption.add(btnCancelar);

		// Panel para grilla de datos
		JPanel panelGrid = new JPanel();
		panelGrid.setPreferredSize(new Dimension(796, 200));

		// Tabla para la grilla de datos
		String[] columns = {"ID", "Nombre", "Rut", "E-mail", "Fono", "", ""};
		Object[][] data  = {};
		this.gridModel   = new DefaultTableModel(data, columns);
		JTable table     = new JTable(this.gridModel);
		table.setPreferredSize(new Dimension(790, 200));
		table.setAutoCreateRowSorter(true);
		// Evento en tabla, al seleccionar una fila
		table.getSelectionModel().addListSelectionListener( new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e){
				if (!e.getValueIsAdjusting()){
					int selectedRow = table.getSelectedRow();
					if( selectedRow != -1 ){
						int modelRow  = table.convertRowIndexToModel(selectedRow);
						String rutKey = gridModel.getValueAt(modelRow, 2).toString();
						loadTextinputData( getGestorDatos().getByRut(rutKey));
					}
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(790, 200));
		panelGrid.add(scrollPane);

		// elementos basicos para registro
		addPersonaFields(this.panelFormulario);

		// eventos de botones
		this.tipoEntidad.addActionListener( e->{
			int selectedInt = (int) this.tipoEntidad.getSelectedIndex();
			switch (selectedInt) {
				case 1: // Guia Turistico
					this.lblCustom1.setText("Agencia turismo :");
					this.lblCustom2.setText("Años experiencia :");
					// Fill grid
					this.loadGridGuias(this.gridModel);
					// limpia form en caso de seleccionar un registro
					ResetFormulario();
					break;
				case 2: // CLIENTE
					this.lblCustom1.setText("Tarjeta credito :");
					this.lblCustom2.setText("Nacionalidad :");
					// fill grid
					this.loadGridClientes(this.gridModel);
					// limpia form en caso de seleccionar un registro
					ResetFormulario();
					break;
				case 3: // PROVEEDOR
					this.lblCustom1.setText("Nombre Hotel :");
					this.lblCustom2.setText("Giro comercial :");
					// fill grilla
					this.loadGridProveedores(this.gridModel);
					// limpia form en caso de seleccionar un registro
					ResetFormulario();
					break;
				default:
					this.lblCustom1.setText("- - -");
					this.lblCustom2.setText("- - -");
					// clear grid
					this.gridModel.setRowCount(0);
					// limpia form en caso de seleccionar un registro
					ResetFormulario();
					break;
			}
		});

		btnGuardar.addActionListener(e->agregarRegistro());
		btnCancelar.addActionListener(e->VolverMenu());

		ventana.add(panelSelectOption);
		ventana.add(this.panelFormulario);
		ventana.add(panelGrid);

	}

	private void VolverMenu(){
		this.ventana.dispose();
	}

	public GestorDatos getGestorDatos(){
		return this.gestorDatos;
	}

	/**
	 * Agrega al Layout los campos para ingresar los datos en el formulario.
	 * @param panel
	 */
	private void addPersonaFields(JPanel panel)
	{
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
		//lblNombre.setSize( 100, 40);

		this.txtNombre = new JTextField();
		this.txtNombre.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 18));
		//lblApellido.setSize( 60, 60);
		this.txtApellido = new JTextField();
		this.txtApellido.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 18));
		//lblTelefono.setSize( 60, 60);
		this.txtTelefono = new JTextField();
		this.txtTelefono.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		//lblEmail.setSize( 60, 60);
		this.txtEmail = new JTextField();
		this.txtEmail.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 18));
		//lblDireccion.setSize( 60, 60);
		this.txtDireccion = new JTextField();
		this.txtDireccion.setFont(new Font("Monospaced", Font.PLAIN, 16));

		JLabel lblRut = new JLabel("Rut (ej: 10111000-1):");
		lblRut.setFont(new Font("Arial", Font.PLAIN, 18));
		//lblRut.setSize( 60, 60);
		this.txtRut = new JTextField();
		this.txtRut.setFont(new Font("Monospaced", Font.PLAIN, 16));

		this.lblCustom1 = new JLabel("---");
		lblCustom1.setFont(new Font("Arial", Font.PLAIN, 18));
		this.customField1 = new JTextField();
		this.customField1.setFont(new Font("Monospaced", Font.PLAIN, 16));

		this.lblCustom2 = new JLabel("---");
		lblCustom2.setFont(new Font("Arial", Font.PLAIN, 18));
		this.customField2 = new JTextField();
		this.customField2.setFont(new Font("Monospaced", Font.PLAIN, 16));


		panel.add(lblNombre);
		panel.add(this.txtNombre);
		panel.add(lblApellido);
		panel.add(this.txtApellido);
		panel.add(lblTelefono);
		panel.add(this.txtTelefono);
		panel.add(lblEmail);
		panel.add(this.txtEmail);
		panel.add(lblDireccion);
		panel.add(this.txtDireccion);
		panel.add(lblRut);
		panel.add(this.txtRut);
		panel.add(this.lblCustom1);
		panel.add(this.customField1);
		panel.add(this.lblCustom2);
		panel.add(this.customField2);
	}

	/**
	 * Agrega a la grilla de datos unicamente los registro de tipo Guia
	 * @param modelo DefaultTableModel
	 */
	private void loadGridGuias(DefaultTableModel modelo){
		modelo.setColumnCount(0);
		modelo.setRowCount(0);
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Rut");
		modelo.addColumn("E-mail");
		modelo.addColumn("Fono");
		modelo.addColumn("Agencia");
		modelo.addColumn("Años Exp.");
		List<Persona> datos = this.gestorDatos.getDatos();
		for(Persona registro :datos){
			// Valida tipo de Clase
			if( registro instanceof Guia ){
				// Castea a la clase que se necesita
				Guia guia = (Guia) registro;
				// String[] columns = {"ID", "Nombre", "Rut", "E-mail", "Fono"};
				modelo.addRow(new Object[]{
					guia.getId(),
					guia.getNombre()+" "+guia.getApellidos(),
					guia.getRut().getRut(),
					guia.getEmail(),
					guia.getTelefono(),
					guia.getNombreAgencia(),
					guia.getExperiencia()
				});
			}
		}
	}

	/**
	 * * Agrega a la grilla de datos unicamente los registro de tipo Cliente
	 * @param modelo
	 */
	private void loadGridClientes(DefaultTableModel modelo){
		modelo.setColumnCount(0);
		modelo.setRowCount(0);
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Rut");
		modelo.addColumn("E-mail");
		modelo.addColumn("Fono");
		modelo.addColumn("T.Credito");
		modelo.addColumn("Nacionalidad");
		List<Persona> datos = this.gestorDatos.getDatos();
		for(Persona registro :datos){
			// Valida tipo de Clase
			if( registro instanceof Cliente ){
				// Castea a la clase que se necesita
				Cliente cliente = (Cliente) registro;
				// String[] columns = {"ID", "Nombre", "Rut", "E-mail", "Fono"};
				modelo.addRow(new Object[]{
					cliente.getId(),
					cliente.getNombre()+" "+cliente.getApellidos(),
					cliente.getRut().getRut(),
					cliente.getEmail(),
					cliente.getTelefono(),
					cliente.getTarjetaCredito(),
					cliente.getNacionalidad()
				});
			}
		}
	}

	/**
	 * * Agrega a la grilla de datos unicamente los registro de tipo Proveedor
	 * @param modelo
	 */
	private void loadGridProveedores(DefaultTableModel modelo){
		modelo.setColumnCount(0);
		modelo.setRowCount(0);
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Rut");
		modelo.addColumn("E-mail");
		modelo.addColumn("Fono");
		modelo.addColumn("Hotel");
		modelo.addColumn("Giro com.");
		List<Persona> datos = this.gestorDatos.getDatos();
		for(Persona registro :datos){
			// Valida tipo de Clase
			if( registro instanceof Proveedor ){
				// Castea a la clase que se necesita
				Proveedor proveedor = (Proveedor) registro;
				// String[] columns = {"ID", "Nombre", "Rut", "E-mail", "Fono"};
				modelo.addRow(new Object[]{
					proveedor.getId(),
					proveedor.getNombre()+" "+proveedor.getApellidos(),
					proveedor.getRut().getRut(),
					proveedor.getEmail(),
					proveedor.getTelefono(),
					proveedor.getNombreHotel(),
					proveedor.getGiroComercial()
				});
			}
		}
	}

	/**
	 * Limpia datos en campos del formulario.
	 */
	private void ResetFormulario(){
		this.txtNombre.setText("");
		this.txtApellido.setText("");
		this.txtTelefono.setText("");
		this.txtEmail.setText("");
		this.txtDireccion.setText("");
		this.txtRut.setText("");
		this.customField1.setText("");
		this.customField2.setText("");
	}

	/**
	 * Carga datos del registro seleccionado en la grilla de datos.
	 * @param registro Persona
	 */
	private void loadTextinputData(Persona registro)
	{
		if( registro instanceof Cliente ){
			this.txtNombre.setText(registro.getNombre());
			this.txtApellido.setText(registro.getApellidos());
			this.txtTelefono.setText(registro.getTelefono());
			this.txtEmail.setText(registro.getEmail());
			this.txtDireccion.setText(registro.getDireccion());
			this.txtRut.setText(registro.getRut().getRut());
			this.customField1.setText(((Cliente) registro).getTarjetaCredito());
			this.customField2.setText(((Cliente) registro).getNacionalidad());
		}

		if( registro instanceof Guia ){
			this.txtNombre.setText(registro.getNombre());
			this.txtApellido.setText(registro.getApellidos());
			this.txtTelefono.setText(registro.getTelefono());
			this.txtEmail.setText(registro.getEmail());
			this.txtDireccion.setText(registro.getDireccion());
			this.txtRut.setText(registro.getRut().getRut());
			this.customField1.setText(((Guia) registro).getNombreAgencia());
			this.customField2.setText(((Guia) registro).getExperiencia());
		}

		if( registro instanceof Proveedor ){
			this.txtNombre.setText(registro.getNombre());
			this.txtApellido.setText(registro.getApellidos());
			this.txtTelefono.setText(registro.getTelefono());
			this.txtEmail.setText(registro.getEmail());
			this.txtDireccion.setText(registro.getDireccion());
			this.txtRut.setText(registro.getRut().getRut());
			this.customField1.setText(((Proveedor) registro).getNombreHotel());
			this.customField2.setText(((Proveedor) registro).getGiroComercial());
		}
	}

	/**
	 * Agrega el registro al gestor de datos.
	 */
	private void agregarRegistro(){
		try {
			// Evalua cual es la actual opcion de registro seleccionado:

			// GUIA
			if( this.tipoEntidad.getSelectedIndex()==1 ){
				// Crea objeto
				Guia guia = new Guia(
					this.txtNombre.getText().trim(),
					this.txtApellido.getText().trim(),
					this.txtEmail.getText().trim(),
					this.txtTelefono.getText().trim(),
					this.txtDireccion.getText().trim(),
					new Rut(this.txtRut.getText().trim()),
					this.customField1.getText().trim(),
					this.customField2.getText().trim()
				);
				// agrega Guia al listado del gestor.
				this.gestorDatos.agregaRegistro(guia);
				System.out.println("Registro Guia agregado al listado.");
				// refresca lista de datos de la grilla
				this.loadGridGuias(this.gridModel);
			}

			// CLIENTE
			if( this.tipoEntidad.getSelectedIndex()==2 ){
				// Crea objeto
				Cliente cliente = new Cliente(
					this.txtNombre.getText().trim(),
					this.txtApellido.getText().trim(),
					this.txtEmail.getText().trim(),
					this.txtTelefono.getText().trim(),
					this.txtDireccion.getText().trim(),
					new Rut(this.txtRut.getText().trim()),
					this.customField1.getText().trim(),
					this.customField2.getText().trim()
				);
				// agrega Cliente al listado del gestor.
				this.gestorDatos.agregaRegistro(cliente);
				System.out.println("Registro Cliente agregado al listado.");
				// refresca lista de datos de la grilla
				this.loadGridGuias(this.gridModel);
			}

			// PROVEEDOR
			if( this.tipoEntidad.getSelectedIndex()==3 ){
				// Crea objeto
				Proveedor proveedor = new Proveedor(
					this.txtNombre.getText().trim(),
					this.txtApellido.getText().trim(),
					this.txtEmail.getText().trim(),
					this.txtTelefono.getText().trim(),
					this.txtDireccion.getText().trim(),
					new Rut(this.txtRut.getText().trim()),
					this.customField1.getText().trim(),
					this.customField2.getText().trim()
				);
				// agrega Proveedor al listado del gestor.
				this.gestorDatos.agregaRegistro(proveedor);
				System.out.println("Registro Proveedor agregado al listado.");
				// refresca lista de datos de la grilla
				this.loadGridGuias(this.gridModel);
			}

		} catch (Exception ex) {
			System.err.print(ex);
		}
	}


}