package com.duoc.llanquihuetourapp.model;

/**
 *
 * @author	Orlando Ubilla
 * @since	Sumativa-3
 */
public class GuiaTuristico extends Persona implements Registrable {

	private String nombreAgencia;

	public GuiaTuristico(String nombre, String email, String telefono, String direccion, Rut rut, String agencia) {
		super(nombre, email, telefono, direccion, rut);
		this.nombreAgencia = agencia;
	}

	public String getAgencia() { return nombreAgencia;}

	public void setAgencia(String dato) { this.nombreAgencia = dato;}

	@Override
	public String mostrarResumen() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.toString());
		sb.append("Agencia Turistica: ").append(this.getAgencia()).append("\n");
		return sb.toString();
	}

}