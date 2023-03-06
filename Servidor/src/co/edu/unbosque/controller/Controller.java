package co.edu.unbosque.controller;

import co.edu.unbosque.model.Fachada;
import co.edu.unbosque.model.persistence.CandidatoFile;

/**
 * Clase Controller que conecta y dirige a las demás clases y métodos
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class Controller{
	/**
	 * atributo para llamar la clase fachada
	 */
	private Fachada facha;
	/**
	 * atributo para llamar a la clase servidor
	 */
	private Servidor server;
	/**
	 * Metodo constructor
	 * 
	 */
	public Controller() {
		this.server = new Servidor(9000);
		this.server.start();
		funcionar();
		
	}
	/**
	 * Metodo funcionar, el cual se va a ejecutar automaticamente para darle visibilidad a las ventanas
	 */
	public void funcionar() {
		
	}
}
