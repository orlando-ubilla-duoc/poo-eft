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
		this.nacionalidad = nacionalidad;
	}

	public Cliente() {
		super();
		this.tarjetaCredito = "";
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