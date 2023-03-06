package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
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
public class Controller extends Thread implements ActionListener{
	/**
	 * atributo para crear la ventana principal
	 */
	private View gui;

	/**
	 * atributo para llamar la clase cliente
	 */
	private Socket socket;
    private ServerSocket server; 
    private ObjectOutputStream out;
    private DataInputStream in; //Input stream from server
    private String address, line, recibido, guardar;
    private int port;
    private Controller c;
	/**
	 * Metodo constructor para inicializar las variables
	 * 
	 */
	public Controller(String address, int port) {
		this.socket= null;
        this.server=null;
        this.out= null;
        this.address=address;
        this.port=port;
        this.line = "";
        this.recibido = "";
        this.guardar = "";
		this.gui = new View(this);
		this.gui.setVisible(true);
		funcionar();
		
	}
public void run() {
    	
    	// string to read message from input 
        this.line = ""; 
  
    	// keep reading until "Over" is input 
        while (!this.line.equals("Over")) 
        { 
        	 // establish a connection 
        	try
            { 
        		this.recibido = "";
        		this.socket = new Socket(this.address, this.port); 
                System.out.println("Connected"); 
            
                // sends output to the socket 
                this.out = new ObjectOutputStream(socket.getOutputStream()); 
                while(this.line.equals("")) {
                	try {
                        Thread.sleep(100);
                      } catch (InterruptedException e) {
                        e.printStackTrace();
                      }
                }
                this.out.writeUTF(this.line);
                this.line = "";
                //close socket and output stream
                this.out.close(); 
                this.socket.close(); 
                //Create a serverSocket to wait message from server
                this.server = new ServerSocket(this.port+1);
    	        this.socket = server.accept(); 
    	        System.out.println("Received message: "); 
    	        // takes input from the client socket 
    	        this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                //Print in server the client message
    	        this.recibido = in.readUTF();
    	        generarAvisos(this.recibido);
    	        this.guardar = this.recibido;
                this.in.close();
                this.server.close();
            } 
            catch(IOException i) 
            { 
            	System.err.print("Closing conecttion");
                System.out.println(i); 
            } 
        } 
        // close the connection 
        try
        { 
        	this.out.close(); 
        	this.socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    	
    }
	/**
	 * Metodo funcionar, el cual se va a ejecutar automaticamente para darle visibilidad a las ventanas
	 */
	public void funcionar() {

		this.gui.getP1().setVisible(true);
		this.gui.getP2().setVisible(false);
		this.gui.getP3().setVisible(false);
		this.gui.getP4().setVisible(false);
		
	}
	/**
	 * Metodo para asignarle funciones a los eventos del programa
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(gui.getP1().ENVIAR)) {
			enviarCandidato();
			this.guardar = "";
			limpiarP1();
		}else if (e.getActionCommand().equals(gui.getP1().BUSCAR)) {
			this.gui.getP1().setVisible(false);
			this.gui.getP2().setVisible(true);
			this.gui.getP3().setVisible(false);
			this.gui.getP4().setVisible(false);
			this.guardar = "";
		}else if(e.getActionCommand().equals(gui.getP1().MODIFICAR)) {
			this.gui.getP1().setVisible(false);
			this.gui.getP2().setVisible(false);
			this.gui.getP3().setVisible(true);
			this.gui.getP4().setVisible(false);
			this.guardar = "";
		}else if (e.getActionCommand().equals(gui.getP1().ELIMINAR)) {
			this.gui.getP1().setVisible(false);
			this.gui.getP2().setVisible(false);
			this.gui.getP3().setVisible(false);
			this.gui.getP4().setVisible(true);
			this.guardar = "";
		}
		if(e.getActionCommand().equals(gui.getP2().LISTA)) {
			limpiarP2();
			this.line = "Leer";
			while(this.guardar.equals("")) {
				try {
                    Thread.sleep(100);
                  } catch (InterruptedException apanasio) {
                    apanasio.printStackTrace();
                  }
			}
			this.gui.getP2().getListado().setText(this.guardar);
			while(this.gui.getP2().getListado().getText().equals("")) {
				this.gui.mostrar("Espere a que cargue profesor");
			}
			this.guardar = "";
			
		}else if(e.getActionCommand().equals(gui.getP2().ATRAS)) {
			limpiarP2();
			volverInscripcion();
			this.guardar = "";
		}else if (e.getActionCommand().equals(gui.getP2().BUSCAR01)) {
			buscar();
			this.guardar = "";
		}
		
		if(e.getActionCommand().equals(gui.getP3().MODIFICAR01)) {
			modificarUsuario();
			this.gui.mostrar(this.guardar);
			this.guardar = "";
		}else if (e.getActionCommand().equals(gui.getP3().ATRAS)) {
			volverInscripcion();
			limpiarP3();
			this.guardar = "";
		}
		
		if(e.getActionCommand().equals(gui.getP4().ELIMINAR01)) {
			borrarUsuario();
			limpiarP4();
			this.guardar = "";
		}else if (e.getActionCommand().equals(gui.getP4().ATRAS)) {
			limpiarP4();
			volverInscripcion();
			this.guardar = "";
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
	    this.line = enviar_datos;
		
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
		this.line = "Buscar"+";"+cedula;
		try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
		this.gui.getP2().getListado().setText(this.guardar);
		this.guardar = "";
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
		this.line = "Borrar"+";"+cedula;
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
			this.line = cedula+"-"+enviar_datos;
		}
	public void generarAvisos(String a) {
		if(a.equals("YAEXISTELACEDULA")) {
			this.gui.mostrar("Ya existe esa cedula, intente con otra");
			
		}else if(a.equals("USUARIOAGREGADOCORRECTAMENTE")) {
			this.gui.mostrar("Usuario agregado correctamente");
			
		}else if(a.equals("NOSEENCONTRO")){
			this.gui.mostrar("No se encontró el usuario");
			
		}else if(a.equals("USUARIONOREGISTRADO")) {
			this.gui.mostrar("El usuario ya está registrado");
			
		}else if(a.equals("USUARIOBORRADO")) {
			this.gui.mostrar("El usuario ha sido borrado");
			
		}else if(a.equals("USUARIONOBORRADO")) {
			this.gui.mostrar("El usuario no ha sido borrado");
			
		}else if(a.equals("CEDULAINVALIDA")) {
			this.gui.mostrar("Ingrese una cedula valida");
			
		}else if(a.equals("MODIFICADOBIEN")) {
			this.gui.mostrar("El usuario se modificó correctamente");
		}
	}
	/**
	 * Metodo que usa como parametro la cedula y con esta hace una busqueda en todo el array
	 * @param cedula long
	 * @return nos devuelve un valor "booleano"
	 */
}
