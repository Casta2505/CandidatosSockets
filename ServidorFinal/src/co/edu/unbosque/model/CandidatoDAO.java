package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * Clase que se encarga del CRUD del programa
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class CandidatoDAO {
	/**
	 * atributo para crear un arraylistdto
	 */
	private ArrayList<CandidatoDTO>candidato;
	/**
	 * Metodo constructor para inicializar las varibles
	 */
	public CandidatoDAO() {
		this.candidato= new ArrayList<>();
	}
	/**
	 * Metodo que nos permite agregar un candidato a un arraylist donde se encuentras los demás candidatos
	 * @param nombre String
	 * @param apellido String
	 * @param cedula long
	 * @param edad int
	 * @param cargo String
	 */
	public void agregarCandidato(String nombre, String apellido, long cedula, int edad, String cargo) {
		CandidatoDTO a = new CandidatoDTO(nombre,apellido,cedula,edad,cargo);
		candidato.add(a);
	}
	/**
	 * Metodo que sirve para eliminar un usuario del arraylist
	 * @param cedula long
	 * @param candidato ArraylistDTO
	 * @return retorna un booleano
	 */
	public boolean deleteUser(long cedula,ArrayList<CandidatoDTO>candidato) {
		boolean a = false;
		for(int i = 0; i<candidato.size();i++) {
			if(candidato.get(i).getCedula() == cedula) {
				candidato.remove(i);
				a = true;
			}
		}
		return a;
	}
	/**
	 * Metodo que sirve para mostrar de una forma mas ordenada la lista de candidatos
	 * @return retorna un string
	 */
	public String list() {
		StringBuilder sb = new StringBuilder();
		for(CandidatoDTO e : candidato) {
			sb.append(e.toString());
		}
		return sb.toString();
	}
	/**
	 * Metodo para retornar un objeto de tipo arraylist de tipo CandidatoDTO
	 * @return retorna un array
	 */
	public ArrayList<CandidatoDTO>getCandidato(){
		return candidato;
	}
	/**
	 * Metodo para setear un arraylist de tipo CandidatoDTO
	 * @param candidato arraylist
	 */
	public void setCandidato(ArrayList<CandidatoDTO>candidato) {
		this.candidato = candidato;
	}
	
}
