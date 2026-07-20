package com.duoc.llanquihuetourapp.model.negocio;

import com.duoc.llanquihuetourapp.interfaces.Registrable;

/**
 * Clase Paseo-Lacustre,
 * @author Orlando Ubilla
 * @since  EFT
 */
public class PaseoLacustre extends ServicioTuristico implements Registrable {

	private String destinoLacustre;
	private String tipoEmbarcacion;

	public PaseoLacustre( String nombrePaseo, String rutGuiaTurismo, int precio, String lago, String embarcacion){
		super( nombrePaseo, rutGuiaTurismo, precio);
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
		sb.append("Lago Destino: ").append(this.getDestinoLacustre()).append("\n");
		sb.append("Tipo de Embarcación: ").append(this.getTipoEmbarcacion()).append("\n");
		System.out.print(sb.toString());
	}

}
