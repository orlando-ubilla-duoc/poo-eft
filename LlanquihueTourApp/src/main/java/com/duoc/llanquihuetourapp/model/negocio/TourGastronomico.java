package com.duoc.llanquihuetourapp.model.negocio;

import com.duoc.llanquihuetourapp.interfaces.Registrable;

/**
 * Clase Tour-Gastronomico,
 * @author Orlando Ubilla
 * @since  EFT
 */
public class TourGastronomico extends ServicioTuristico implements Registrable {

	private int numeroDeParadas;
	private String zonaTour;

	public TourGastronomico(String nombreTour, String rutGuiaTurismo, int precio, int paradas, String zona){
		super( nombreTour, rutGuiaTurismo, precio);
		this.numeroDeParadas = paradas;
		this.zonaTour        = zona;
	}

	public void serNroParadas(int numero){
		this.numeroDeParadas = numero;
	}

	public int getNroParadas(){
		return this.numeroDeParadas;
	}

	public void serZonaTour(String zona){
		this.zonaTour = zona;
	}

	public String getZonaTour(){
		return this.zonaTour;
	}

	@Override
	public void registrar(){
		//
	}

	@Override
	public void mostrarDatos(){
		StringBuilder sb = new StringBuilder();
		sb.append("[Datos Tour-Gastronomico]").append("\n");
		sb.append("Nombre Servicio: ").append(this.getNombreServicio()).append("\n");
		sb.append("Rut Guia Turistico: ").append(this.getGuiaTurismo()).append("\n");
		sb.append("Valor del Servicio: ").append((char)this.getPrecio()).append("\n");
		sb.append("Zona Gastronomica: ").append(this.getZonaTour()).append("\n");
		sb.append("Cant.puntos de la ruta: ").append((char) this.getNroParadas()).append("\n");
		System.out.print(sb.toString());
	}
}
