package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * Clase que sirve para guardar las variables ingresadas por el usuario
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class CandidatoDTO implements Serializable{
	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributo para crear el nombre
	 */
	private String nombre;
	/**
	 * atributo para crear el apellido
	 */
	private String apellido;
	/**
	 * atributo para crear la cedula
	 */
	private long cedula;
	/**
	 * atributo para crearla edad
	 */
	private int edad;
	/**
	 * atributo para crear el cargo
	 */
	private String cargo;
	/**
	 * Metodo constructor para inicializar las variables
	 * @param nombre String
	 * @param apellido String
	 * @param cedula long
	 * @param edad int
	 * @param cargo String
	 */
	public CandidatoDTO(String nombre, String apellido, long cedula, int edad, String cargo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.cargo = cargo;
	}
/**
 * Metodo para devolver un String
 * @return String
 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo para setear un String
	 * @param nombre String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo para devolver un String
	 * @return String
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Metodo para setear un String
	 * @param apellido String
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * Metodo para devolver un long
	 * @return long
	 */
	public long getCedula() {
		return cedula;
	}
	/**
	 * Metodo para setear un long
	 * @param cedula long
	 */
	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	/**
	 * Metodo para devolver un int
	 * @return int
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * Metodo para setear un int
	 * @param edad int
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * Metodo para devolver un String
	 * @return String
	 */
	public String getCargo() {
		return cargo;
	}
	/**
	 * Metodo para setear un String
	 * @param cargo String
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
