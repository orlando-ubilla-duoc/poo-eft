package com.duoc.llanquihuetourapp.model.negocio;

import com.duoc.llanquihuetourapp.model.actores.Guia;

/**
 * Clase abstracta, Representa un servicio turístico que puede ser ofrecido por un guía de turismo.
 * Esta clase sirve como base para otros tipos específicos de servicios turísticos.
 * @author	Orlando Ubilla
 * @since	EFT
 */
public abstract class ServicioTuristico {

	private Guia   guiaTurismo;
	private int    precio;
	private String nombreServicio;

	public ServicioTuristico(String nombre, Guia guiaTurismo, int precio) {
		this.nombreServicio = nombre;
		this.guiaTurismo    = guiaTurismo;
		this.precio         = precio;
	}

	public String getNombreServicio() {
		return this.nombreServicio;
	}

	public void setNombreServicio(String tituloServicio) {
		this.nombreServicio = tituloServicio;
	}

	public Guia getGuiaTurismo() {
		return this.guiaTurismo;
	}
	
	public void setGuiaTurismo(Guia guiaTurismo) {
		this.guiaTurismo = guiaTurismo;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}