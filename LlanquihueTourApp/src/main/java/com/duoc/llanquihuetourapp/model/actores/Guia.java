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

	/**
	 * Crea objeto Guia desde String array.
	 * @param cols[0]	nombre
	 * @param cols[1]	apellidos
	 * @param cols[2]	e-mail
	 * @param cols[3]	telefono
	 * @param cols[4]	direccion
	 * @param cols[5]	rut + dv
	 * @param cols[6]	nombre-agencia
	 * @param cols[7]	...
	 * @throws Exception
	 */
	public Guia(String[] cols) throws Exception {
		super( cols[0], cols[1], cols[2], cols[3], cols[4], new Rut(cols[5]));
		this.nombreAgencia = cols[6];
		this.experiencia   = cols[7];
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