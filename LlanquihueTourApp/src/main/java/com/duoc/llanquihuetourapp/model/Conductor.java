package com.duoc.llanquihuetourapp.model;

/**
 * Clase que representa a un conductor, que hereda de la clase Persona.
 * Contiene información adicional sobre la licencia de conducir del conductor.
 * @author	Orlando Ubilla
 * @since	Sumativa-3
 */
public class Conductor extends Persona {

	private String licenciaConducir;

	public Conductor(String nombre, String telefono, String direccion, Rut rut, String licencia) {
		super( nombre, "", telefono, direccion, rut);
		this.licenciaConducir = licencia;
	}

	public String getLicencia() { return this.licenciaConducir;}
	public void setLicencia(String licencia) { this.licenciaConducir = licencia;}

}