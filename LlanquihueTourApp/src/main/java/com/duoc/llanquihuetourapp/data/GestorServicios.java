package com.duoc.llanquihuetourapp.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.duoc.llanquihuetourapp.excepciones.FormatoArchivoInvalidoException;
import com.duoc.llanquihuetourapp.model.actores.Guia;
import com.duoc.llanquihuetourapp.model.actores.Rut;
import com.duoc.llanquihuetourapp.model.negocio.PaseoLacustre;
import com.duoc.llanquihuetourapp.model.negocio.RutaCultural;
import com.duoc.llanquihuetourapp.model.negocio.ServicioTuristico;
import com.duoc.llanquihuetourapp.model.negocio.TourGastronomico;

//import com.duoc.llanquihuetourapp.model.ExcursionCultural;
//import com.duoc.llanquihuetourapp.model.PaseoLacustre;
//import com.duoc.llanquihuetourapp.model.RutaGastronomica;
//import com.duoc.llanquihuetourapp.model.ServicioTuristico;

public class GestorServicios {

	private final int TOUR_GASTRONOMICO = 1;
	private final int RUTA_CULTURAL     = 2;
	private final int PASEO_LACUSTRE    = 3;

	private List<ServicioTuristico> servicios;

	public GestorServicios() {
		this.servicios = new ArrayList<>();
	}

	public List<ServicioTuristico> getServicios() {
		return servicios;
	}

	public void cargaToursGastronomicos(String pathGastronomicoTxt){
		pathGastronomicoTxt = "../../../../../../../resources/" + pathGastronomicoTxt;
		cargaDatosTxt( pathGastronomicoTxt, TOUR_GASTRONOMICO);
	}

	public void cargaToursCulturales(String pathCulturalTxt){
		pathCulturalTxt = "../../../../../../../resources/" + pathCulturalTxt;
		cargaDatosTxt( pathCulturalTxt, RUTA_CULTURAL);
	}

	public void cargaToursLacustres(String pathLacustreTxt){
		pathLacustreTxt = "../../../../../../../resources/" + pathLacustreTxt;
		cargaDatosTxt( pathLacustreTxt, PASEO_LACUSTRE);
	}

	/**
	 * * Lee archivo TXT determinado por el tipo de registro que se desea leer.
	 * @param fileName
	 * @param tipoRegistro
	 */
	private void cargaDatosTxt(String fileName, int tipoRegistro){
		try( BufferedReader reader = new BufferedReader(new FileReader(fileName)) ){

			String linea;

			while( (linea = reader.readLine())!=null ){

				try {

					String[] columnas = linea.split(";");

					if( tipoRegistro == TOUR_GASTRONOMICO ){
						TourGastronomico tour = new TourGastronomico(
							columnas[0],
							columnas[1],
							Integer.parseInt(columnas[2].trim()),
							Integer.parseInt(columnas[3].trim()),
							columnas[4]
						);
						this.servicios.add(tour);
					}

					if( tipoRegistro == RUTA_CULTURAL ){
						RutaCultural tour = new RutaCultural(
							columnas[0],
							columnas[1],
							Integer.parseInt(columnas[2].trim()),
							columnas[3]
						);
						this.servicios.add(tour);
					}

					if( tipoRegistro == PASEO_LACUSTRE ){
						PaseoLacustre tour = new PaseoLacustre(
							columnas[0],
							columnas[1],
							Integer.parseInt(columnas[2].trim()),
							columnas[3],
							columnas[4]
						);
						this.servicios.add(tour);
					}

				} catch (Exception e) {
					throw new FormatoArchivoInvalidoException(e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		} catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}


	/**
	 * Obtener servicio especifico según su nombre.
	 * @param nombreServicio String
	 * @return ServicioTuristico
	 */
	public ServicioTuristico getByNombre(String nombreServicio){
		for(ServicioTuristico servicio: this.servicios){
			if( servicio.getNombreServicio().trim().equals(nombreServicio.trim())){
				return servicio;
			}
		}
		return null;
	}


	/**
	 * Busca match en listado existente, para obtener registro de Guia Turistico, necesario para crear Objeto base de servicio.
	 * @param rutGuia
	 * @param guias
	 * @return
	 * @deprecated No utilizado.-
	 */
	@Deprecated
	public Guia buscaGuiaFromRut(String rutGuia, List<Guia> guias){
		try {
			for(Guia guia: guias){
				if( guia.getRut().getRut().trim().equals( rutGuia.trim())){
					return guia;
				}
			}
			return new Guia("","","","","",new Rut(rutGuia),"agencia","0");	
		} catch (Exception e) {
			System.err.print(e);
		}
		return null;
	}

	/*
	



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
*/
}