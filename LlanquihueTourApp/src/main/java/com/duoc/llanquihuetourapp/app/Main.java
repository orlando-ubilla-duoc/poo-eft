package com.duoc.llanquihuetourapp.app;

import javax.swing.SwingUtilities;

import com.duoc.llanquihuetourapp.data.GestorDatos;
import com.duoc.llanquihuetourapp.data.GestorServicios;
import com.duoc.llanquihuetourapp.ui.VistaPrincipal;

public class Main {
	public static void main(String[] args){

		// Carga datos persistentes en disco (archivos txt)
		GestorDatos gestorDatos = new GestorDatos();
		gestorDatos.cargaClientes("clientes.txt");
		gestorDatos.cargaGuias("guias_turisticos.txt");
		gestorDatos.cargaProveedores("proveedores.txt");

		// Cargar servicios
		GestorServicios gestorServicios = new GestorServicios();
		gestorServicios.cargaToursGastronomicos("tour_gastronomico.txt");
		gestorServicios.cargaToursCulturales("tour_cultural.txt");
		gestorServicios.cargaToursLacustres("tour_lacustre.txt");

		// Inicia programa.
		SwingUtilities.invokeLater(() -> {
			VistaPrincipal EvaluacionFinalTransversal = new VistaPrincipal( "Llanquihue-Tour App : EFT", gestorDatos, gestorServicios);
		});
	}

}