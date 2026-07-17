package com.duoc.llanquihuetourapp.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.duoc.llanquihuetourapp.data.GestorEntidades;

/**
 * Clase que representa la ventana de ingreso de datos, con formulario dinámico según tipo de registro.
 * @author	Orlando Ubilla
 * @since	Sumativa-3
 */
public class VistaIngreso {

	private JFrame ventana;
	private JFrame framePadre;
	private JPanel panelFormulario;
	private JComboBox<String> tipoEntidad;
	private GestorEntidades gestorEntidades;


	public VistaIngreso(JFrame padre, GestorEntidades gestor, String titulo) {
		this.framePadre = padre;
		this.gestorEntidades = gestor;
		this.ventana = new JFrame(titulo);
		this.ventana.setSize(640,512);
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
		panelSelectOption.setLayout(new GridLayout( 2, 2 , 10, 10));
		panelSelectOption.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 20));
		panelSelectOption.setPreferredSize(new Dimension(640, 80));

		// Panel para campos de texto
		this.panelFormulario = new JPanel();

		// Panel para espaciar layout
		JPanel panelPadding = new JPanel();
		panelPadding.setPreferredSize(new Dimension(640, 400));

		// Inicializa elemento para seleccionar tipo de registro
		String opcionesCbx[] = { "Seleccionar tipo", "Guia Turistico", "Vehiculo", "Colaborador Externo"};
		this.tipoEntidad = new JComboBox<>(opcionesCbx);
		this.tipoEntidad.setFont(new Font("Monospaced", Font.PLAIN, 16));
		JLabel lblTipo = new JLabel("Tipo de registro:");
		lblTipo.setSize( 60, 60);
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 18));

		JButton btnCancelar = new JButton("Salir");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));

		panelSelectOption.add(lblTipo);
		panelSelectOption.add(this.tipoEntidad);
		panelSelectOption.add(btnCancelar);
		panelSelectOption.add(new JLabel(""));

		// eventos de botones
		this.tipoEntidad.addActionListener( e->{
			int selectedInt = (int) this.tipoEntidad.getSelectedIndex();
			switch (selectedInt) {
				case 1: // Guia Turistico
					this.ventana.remove(this.panelFormulario);
					this.panelFormulario = new PanelFormGuia( this.gestorEntidades );
					this.ventana.add(this.panelFormulario);
					panelPadding.setVisible(false);
					this.ventana.revalidate();
					this.ventana.repaint();
					break;
				case 2: // Vehiculo
					this.ventana.remove(this.panelFormulario);
					this.panelFormulario = new PanelFormVehiculo( this.gestorEntidades );
					this.ventana.add(this.panelFormulario);
					panelPadding.setVisible(false);
					this.ventana.revalidate();
					this.ventana.repaint();
					break;
				case 3: // Colaborador
					this.ventana.remove(this.panelFormulario);
					this.panelFormulario = new PanelFormExterno( this.gestorEntidades );
					this.ventana.add(this.panelFormulario);
					panelPadding.setVisible(false);
					this.ventana.revalidate();
					this.ventana.repaint();
					break;
				default:
					// resetea vista
					this.ventana.remove(this.panelFormulario);
					this.panelFormulario = new JPanel();
					this.ventana.add(this.panelFormulario);
					panelPadding.setVisible(true);
					this.ventana.revalidate();
					this.ventana.repaint();
					break;
			}
		});

		btnCancelar.addActionListener(e->VolverMenu());

		ventana.add(panelSelectOption);
		ventana.add(this.panelFormulario);
		ventana.add(panelPadding);

	}

	private void VolverMenu(){
		this.ventana.dispose();
	}


}