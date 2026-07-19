package com.duoc.llanquihuetourapp.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.duoc.llanquihuetourapp.excepciones.FormatoArchivoInvalidoException;
import com.duoc.llanquihuetourapp.model.actores.Cliente;
import com.duoc.llanquihuetourapp.model.actores.Guia;
import com.duoc.llanquihuetourapp.model.actores.Persona;
import com.duoc.llanquihuetourapp.model.actores.Proveedor;

//import com.duoc.llanquihuetourapp.excepciones.FormatoArchivoInvalidoException;
//import com.duoc.llanquihuetourapp.model.Tour;

public class GestorDatos {

	private final int CLIENTE   = 1;
	private final int GUIA_TUR  = 2;
	private final int PROVEEDOR = 3;
	private List<Persona> datos;

	public GestorDatos(){
		this.datos = new ArrayList<>();
	}

	public void cargaClientes(String pathClientesTxt){
		pathClientesTxt = "../../../../../../../resources/" + pathClientesTxt;
		cargaDatosTxt( pathClientesTxt, CLIENTE);
	}

	public void cargaGuias(String pathGuiasTxt){
		pathGuiasTxt = "../../../../../../../resources/" + pathGuiasTxt;
		cargaDatosTxt( pathGuiasTxt, GUIA_TUR);
	}

	public void cargaProveedores(String pathProveedoresTxt){
		pathProveedoresTxt = "../../../../../../../resources/" + pathProveedoresTxt;
		cargaDatosTxt( pathProveedoresTxt, PROVEEDOR);
	}

	private void cargaDatosTxt(String fileName, int tipoRegistro){
		try( BufferedReader reader = new BufferedReader(new FileReader(fileName)) ){
			String linea;
			while( (linea = reader.readLine())!=null ){
				try {
					String[] columnas = linea.split(";");
					Persona registro  = null;
					if( tipoRegistro == CLIENTE ){
						registro = new Cliente(columnas);
					}
					if( tipoRegistro == GUIA_TUR ){
						registro = new Guia(columnas);
					}
					if( tipoRegistro == PROVEEDOR ){
						registro = new Proveedor(columnas);
					}

					if( registro!=null ) this.datos.add(registro);

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

	/*
Lea el archivo línea por línea
Separe los datos con .split(";")
Cree objetos con estos datos
Los almacene en un ArrayList
*/
/*
	private List<Tour> tours = new ArrayList<>();

	public GestorDatos() {
		// Constructor vacío
	}

	public void cargarTxt(String fileName){
		try( BufferedReader reader = new BufferedReader(new FileReader(fileName)) ){
			String linea;
			while( (linea = reader.readLine())!=null ){
				try {
					String[] columnas = linea.split(";");
					Tour tour = new Tour( columnas[0], columnas[1], Double.parseDouble(columnas[2]) );
					tours.add(tour);
				} catch (Exception e) {
					throw new FormatoArchivoInvalidoException("El formato del archivo es inválido. Asegúrese de que cada línea tenga el formato: nombreTour;ubicacion;precio");
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		} catch(Exception e){
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void mostrarTours(){
		for(Tour tour : tours){
			System.out.println("Nombre tour: " + tour.getNombreTour() + ", Ubicación: " + tour.getUbicacion() + ", Precio: $" + tour.getPrecio());
		}
	}

	public void mostrarToursFiltrados(double precioMinimo){
		for(Tour tour : tours){
			if(tour.getPrecio() >= precioMinimo){
				System.out.println("Nombre tour: " + tour.getNombreTour() + ", Ubicación: " + tour.getUbicacion() + ", Precio: $" + tour.getPrecio());
			}
		}
	}
*/
}