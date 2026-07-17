package com.duoc.llanquihuetourapp.model;

/**
 * Clase que representa un vehículo, con atributos como marca, modelo, patente, color, año, kilometraje y un conductor responsable.
 * Implementa la interfaz Registrable para permitir mostrar un resumen de la información del vehículo.
 * @author	Orlando Ubilla
 * @since	Sumativa-3
 */
public class Vehiculo implements Registrable {

	private String marca;
	private String modelo;
	private String patente;
	private String color;
	private int annio;
	private int kilometros;
	private Conductor responsable;

	public Vehiculo(){
		this.marca   = "";
		this.modelo  = "";
		this.patente = "";
		this.color   = "";
		this.annio   = 0;
		this.kilometros = 0;
		this.responsable = null;
	}

	public Vehiculo(String marca, String modelo, String patente, String color, int annio, int km, Conductor reponsable) {
		this.marca   = marca;
		this.modelo  = modelo;
		this.patente = patente;
		this.color   = color;
		this.annio   = annio;
		this.kilometros = km;
		this.responsable = reponsable;
	}

	public String getMarca() { return this.marca;}
	public void setMarca(String m) { this.marca = m;}

	public String getModelo() { return this.modelo;}
	public void setModelo(String m) { this.modelo = m;}

	public String getPatente() { return this.patente;}
	public void setPatente(String p) { this.patente = p;}

	public String getColor() { return this.color;}
	public void setColor(String c) { this.color = c;}

	public int getAnnio() { return this.annio;}
	public void setAnnio(int a) { this.annio = a;}

	public int getKms() { return this.kilometros;}
	public void setKms(int k) { this.kilometros = k;}

	public Conductor getResponsable() { return this.responsable;}
	public void setResponsable(Conductor r) { this.responsable = r;}


	@Override
	public String mostrarResumen() {
		StringBuilder sb = new StringBuilder();
		sb.append("Marca: ").append(this.getMarca()).append("\n");
		sb.append("Modelo: ").append(this.getModelo()).append("\n");
		sb.append("Patente: ").append(this.getPatente()).append("\n");
		sb.append("Color: ").append(this.getColor()).append("\n");
		sb.append("Año: ").append(this.getAnnio()).append("\n");
		sb.append("Kilometraje: ").append(this.getKms()).append("Kms \n");
		sb.append("Persona responsable: ").append(this.getResponsable().getNombre()).append("(RUT:").append(this.getResponsable().getRut().getRut()).append(") \n");

		return sb.toString();
	}
}