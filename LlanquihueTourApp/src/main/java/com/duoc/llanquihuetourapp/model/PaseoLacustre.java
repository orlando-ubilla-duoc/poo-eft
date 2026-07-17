package com.duoc.llanquihuetourapp.model;

public class PaseoLacustre extends ServicioTuristico {

	private String tipoEmbarcacion;

	public PaseoLacustre(String nombreTour, String ubicacion, double precio, int duracion, String tipoEmbarcacion) {
		super(nombreTour, duracion, ubicacion, precio);
		this.tipoEmbarcacion = tipoEmbarcacion;
	}
	public String getTipoEmbarcacion() {
		return tipoEmbarcacion;
	}
	public void setTipoEmbarcacion(String tipoEmbarcacion) {
		this.tipoEmbarcacion = tipoEmbarcacion;
	}

	@Override
	public void mostrarInformacion(){
		System.out.println("=== INFORMACIÓN DEL SERVICIO PASEO LACUSTRE ===");
		System.out.println("Nombre del servicio: " + this.getNombre());
		System.out.println("Duración: " + this.getDuracionHoras() + " horas");
		System.out.println("Ciudad: " + this.getCiudad());
		System.out.println("Precio del servicio: $" + this.getPrecioServicio());
		System.out.println("Tipo de embarcación: " + this.getTipoEmbarcacion());
	}

	/**
	 * Redefine metodo para imprimir clase.
	 */
	@Override
	public String toString() {
		return "PaseoLacustre {" +
			"nombre=" + getNombre() + '\n' +
			", duracion=" + getDuracionHoras() + '\n' +
			", ciudad=" + getCiudad() + '\n' +
			", precio-servicio=" + getPrecioServicio() + '\n' +
			", tipo-embarcacion=" + getTipoEmbarcacion() + '\n' +
		'}';
	}

}