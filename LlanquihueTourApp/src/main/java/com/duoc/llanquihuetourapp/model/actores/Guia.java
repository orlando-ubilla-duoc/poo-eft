package com.duoc.llanquihuetourapp.model.actores;

/**
 * Clase Guia-Turistico, indica los datos basicos de la persona y los datos de la agencia a la que pertenece.
 * Util para gestionar Tours con Agencias y coordinación con Personal responsable.
 * @author Orlando Ubilla
 * @since  EFT
 */
public class Guia extends Persona {

	private String nombreAgencia;
	private String experiencia;

	public Guia(String nombre, String apellidos, String email, String telefono, String direccion, Rut rut, String nombreAgencia, String experiencia) {
		super(nombre, apellidos, email, telefono, direccion, rut);
		this.nombreAgencia = nombreAgencia;
		this.experiencia  = experiencia;
	}

	public Guia() {
		super();
		this.nombreAgencia = "";
		this.experiencia  = "";
	}

	public String getNombreAgencia() {
		return nombreAgencia;
	}

	public void setNombreAgencia(String nombreAgencia) {
		this.nombreAgencia = nombreAgencia;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public String toString() {
		return super.toString() + ", \n" +
			"nombre-agencia=" + this.getNombreAgencia() + ", \n" +
			"experiencia=" + this.getExperiencia() + ", \n"
		;
	}

	/*
	@Override
	public String mostrarResumen() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.toString());
		sb.append("Agencia Turistica: ").append(this.getAgencia()).append("\n");
		return sb.toString();
	}
	*/

}