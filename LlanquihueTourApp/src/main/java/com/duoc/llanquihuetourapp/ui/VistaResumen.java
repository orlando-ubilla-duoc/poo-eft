package com.duoc.llanquihuetourapp.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.duoc.llanquihuetourapp.data.GestorDatos;

/**
 * Clase que representa la ventana de resumen de datos, mostrando la información de todas las entidades registradas.
 * @author	Orlando Ubilla
 * @since	Sumativa-3
 */
public class VistaResumen {

	private JFrame ventana;
	private JFrame framePadre;
	private JTextArea areaSalida;
	private GestorDatos gestorDatos;

	public VistaResumen( JFrame padre, GestorDatos gestor, String titulo ){
		
		this.framePadre  = padre;
		this.gestorDatos = gestor;
		this.ventana     = new JFrame(titulo);
		this.ventana.setSize(640,480);
		this.ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.ventana.setLocationRelativeTo(null);
		this.ventana.setLayout(null);
		this.ventana.setResizable(false);

		JPanel panelResumen = new JPanel();
		panelResumen.setSize( 640-2, 480-52);
		panelResumen.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.areaSalida = new JTextArea( 24, 76);
		this.areaSalida.setFont(new Font("Monospaced", Font.PLAIN, 13));
		this.areaSalida.setEditable(false);
		this.areaSalida.setLayout(null);
		this.areaSalida.setEditable(false);

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

		panelResumen.add(this.areaSalida);
		this.ventana.add(panelResumen);
		this.ventana.setVisible(true);

		mostrarInformacion();


	}

	public JFrame getVentanaPadre(){
		return this.framePadre;
	}

	private void mostrarInformacion(){
		String salida = "";//gestorDatos.getResumenEntidades();
		if( salida.isEmpty() ){
			this.areaSalida.setText("-- No hay entidades registradas. --");
		} else {
			this.areaSalida.setText( salida );
			System.out.print(salida); // DEBUG
		}
	}


}