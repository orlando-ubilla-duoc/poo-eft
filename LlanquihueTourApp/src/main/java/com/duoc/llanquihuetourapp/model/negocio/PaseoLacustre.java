package com.duoc.llanquihuetourapp.model.negocio;

import com.duoc.llanquihuetourapp.model.actores.Guia;

/**
 * Clase Paseo-Lacustre,
 * @author Orlando Ubilla
 * @since  EFT
 */
public class PaseoLacustre extends ServicioTuristico {

	private String destinoLacustre;
	private String tipoEmbarcacion;

	public PaseoLacustre( String nombrePaseo, Guia guiaTuristico, int precio, String lago, String embarcacion){
		super( nombrePaseo, guiaTuristico, precio);
		this.destinoLacustre = lago;
		this.tipoEmbarcacion = embarcacion;
	}

	public String getDestinoLacustre() {
		return this.destinoLacustre;
	}

	public void setDestinoLacustre(String destino){
		this.destinoLacustre = destino;
	}

	public String getTipoEmbarcacion() {
		return this.tipoEmbarcacion;
	}

	public void setTipoEmbarcacion(String nave) {
		this.tipoEmbarcacion = nave;
	}

}
