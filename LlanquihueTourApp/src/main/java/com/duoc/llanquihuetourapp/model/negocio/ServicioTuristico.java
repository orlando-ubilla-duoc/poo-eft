package com.duoc.llanquihuetourapp.model.negocio;

/**
 * Clase abstracta, Representa un servicio turístico que puede ser ofrecido por un guía de turismo.
 * Esta clase sirve como base para otros tipos específicos de servicios turísticos.
 * @author	Orlando Ubilla
 * @since	EFT
 */
public abstract class ServicioTuristico {

	private String rutGuiaTurismo;
	private int    precio;
	private String nombreServicio;

	public ServicioTuristico(String nombre, String rutGuia, int precio) {
		this.nombreServicio = nombre;
		this.rutGuiaTurismo = rutGuia;
		this.precio         = precio;
	}

	public String getNombreServicio() {
		return this.nombreServicio;
	}

	public void setNombreServicio(String tituloServicio) {
		this.nombreServicio = tituloServicio;
	}

	public String getGuiaTurismo() {
		return this.rutGuiaTurismo;
	}
	
	public void setGuiaTurismo(String guia) {
		this.rutGuiaTurismo = guia;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}