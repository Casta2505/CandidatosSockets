package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.CandidatoDTO;
/**
 * Metodo que crear y lee el archivo que contiene los datos de los candidatos
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class CandidatoFile {
	/**
	 * atributo para especificar la ruta de almacenamiento del archivo
	 */
	private String ruta = "data/registro.out";
	/**
	 * atributo para crear un dato tipo file
	 */
	private File f;
	/**
	 * atributo para crear un dato tipo fileoutputstrean
	 */
	private FileOutputStream fos;
	/**
	 * atributo para crear un dato tipo ObjectOutputStream
	 */
	private ObjectOutputStream oos;
	/**
	 * atributo para crear un dato tipo FileInputStream
	 */
	private FileInputStream fis;
	/**
	 * atributo para crear un dato tipo ObjectInputStream
	 */
	private ObjectInputStream ois;
	/**
	 * atributo para crear un dato tipo String
	 */
	private String mj;
	/**
	 * atributo para crear un dato tipo ArrayListDTO
	 */
	private ArrayList<CandidatoDTO>dato;
	/**
	 * Metodo Constructor para inicializar las variables
	 */
	public CandidatoFile() {
		dato = new ArrayList<>();
		f = new File(ruta);
	}
	/**
	 * Metodo que sirve para enviarle datos a el archivo de tipo ArraylistCandidatosDTO y nos retorna un booleano
	 * @param candidato arraylist
	 * @return retorna un booleano
	 */
	public boolean escribirCandidato(ArrayList<CandidatoDTO>candidato) {
		boolean a = true;
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			for (int i = 0; i<candidato.size();i++) {
				oos.writeObject(candidato);
			}
			oos.close();
		}catch (FileNotFoundException e) {
			a = false;
		}catch (Exception e) {
			a = false;
		}
		return a;
	}
	/**
	 * Metodo para leer el archivo y nos retorna el contenido en un String
	 * @return String
	 */
	public String leerCandidatos() {
		mj = "";
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			dato = (ArrayList<CandidatoDTO>)ois.readObject();
			for (int i = 0; i<dato.size();i++) {
				mj += "\n"+"Nombre: "+dato.get(i).getNombre()+"\n";
				mj += "Apellido: "+dato.get(i).getApellido()+"\n";
				mj += "Cedula: "+dato.get(i).getCedula()+"\n";
				mj += "Edad: "+dato.get(i).getEdad()+"\n";
				mj += "Cargo: "+dato.get(i).getCargo();
			}
			ois.close();
		} catch (Exception e) {
			escribirCandidato(dato);
		}
		return mj;
	}
	/**
	 * Metodo secundario para leer el archivo pero que no retorna
	 * @return String
	 */
	public String leerCandidatoEspe() {
		mj = "";
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			dato = (ArrayList<CandidatoDTO>)ois.readObject();
		
			ois.close();
		}catch(Exception e ) {
			escribirCandidato(dato);
		}
		return mj;
	}
	/**
	 * Metodo para retornar un Array de tipo CandidatoDTO
	 * @return ArraylistDTO
	 */
	public ArrayList<CandidatoDTO>getDato(){
		return dato;
	}
	/**
	 * Metodo para setear un dato de tipo CandidatoDTO
	 * @param dato arraylsit
	 */
	public void setDato(ArrayList<CandidatoDTO>dato) {
		this.dato = dato;
	}
	
}
