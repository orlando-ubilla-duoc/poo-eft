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

	public List<Persona> getDatos(){
		return this.datos;
	}

	public void agregaRegistro(Persona p){
		this.datos.add(p);
		System.out.println("Registro agregado, nueva cantidad:"+this.datos.size());
	}

	public Persona getByRut(String strRut){
		for(Persona registro: this.datos){
			if( registro.getRut().getRut().trim().equals(strRut.trim())){
				return registro;
			}
		}
		return null;
	}

}