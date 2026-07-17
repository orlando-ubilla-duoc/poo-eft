package com.duoc.llanquihuetourapp.model;

/**
 * Clase Base que representa un servicio turístico.
 */
public class ServicioTuristico {

	private String nombre;
	private String ciudad;
	private int duracionHoras;
	private double precioServicio;

	/**
	 * Constructor que recibe los datos basicos del servicio
	 * @param nombre El nombre del servicio.
	 * @param duracionHoras La duración del servicio turístico en horas.
	 * @param ciudad La ciudad donde se ofrece el servicio.
	 * @param precioServicio El precio del servicio turístico.
	 */
	public ServicioTuristico(String nombre, int duracionHoras, String ciudad, double precioServicio) {
		this.nombre   = nombre;
		this.duracionHoras = duracionHoras;
		this.ciudad = ciudad;
		this.precioServicio = precioServicio;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracionHoras() {
		return duracionHoras;
	}
	public void setDuracionHoras(int duracionHoras) {
		this.duracionHoras = duracionHoras;
	}

	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public double getPrecioServicio() {
		return precioServicio;
	}
	public void setPrecioServicio(double precioServicio) {
		this.precioServicio = precioServicio;
	}

	public void mostrarInformacion() {
		System.out.println("=== INFORMACIÓN DEL SERVICIO TURÍSTICO ===");
		System.out.println("Nombre del servicio: " + nombre);
		System.out.println("Duración: " + duracionHoras + " horas");
		System.out.println("Ciudad: " + ciudad);
		System.out.println("Precio del servicio: $" + precioServicio);
	}

	@Override
	public String toString() {
		return "ServicioTuristico{" +
				"nombre servicio=" + nombre + '\n' +
				", duracion=" + duracionHoras + '\n' +
				", ciudad=" + ciudad + '\n' +
				", precio-servicio=" + precioServicio + '\n' +
		'}';
	}

}