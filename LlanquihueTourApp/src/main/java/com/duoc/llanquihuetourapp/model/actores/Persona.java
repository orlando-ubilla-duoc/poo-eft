package com.duoc.llanquihuetourapp.model.actores;

/**
 * Clase abstracta Persona, representación básica de una entidad con atributos comunes como nombre, email, teléfono, dirección, ciudad y RUT.
 * Esta clase sirve como base para otras clases que representen tipos específicos de personas o entidades empresariales.
 * @author	Orlando Ubilla
 * @since	EFT
 */
public abstract class Persona {
	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
	private String direccion;
	private Rut rut;

	/**
	 * Constructor de la clase Persona.
	 * @param nombre El nombre de la persona.
	 * @param apellidos Los apellidos de la persona.
	 * @param email El correo electrónico de la persona.
	 * @param telefono El número de teléfono de la persona.
	 * @param direccion La dirección de la persona.
	 * @param rut El RUT de la persona.
	 */
	public Persona(String nombre, String apellidos, String email, String telefono, String direccion, Rut rut) {
		this.id        = 0;
		this.nombre    = nombre;
		this.apellidos = apellidos;
		this.email     = email;
		this.telefono  = telefono;
		this.direccion = direccion;
		this.rut       = rut;
	}

	public Persona() {
		this.nombre    = "Persona";
		this.apellidos = "";
		this.email     = "";
		this.telefono  = "000000000";
		this.direccion = "";
		this.rut       = new Rut();
	}

	public int getId() { return this.id;}

	public void setId(int rowId) { this.id = rowId;}

	public String getNombre() { return nombre;}

	public void setNombre(String nombre) { this.nombre = nombre;}

	public String getApellidos() { return apellidos;}

	public void setApellidos(String apellidos) { this.apellidos = apellidos;}

	public String getEmail() { return email;}

	public void setEmail(String email) { this.email = email;}

	public String getTelefono() { return telefono;}

	public void setTelefono(String telefono) { this.telefono = telefono;}

	public String getDireccion() { return direccion;}

	public void setDireccion(String direccion) { this.direccion = direccion;}

	public Rut getRut() { return rut;}

	public void setRut(Rut rut) { this.rut = rut;}

	public String toString() {
		return "["+this.getClass().getSimpleName() + "] : " +
			"nombre=" + this.getNombre() + ", \n" +
			"apellidos=" + this.getApellidos() + ", \n" +
			"email=" + this.getEmail() + ", \n" +
			"telefono=" + this.getTelefono() + ", \n" +
			"direccion=" + this.getDireccion() + ", \n" +
			"rut=" + this.getRut().getRut() + ", \n"
		;
	}

}