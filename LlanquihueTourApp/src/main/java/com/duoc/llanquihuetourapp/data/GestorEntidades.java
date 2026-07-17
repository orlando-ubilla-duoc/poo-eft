package com.duoc.llanquihuetourapp.data;

import java.util.ArrayList;

import com.duoc.llanquihuetourapp.model.ColaboradorExterno;
import com.duoc.llanquihuetourapp.model.GuiaTuristico;
import com.duoc.llanquihuetourapp.model.Registrable;
import com.duoc.llanquihuetourapp.model.Vehiculo;

/**
 * Clase que gestiona el listado de entidades de forma polimorfica. Las clases deben implementar la interfaz Registrable.
 * @author	Orlando Ubilla
 * @since	Sumativa-3
 */
public class GestorEntidades {

	private ArrayList<Registrable> entidades;

	public GestorEntidades() {
		this.entidades = new ArrayList<>();
	}

	public void agregarEntidad(Registrable entidad) {
		this.entidades.add(entidad);
	}

	public ArrayList<Registrable> getEntidades() {
		return this.entidades;
	}

	/**
	 * Devuelve una cadena de texto con el resumen de todas las clases gestionadas.
	 * @return String Resumen de entidades
	 */
	public String getResumenEntidades() {
		StringBuilder sb = new StringBuilder();
		for( Registrable entidad : this.entidades ){
			if( entidad instanceof ColaboradorExterno ){
				sb.append("=== RESUMEN DEL COLABORADOR EXTERNO ===").append("\n");
			}
			if( entidad instanceof GuiaTuristico ){
				sb.append("=== RESUMEN DEL GUÍA TURÍSTICO ===").append("\n");
			}
			if( entidad instanceof Vehiculo ){
				sb.append("=== RESUMEN DEL VEHÍCULO ===").append("\n");
			}
			sb.append(entidad.mostrarResumen());
			sb.append(" \n");
		}
		return sb.toString();
	}
}