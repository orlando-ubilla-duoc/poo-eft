package com.duoc.llanquihuetourapp.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.duoc.llanquihuetourapp.interfaces.Registrable;
import com.duoc.llanquihuetourapp.data.GestorServicios;
import com.duoc.llanquihuetourapp.model.negocio.PaseoLacustre;
import com.duoc.llanquihuetourapp.model.negocio.RutaCultural;
import com.duoc.llanquihuetourapp.model.negocio.ServicioTuristico;
import com.duoc.llanquihuetourapp.model.negocio.TourGastronomico;

/**
 * Clase que representa la ventana de resumen de datos, mostrando la información de todas las entidades registradas.
 * @author	Orlando Ubilla
 * @since	EFT
 */
public class VistaGestion {

	private JFrame ventana;
	private JFrame framePadre;
	private GestorServicios gestorServ;
	private JTextField txtNombre;
	private JTextField txtFecha;
	private JTextField txtHorario;
	private JTextArea txtActividades;
	private JTextField txtResponsable;
	private JTextField txtPrecio;
	private DefaultTableModel gridModel;

	private JComboBox<String> nombresGuias;

	public VistaGestion( JFrame padre, GestorServicios gestor, String titulo ){
		
		this.framePadre  = padre;
		this.gestorServ  = gestor;
		this.ventana     = new JFrame(titulo);
		this.ventana.setSize(800,512);
		this.ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.ventana.setLocationRelativeTo(null);
		this.ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.PAGE_AXIS));
		this.ventana.setResizable(false);

		// Panel superior con campos y controles
		JPanel panelForm1 = new JPanel();

		// Inicializa elemento para seleccionar tipo de registro
		String opcionesCbx[] = { "- Seleccionar -"};
		this.nombresGuias = new JComboBox<>(opcionesCbx);
		this.nombresGuias.setFont(new Font("Monospaced", Font.PLAIN, 16));
		JLabel lblGuia = new JLabel("Guias :");
		lblGuia.setSize( 100, 40);
		lblGuia.setFont(new Font("Arial", Font.PLAIN, 18));

		panelForm1.add(lblGuia);
		panelForm1.add(this.nombresGuias);
		ConfigurarComponentes(panelForm1);

		// Panel inferior para mostrar registros de servicios
		JPanel panelGrilla = new JPanel();
		panelGrilla.setPreferredSize(new Dimension(796, 300));

		String[] columns = {"Servicio", "Rut Encargado", "Precio"};
		Object[][] data  = {};
		this.gridModel   = new DefaultTableModel(data, columns);

		// carga datos iniciales a grilla
		loadGridServicios(this.gridModel);

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
						String nombreKey = gridModel.getValueAt(modelRow, 0).toString();
						loadTextinputData( getGestorServicios().getByNombre(nombreKey) );
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(790, 200));


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

		panelGrilla.add(scrollPane);

		this.ventana.add(panelForm1);
		this.ventana.add(panelGrilla);
		this.ventana.setVisible(true);

		//mostrarInformacion();


	}

	public JFrame getVentanaPadre(){
		return this.framePadre;
	}

	public GestorServicios getGestorServicios(){
		return this.gestorServ;
	}

	private void loadTextinputData( ServicioTuristico servicio)
	{
		this.txtNombre.setText(servicio.getNombreServicio());
		this.txtPrecio.setText(servicio.getPrecio()+"");
		this.txtResponsable.setText(servicio.getGuiaTurismo());

		if( servicio instanceof TourGastronomico ){
			// getZonaTour
			this.txtActividades.setText(((TourGastronomico) servicio).getZonaTour());
		}

		if( servicio instanceof RutaCultural ){
			// lugarHistorico
			this.txtActividades.setText(((RutaCultural) servicio).getLugarHistorico());
		}

		if( servicio instanceof PaseoLacustre ){
			// destinoLacustre
			// tipoEmbarcacion
			this.txtActividades.setText(((PaseoLacustre) servicio).getDestinoLacustre());
		}

		// mostrar por consola Datos completos del Objeto que corresponde al servicio.
		Registrable registro = (Registrable) servicio; // Todos los servicios implementan Registrable
		registro.mostrarDatos();
	}


	private void loadGridServicios(DefaultTableModel modelo){
		modelo.setRowCount(0);
		List<ServicioTuristico> datos = this.gestorServ.getServicios();
		for(ServicioTuristico servicio :datos){
			modelo.addRow(new Object[]{
				servicio.getNombreServicio(),
				servicio.getGuiaTurismo(),
				servicio.getPrecio()
			});
		}
	}

	private void ConfigurarComponentes(JPanel panel)
	{
		panel.setLayout(new GridLayout( 4, 4, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		panel.setPreferredSize(new Dimension(800, 100));
		panel.setMaximumSize(new Dimension(800, 100));

		JLabel lblNombre = new JLabel("Tour :");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
		this.txtNombre = new JTextField();
		this.txtNombre.setFont(new Font("Monospaced", Font.PLAIN, 14));

		JLabel lblResponsable = new JLabel("Responsable :");
		lblResponsable.setFont(new Font("Arial", Font.PLAIN, 18));
		this.txtResponsable = new JTextField();
		this.txtResponsable.setFont(new Font("Monospaced", Font.PLAIN, 14));

		JLabel lblFecha = new JLabel("Fecha :");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 18));
		this.txtFecha = new JTextField();
		this.txtFecha.setFont(new Font("Monospaced", Font.PLAIN, 14));

		JLabel lblHorario = new JLabel("Horario :");
		lblHorario.setFont(new Font("Arial", Font.PLAIN, 18));
		this.txtHorario = new JTextField();
		this.txtHorario.setFont(new Font("Monospaced", Font.PLAIN, 14));

		JLabel lblActiv = new JLabel("Actividades:");
		lblActiv.setFont(new Font("Arial", Font.PLAIN, 18));
		this.txtActividades = new JTextArea();
		this.txtActividades.setFont(new Font("Monospaced", Font.PLAIN, 14));

		JLabel lblPrecio = new JLabel("Precio :");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 18));
		this.txtPrecio = new JTextField();
		this.txtPrecio.setFont(new Font("Monospaced", Font.PLAIN, 14));

		panel.add(lblNombre);
		panel.add(this.txtNombre);

		panel.add(lblResponsable);
		panel.add(this.txtResponsable);

		panel.add(lblFecha);
		panel.add(this.txtFecha);

		panel.add(lblHorario);
		panel.add(this.txtHorario);

		panel.add(lblPrecio);
		panel.add(this.txtPrecio);

		panel.add(lblActiv);
		panel.add(this.txtActividades);
	}


}