package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.CandidatoFile;
/**
 * Clase para conectar los paquetes del model con el controller
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class Facha {
	/**
	 * atributo para crear la clase candidatoDAO
	 */
	private CandidatoDAO cdao;
	/**
	 * atributo para crear la clase candidatofile
	 */
	private CandidatoFile cf;
	/**
	 * Metodo constructor para inicializar las variables
	 */
	public Facha() {
		this.cdao = new CandidatoDAO();
		this.cf = new CandidatoFile();
	}
	/**
	 * Metodo para retornar un dato de tipo CandidatoDAO
	 * @return CandidatoDAO
	 */
	public CandidatoDAO getCdao() {
		return cdao;
	}
	/**
	 * Metodo para setear un dato de tipo CandidatoDAO
	 * @param cdao candidatoDTO
	 */
	public void setCdao(CandidatoDAO cdao) {
		this.cdao = cdao;
	}
	/**
	 * Metodo para retornar un dato de tipo CandidatoFile
	 * @return CandidatoFile
	 */
	public CandidatoFile getCf() {
		return cf;
	}
	/**
	 * Metodo para setear un dato de tipo CandidatoFile
	 * @param cf Candidatofile
	 */
	public void setCf(CandidatoFile cf) {
		this.cf = cf;
	}
	
}
