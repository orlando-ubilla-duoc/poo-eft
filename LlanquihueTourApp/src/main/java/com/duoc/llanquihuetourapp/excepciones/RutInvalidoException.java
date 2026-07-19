package com.duoc.llanquihuetourapp.excepciones;

/**
 * Excepción personalizada para indicar que un RUT no cumple el formato esperado.
 * @author  Orlando Oubilla
 * @version 1.0
 * @since   EFT
 */
public class RutInvalidoException extends Exception {

	public RutInvalidoException(String mensaje) {
		super("Formato de RUT inválido: " + mensaje);
	}

}