package com.duoc.llanquihuetourapp.model.actores;

/**
 * Clase Cliente que extiende de Persona, representando a un cliente con un tipo específico (Regular, Premium, etc.).
 * @author	Orlando Ubilla
 * @since	EFT
 */
public class Cliente extends Persona {

	private String tarjetaCredito;
	private String nacionalidad;

	public Cliente(String nombre, String apellidos, String email, String telefono, String direccion, Rut rut, String tarjetaCredito, String nacionalidad) {
		super(nombre, apellidos, email, telefono, direccion, rut);
		this.tarjetaCredito = tarjetaCredito;
		this.nacionalidad   = nacionalidad;
	}

	/**
	 * Crea objeto Cliente desde String array.
	 * @param cols[0]	nombre
	 * @param cols[1]	apellidos
	 * @param cols[2]	e-mail
	 * @param cols[3]	telefono
	 * @param cols[4]	direccion
	 * @param cols[5]	rut + dv
	 * @param cols[6]	tarjeta-credito
	 * @param cols[7]	nacionalidad
	 * @throws Exception
	 */
	public Cliente(String[] cols) throws Exception {
		super( cols[0], cols[1], cols[2], cols[3], cols[4], new Rut(cols[5]));
		this.tarjetaCredito = cols[6];
		this.nacionalidad   = cols[7];
	}

	public Cliente() {
		super();
		this.tarjetaCredito = "";
		this.nacionalidad   = "";
	}

	public String getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Override
	public String toString() {
		return super.toString() + ", \n" +
			"tarjeta-credito=" + this.getTarjetaCredito() + ", \n" +
			"nacionalidad=" + this.getNacionalidad() + ", \n"
		;
	}

}