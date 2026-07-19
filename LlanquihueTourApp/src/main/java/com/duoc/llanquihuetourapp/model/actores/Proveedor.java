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

	/**
	 * Crea objeto Cliente desde String array.
	 * @param cols[0]	nombre
	 * @param cols[1]	apellidos
	 * @param cols[2]	e-mail
	 * @param cols[3]	telefono
	 * @param cols[4]	direccion
	 * @param cols[5]	rut + dv
	 * @param cols[6]	nombre-hotel
	 * @param cols[7]	giro-comercial
	 * @throws Exception
	 */
	public Proveedor(String[] cols) throws Exception {
		super( cols[0], cols[1], cols[2], cols[3], cols[4], new Rut(cols[5]));
		this.nombreHotel   = cols[6];
		this.giroComercial = cols[7];
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