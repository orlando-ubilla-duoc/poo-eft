package com.duoc.llanquihuetourapp.model;

public class ExcursionCultural extends ServicioTuristico {

	private String lugarHistorico;

	public ExcursionCultural(String nombre, int duracionHoras, String ciudad, double precioServicio, String lugarHistorico) {
		super(nombre, duracionHoras, ciudad, precioServicio);
		this.lugarHistorico = lugarHistorico;
	}

	public String getLugarHistorico(){
		return lugarHistorico;
	}
	public void setLugarHistorico(String lugarHistorico) {
		this.lugarHistorico = lugarHistorico;
	}

	@Override
	public void mostrarInformacion(){
		System.out.println("=== INFORMACIÓN DEL SERVICIO EXCURSIÓN ===");
		System.out.println("Nombre del servicio: " + this.getNombre());
		System.out.println("Duración: " + this.getDuracionHoras() + " horas");
		System.out.println("Ciudad: " + this.getCiudad());
		System.out.println("Precio del servicio: $" + this.getPrecioServicio());
		System.out.println("Lugar histórico: " + this.getLugarHistorico());
	}

	/**
	 * Redefine metodo para imprimir clase.
	 */
	@Override
	public String toString() {
		return "ExcursionCultural {" +
				"nombre excursion=" + getNombre() + '\n' +
				", duracion=" + getDuracionHoras() + '\n' +
				", ciudad=" + getCiudad() + '\n' +
				", precio-servicio=" + getPrecioServicio() + '\n' +
				", lugar-historico=" + getLugarHistorico() + '\n' +
			'}';
	}
}