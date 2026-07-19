package com.duoc.llanquihuetourapp.model.negocio;

import com.duoc.llanquihuetourapp.model.actores.Guia;

/**
 * Clase Tour-Gastronomico,
 * @author Orlando Ubilla
 * @since  EFT
 */
public class TourGastronomico extends ServicioTuristico {

	private int numeroDeParadas;

	public TourGastronomico(String nombreTour, Guia guiaTurismo, int precio, int paradas){
		super( nombreTour, guiaTurismo, precio);
		this.numeroDeParadas = paradas;
	}

	public void serNroParadas(int numero){
		this.numeroDeParadas = numero;
	}

	public int getNroParadas(){
		return this.numeroDeParadas;
	}

}
