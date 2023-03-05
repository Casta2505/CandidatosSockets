package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import co.edu.unbosque.view.View;
/**
 * Clase Controller que conecta y dirige a las demás clases y métodos
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class Controller implements ActionListener{
	/**
	 * atributo para crear la ventana principal
	 */
	private View gui;

	/**
	 * atributo para llamar la clase cliente
	 */
	private ConexionCliente cc;
	/**
	 * Metodo constructor para inicializar las variables
	 * 
	 */
	public Controller() {
		gui = new View(this);
		cc = new ConexionCliente("127.0.0.1", 9000);
		cc.start();
		gui.setVisible(true);
		funcionar();
		
	}
	/**
	 * Metodo funcionar, el cual se va a ejecutar automaticamente para darle visibilidad a las ventanas
	 */
	public void funcionar() {

		gui.getP1().setVisible(true);
		gui.getP2().setVisible(false);
		gui.getP3().setVisible(false);
		gui.getP4().setVisible(false);
	}
	/**
	 * Metodo para asignarle funciones a los eventos del programa
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(gui.getP1().ENVIAR)) {
			enviarCandidato();
		}else if (e.getActionCommand().equals(gui.getP1().BUSCAR)) {
			gui.getP1().setVisible(false);
			gui.getP2().setVisible(true);
			gui.getP3().setVisible(false);
			gui.getP4().setVisible(false);
		}else if(e.getActionCommand().equals(gui.getP1().MODIFICAR)) {
			gui.getP1().setVisible(false);
			gui.getP2().setVisible(false);
			gui.getP3().setVisible(true);
			gui.getP4().setVisible(false);
		}else if (e.getActionCommand().equals(gui.getP1().ELIMINAR)) {
			gui.getP1().setVisible(false);
			gui.getP2().setVisible(false);
			gui.getP3().setVisible(false);
			gui.getP4().setVisible(true);
		}
		if(e.getActionCommand().equals(gui.getP2().LISTA)) {
			limpiarP2();
			cc.setLine("Leer");
			try {
	            Thread.sleep(1000);
	          } catch (InterruptedException esto) {
	            esto.printStackTrace();
	          }
			gui.getP2().getListado().setText(cc.getGuardar());;
			
		}else if(e.getActionCommand().equals(gui.getP2().ATRAS)) {
			limpiarP2();
			volverInscripcion();
		}else if (e.getActionCommand().equals(gui.getP2().BUSCAR01)) {
			buscar();
		}
		
		if(e.getActionCommand().equals(gui.getP3().MODIFICAR01)) {
			modificarUsuario();
		}else if (e.getActionCommand().equals(gui.getP3().ATRAS)) {
			volverInscripcion();
			limpiarP3();
		}
		
		if(e.getActionCommand().equals(gui.getP4().ELIMINAR01)) {
			borrarUsuario();
			limpiarP4();
		}else if (e.getActionCommand().equals(gui.getP4().ATRAS)) {
			limpiarP4();
			volverInscripcion();
		}
		
	}
	/**
	 * Metodo para poner en blanco las casillas donde se escriben los datos del ususario
	 */
	public void limpiarP1() {
		this.gui.getP1().getTxnombre().setText("");
		this.gui.getP1().getTxapellido().setText("");
		this.gui.getP1().getTxcedula().setText("");
		this.gui.getP1().getTxedad().setText("");
		this.gui.getP1().getTxcargo().setText("");
	}
	/**
	 * Metodo para poner en blanco las casillas donde se busca un usuario
	 */
	public void limpiarP2() {
		this.gui.getP2().getNumcedula().setText("");
		this.gui.getP2().getListado().setText("");
	}
	/**
	 * Metodo para poner en blanco las casillas de modificar un usuario
	 */
	public void limpiarP3(){
		this.gui.getP3().getTxnombre().setText("");
		this.gui.getP3().getTxapellido().setText("");
		this.gui.getP3().getTxcedula().setText("");
		this.gui.getP3().getTxedad().setText("");
		this.gui.getP3().getTxcargo().setText("");	
	}
	/**
	 * Metodo para poner en blanco la casilla de cedula del ususario
	 */
	public void limpiarP4() {
		this.gui.getP4().getTxcedula().setText("");
	}
	/**
	 * Metodo para que cuando se oprima el botón de volver, se muestre la ventana principal
	 */
	public void volverInscripcion() {
		this.gui.getP1().setVisible(true);
		this.gui.getP2().setVisible(false);
		this.gui.getP3().setVisible(false);
		this.gui.getP4().setVisible(false);
		limpiarP1();
	}
	/**
	 * Metodo para establecer los datos ingresados por el usuario en la clase DAO
	 */
	public void enviarCandidato(){	
	
		String nombre = "";
		String apellido = "";
		long cedula = 0;
		int edad = 0;
		String cargo = "";
		
		nombre = this.gui.getP1().getTxnombre().getText();
		Pattern pattern = Pattern.compile("[A-Za-z ]+");
		Matcher matcher = pattern.matcher(nombre);
		if(!matcher.matches()) {
			this.gui.mostrar("Ingrese un nombre valido");
			return;
		}
		
		apellido = this.gui.getP1().getTxapellido().getText();
		Pattern pattern2 = Pattern.compile("[A-Za-z ]+");
		Matcher matcher2 = pattern2.matcher(apellido);
		if(!matcher2.matches()) {
			this.gui.mostrar("Ingrese un apellido valido");
			return;
		}
		
		cargo = this.gui.getP1().getTxcargo().getText();
		Pattern pattern3 = Pattern.compile("[A-Za-z ]+");
		Matcher matcher3 = pattern3.matcher(cargo);
		if(!matcher3.matches()) {
			this.gui.mostrar("Ingrese un cargo valido");
			return;
		}
		
		try {
	    	cedula = Long.parseLong(this.gui.getP1().getTxcedula().getText());
	    	if(cedula <= 100000) {
	    		this.gui.mostrar("Ingrese una cedula valida");
	    		return;
	    	}
		} catch (Exception e) {
			this.gui.mostrar("Ingrese una cedula valida");
			return;
		}
	    
	    try {
	    	edad = Integer.parseInt(this.gui.getP1().getTxedad().getText());
	    	if(edad >= 110 || edad <= 0) {
	    		this.gui.mostrar("Ingrese una edad valida");
	    		return;
	    	}
		} catch (Exception e) {
			this.gui.mostrar("Ingrese una edad valida");
			return;
		}
	    String enviar_datos = nombre.toUpperCase()+";"+apellido.toUpperCase()+";"+cedula+";"+edad+";"+cargo.toUpperCase();
	    this.cc.setLine(enviar_datos);
		
	}
	/**
	 * Metodo para hacer una busqueda y comprobación en el array que contiene a los candidatos
	 */
	private void buscar() {
		long cedula = 0;
		try {
			cedula = Long.parseLong(this.gui.getP2().getNumcedula().getText());
		}catch(Exception e) {
			this.gui.mostrar("Por favor ingrese una cedula valida");
			return;
		}
		this.cc.setLine("Buscar"+";"+cedula);
		try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
		this.gui.getP2().getListado().setText(this.cc.getGuardar());
	}
	/**
	 * Metodo para eliminar un usuario del arraylist con su cedula
	 */
	public void borrarUsuario() {
		long cedula = 0;
		try {
			cedula = Long.parseLong(this.gui.getP4().getTxcedula().getText());
		}catch(Exception e) {
			this.gui.mostrar("Por favor ingrese una cedula valida");
			return;
		}
		this.cc.setLine("Borrar"+";"+cedula);
	}
	/**
	 * Metodo para modificar los valores de un usuario ya existente
	 */
	public void modificarUsuario() {
		long cedula=0;
		try {
			cedula = Long.parseLong(this.gui.getP3().getTxcedula().getText());
		}catch(Exception e) {
			this.gui.mostrar("Por favor ingrese una cedula valida");
			return;
		}
			String nombre = "";
			String apellido = "";
			int edad = 0;
			String cargo = "";
			
			nombre = this.gui.getP3().getTxnombre().getText();
			Pattern pattern = Pattern.compile("[A-Za-z ]+");
			Matcher matcher = pattern.matcher(nombre);
			if(!matcher.matches()) {
				this.gui.mostrar("Ingrese un nombre valido");
				return;
			}
			
			apellido = this.gui.getP3().getTxapellido().getText();
			Pattern pattern2 = Pattern.compile("[A-Za-z ]+");
			Matcher matcher2 = pattern2.matcher(apellido);
			if(!matcher2.matches()) {
				this.gui.mostrar("Ingrese un apellido valido");
				return;
			}
			
			cargo = this.gui.getP3().getTxcargo().getText();
			Pattern pattern3 = Pattern.compile("[A-Za-z ]+");
			Matcher matcher3 = pattern3.matcher(cargo);
			if(!matcher3.matches()) {
				this.gui.mostrar("Ingrese un cargo valido");
				return;
			}
		    
		    try {
		    	edad = Integer.parseInt(this.gui.getP3().getTxedad().getText());
		    	if(edad >= 110 || edad <= 0) {
		    		this.gui.mostrar("Ingrese una edad valida");
		    		return;
		    	}
			} catch (Exception e) {
				this.gui.mostrar("Ingrese una edad valida");
				return;
			}
		    String enviar_datos = nombre.toUpperCase()+";"+apellido.toUpperCase()+";"+cedula+";"+edad+";"+cargo.toUpperCase();
			this.cc.setLine(cedula+"-"+enviar_datos);
		}
	/**
	 * Metodo que usa como parametro la cedula y con esta hace una busqueda en todo el array
	 * @param cedula long
	 * @return nos devuelve un valor "booleano"
	 */
}
