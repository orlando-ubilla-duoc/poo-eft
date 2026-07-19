package com.duoc.llanquihuetourapp.model.negocio;

import com.duoc.llanquihuetourapp.model.actores.Guia;

/**
 * Clase Ruta-Cultural,
 * @author Orlando Ubilla
 * @since  EFT 
 */
public class RutaCultural extends ServicioTuristico {

	private String lugarHistorico;

	public RutaCultural( String nombreRuta, Guia guiaTuristico, int precio, String lugarVisita){
		super( nombreRuta, guiaTuristico, precio);
		this.lugarHistorico = lugarVisita;
	}

	public void setLugarHistorico(String lugar){
		this.lugarHistorico = lugar;
	}

	public String getLugarHistorico(){
		return this.lugarHistorico;
	}

}
