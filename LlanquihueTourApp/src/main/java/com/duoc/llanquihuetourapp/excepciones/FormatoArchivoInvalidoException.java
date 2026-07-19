package com.duoc.llanquihuetourapp.excepciones;

/**
 * Excepción personalizada para indicar que un archivo tiene un formato inválido.
 * @author  Orlando Oubilla
 * @version 1.0
 * @since   EFT
 */
public class FormatoArchivoInvalidoException extends Exception {

	public FormatoArchivoInvalidoException(String mensaje) {
		super("Error de formato de archivo:" + mensaje);
	}

}
