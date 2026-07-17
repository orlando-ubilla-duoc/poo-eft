package com.duoc.llanquihuetourapp.ui;

import javax.swing.SwingUtilities;

import com.duoc.llanquihuetourapp.data.GestorEntidades;

public class Main {

	public static void main(String[] args) {

		// Para manejar de forma global los datos del programa, transversal entre pantallas, sin tener que persistir los datos en disco o medio externo.
		GestorEntidades gestorEntidades = new GestorEntidades();

		// Inicia programa.
		SwingUtilities.invokeLater(() -> {
			VistaMenu sumativa3 = new VistaMenu( gestorEntidades, "Llanquihue-Tour App");
		});

	}

}