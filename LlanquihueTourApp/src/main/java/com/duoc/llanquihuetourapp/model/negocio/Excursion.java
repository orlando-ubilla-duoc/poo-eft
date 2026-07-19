package com.duoc.llanquihuetourapp.model.negocio;

import com.duoc.llanquihuetourapp.model.actores.Guia;

/**
 * Clase Excursion, representa un servicio turistico de Excursion Personalizada.
 * @author Orlando Ubilla
 * @since  EFT 
 */
public class Excursion extends ServicioTuristico {

	private Double longitudTramoKm;

	public Excursion(String nombreExcursion, Guia guiaTurismo, int precio, Double distancia){
		super( nombreExcursion, guiaTurismo, precio);
		this.longitudTramoKm = distancia;
	}

	public Double getTramoKms() {
		return this.longitudTramoKm;
	}

	public void setTramoKms(Double distanciaKm) {
		this.longitudTramoKm = distanciaKm;
	}

}
