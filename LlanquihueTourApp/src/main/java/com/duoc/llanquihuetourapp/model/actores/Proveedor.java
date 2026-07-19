package com.duoc.llanquihuetourapp.model.actores;

/**
 * Clase Proveedor que extiende de Persona, representando a un proveedor de alojamiento.
 * @author	Orlando Ubilla
 * @since	EFT
 */
public class Proveedor extends Persona {
	
	private String nombreHotel;
	private String giroComercial;

	/**
	 * clase Proveedor de Alojamiento:<br>
	 * Provee servicios de alojamiento en Hostales, para Clientes.
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param telefono
	 * @param direccion
	 * @param rut
	 * @param nombreHotel
	 * @param giroComercial
	 */
	public Proveedor(String nombre, String apellidos, String email, String telefono, String direccion, Rut rut, String nombreHotel, String giroComercial) {
		super(nombre, apellidos, email, telefono, direccion, rut);
		this.nombreHotel   = nombreHotel;
		this.giroComercial = giroComercial;
	}

	public Proveedor() {
		super();
		this.nombreHotel   = "";
		this.giroComercial = "";
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public String getGiroComercial() {
		return giroComercial;
	}

	public void setGiroComercial(String giroComercial) {
		this.giroComercial = giroComercial;
	}

	@Override
	public String toString() {
		return super.toString() + ", \n" +
			"nombre-hotel=" + this.getNombreHotel() + ", \n" +
			"giro-comercial=" + this.getGiroComercial() + ", \n"
		;
	}

}