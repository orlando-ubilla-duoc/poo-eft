package com.duoc.llanquihuetourapp.model;

/**
 * Clase que representa a un colaborador externo, que hereda de la clase Persona y implementa la interfaz Registrable.
 * Contiene información adicional sobre la empresa y el giro comercial del colaborador externo.
 * @author	Orlando Ubilla
 * @since	Sumativa-3
 */
public class ColaboradorExterno extends Persona implements Registrable {

	private String nombreEmpresa;
	private String giroComercial;

	public ColaboradorExterno(String nombre, String email, String telefono, String direccion, Rut rut, String empresa, String giro) {
		super(nombre, email, telefono, direccion, rut);
		this.nombreEmpresa = empresa;
		this.giroComercial = giro;
	}

	public String getEmpresa() { return this.nombreEmpresa;}

	public void setEmpresa(String empresa) { this.nombreEmpresa = empresa;}

	public String getGiro() { return this.giroComercial;}

	public void setGiro(String giro) { this.giroComercial = giro;}

	@Override
	public String mostrarResumen() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.toString());
		sb.append("Empresa: ").append(this.getEmpresa()).append("\n");
		sb.append("Giro Comercial: ").append(this.getGiro()).append("\n");
		return sb.toString();
	}
}