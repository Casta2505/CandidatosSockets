package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.CandidatoFile;

public class Fachada {
	private CandidatoDAO cdao;
	private CandidatoFile cf;
	public Fachada() {
		cdao = new CandidatoDAO();
		cf = new CandidatoFile();
	}
	public CandidatoDAO getCdao() {
		return cdao;
	}
	public void setCdao(CandidatoDAO cdao) {
		this.cdao = cdao;
	}
	public CandidatoFile getCf() {
		return cf;
	}
	public void setCf(CandidatoFile cf) {
		this.cf = cf;
	}
	
}
