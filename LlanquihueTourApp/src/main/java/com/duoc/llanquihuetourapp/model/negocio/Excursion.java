package com.duoc.llanquihuetourapp.model.negocio;

import com.duoc.llanquihuetourapp.interfaces.Registrable;

/**
 * Clase Excursion, representa un servicio turistico de Excursion Personalizada.
 * @author Orlando Ubilla
 * @since  EFT 
 */
public class Excursion extends ServicioTuristico implements Registrable {

	private Double longitudTramoKm;

	public Excursion(String nombreExcursion, String rutGuiaTurismo, int precio, Double distancia){
		super( nombreExcursion, rutGuiaTurismo, precio);
		this.longitudTramoKm = distancia;
	}

	public Double getTramoKms() {
		return this.longitudTramoKm;
	}

	public void setTramoKms(Double distanciaKm) {
		this.longitudTramoKm = distanciaKm;
	}

	@Override
	public void registrar(){
		//
	}

	@Override
	public void mostrarDatos(){
		StringBuilder sb = new StringBuilder();
		sb.append("[Datos Paseo-Lacustre]").append("\n");
		sb.append("Nombre Servicio: ").append(this.getNombreServicio()).append("\n");
		sb.append("Rut Guia Turistico: ").append(this.getGuiaTurismo()).append("\n");
		sb.append("Valor del Servicio: ").append((char)this.getPrecio()).append("\n");
		sb.append("Kilometros de tramo: ").append(this.getTramoKms()).append("\n");
		System.out.print(sb.toString());
	}

}
