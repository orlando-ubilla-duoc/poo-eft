package com.duoc.llanquihuetourapp.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.duoc.llanquihuetourapp.excepciones.FormatoArchivoInvalidoException;
import com.duoc.llanquihuetourapp.model.Tour;

public class GestorDatos {

/*
Lea el archivo línea por línea
Separe los datos con .split(";")
Cree objetos con estos datos
Los almacene en un ArrayList
*/
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

}