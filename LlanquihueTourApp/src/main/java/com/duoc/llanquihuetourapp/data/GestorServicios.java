package com.duoc.llanquihuetourapp.data;

import java.util.ArrayList;
import java.util.List;

import com.duoc.llanquihuetourapp.model.ExcursionCultural;
import com.duoc.llanquihuetourapp.model.PaseoLacustre;
import com.duoc.llanquihuetourapp.model.RutaGastronomica;
import com.duoc.llanquihuetourapp.model.ServicioTuristico;

public class GestorServicios {

	private List<ServicioTuristico> servicios;

	public GestorServicios() {
		this.servicios = new ArrayList<>();
	}

	public void crearPaseoLacustre(String nombre,
                                          String ciudad,
                                          double precioServicio,
                                          int duracionHoras,
                                          String tipoBarco ){
		PaseoLacustre serv = new PaseoLacustre(nombre, ciudad, precioServicio, duracionHoras, tipoBarco);
		this.servicios.add(serv);
	}

	public void crearExcursionCultural(String nombre,
                          int duracionHoras,
                          String ciudad,
                          double precioServicio,
                          String lugarHistorico ){
		ExcursionCultural serv = new ExcursionCultural(nombre, duracionHoras, ciudad, precioServicio, lugarHistorico);
		this.servicios.add(serv);
	}

	public void crearRutaGastronomica(String nombre,
						  int duracionHoras,
						  String ciudad,
						  double precioServicio,
						  int numeroDeParadas ){
		RutaGastronomica serv = new RutaGastronomica(nombre, duracionHoras, ciudad, precioServicio, numeroDeParadas);
		this.servicios.add(serv);
	}

	public List<ServicioTuristico> getServicios() {
		return servicios;
	}

	public void muestraServicios() {

		// Loop para mostrar servicios
		for( ServicioTuristico servicio : servicios )
		{
			servicio.mostrarInformacion();
			System.out.println(" "); // linea en blanco para separar servicios
		}

	}

}