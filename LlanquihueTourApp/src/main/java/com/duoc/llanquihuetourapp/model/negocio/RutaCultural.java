package com.duoc.llanquihuetourapp.model.negocio;

import com.duoc.llanquihuetourapp.interfaces.Registrable;

/**
 * Clase Ruta-Cultural,
 * @author Orlando Ubilla
 * @since  EFT 
 */
public class RutaCultural extends ServicioTuristico implements Registrable {

	private String lugarHistorico;

	public RutaCultural( String nombreRuta, String rutGuiaTurismo, int precio, String lugarVisita){
		super( nombreRuta, rutGuiaTurismo, precio);
		this.lugarHistorico = lugarVisita;
	}

	public void setLugarHistorico(String lugar){
		this.lugarHistorico = lugar;
	}

	public String getLugarHistorico(){
		return this.lugarHistorico;
	}

	@Override
	public void registrar(){
		//
	}

	@Override
	public void mostrarDatos(){
		StringBuilder sb = new StringBuilder();
		sb.append("[Datos Ruta-Cultural]").append("\n");
		sb.append("Nombre Servicio: ").append(this.getNombreServicio()).append("\n");
		sb.append("Rut Guia Turistico: ").append(this.getGuiaTurismo()).append("\n");
		sb.append("Valor del Servicio: ").append((char)this.getPrecio()).append("\n");
		sb.append("Lugar Historico: ").append(this.getLugarHistorico()).append("\n");
		System.out.print(sb.toString());
	}

}
