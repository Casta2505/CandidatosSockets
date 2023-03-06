package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.unbosque.model.CandidatoDAO;
import co.edu.unbosque.model.CandidatoDTO;
import co.edu.unbosque.model.Fachada;
import co.edu.unbosque.model.persistence.CandidatoFile;

public class Servidor extends Thread{
	private Socket socket; //This socket is for read client message
    private Socket socketR;//This socket is for send a message to client
    private ServerSocket server; 
    private ObjectInputStream in;
    private DataOutputStream out;
    private int	port;
    private String addressClient, enviar, enviar_controller;
    private Fachada facha;
    private long cedula;
  
    // constructor with port 
    public Servidor(int port){ 
    	//initialize socket and input stream 
    	this.socket=null;
    	this.socketR=null;
    	this.server=null; 
    	this.in=null;
    	this.out=null;
    	this.port=port;
    	this.addressClient=addressClient;
    	this.facha = new Fachada();
		this.facha.getCf().leerCandidatos();
		this.facha.getCdao().setCandidato(facha.getCf().getDato());
    	this.cedula = 0;
     
       
    }
    @Override
    public void run(){
//    	try {    	
//			
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
        String line = ""; 
        // reads message from client until "Over" is sent 
        while (!line.equals("Over")) 
        { 
            try
            { 
            	line = "";
            	this.enviar = "default";
            	this.cedula = 0;
            	this.server = new ServerSocket(this.port);
    			System.out.println("Server started"); 
    	        System.out.println("Waiting for a client ..."); 
    	        this.socket = server.accept(); 
    	        System.out.println("Client accepted"); 
    	        // takes input from the client socket 
    	        this.in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); 
            	line = (String) in.readUTF();
            	
            	try {
            		String[] modificar = line.split("-");
            		this.cedula = Long.parseLong(modificar[0]);
					String datos_modificar = modificar[1];
					this.enviar = modificarUsuario(this.cedula, datos_modificar);	
					
				} catch (Exception e) {
					try {
						String[] separar = line.split(";");
						String instruccion = separar[0];
						this.cedula = Long.parseLong(separar[1]);
						
						if(instruccion.equals("Borrar")) {
							this.enviar = borrarUsuario(this.cedula);
							
						}else if(instruccion.equals("Buscar")){
							this.enviar = buscarCandidato(this.cedula);
						}
					} catch (Exception eso) {
						if(line.equals("Leer")) {
		            		this.enviar = leerArchivo();
		            	}else {
		            		this.enviar = escribirArchivo(line);
		            	}
					}
				}
            	this.in.close();
            	this.socket.close();
                //Send message to the client
                //Create a socket to send message to client
            	this.socketR=new Socket(this.socket.getInetAddress(), this.port+1);
            	//sends output to the socket to client
                this.out = new DataOutputStream(socketR.getOutputStream()); 
                this.out.writeUTF(this.enviar);
                this.out.close();
                this.socketR.close();
                
                this.in.close();
                this.server.close();
            } 
            catch(IOException i) 
            { 
                System.out.println(i);
            } 
        } 
        System.out.println("Closing connection"); 

        // close connection 
        try {
			socket.close();
			in.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public String escribirArchivo(String datos) {
    	String nombre = "";
    	String apellido = "";
    	int cedula = 0;
    	int edad = 0;
    	String cargo = "";
    	String[] valores = datos.split(";");
    	nombre = valores[0];
    	apellido = valores[1];
    	cedula = Integer.parseInt(valores[2]);
    	edad = Integer.parseInt(valores[3]);
    	cargo = valores[4];
    	
    	if(comprobarExistencia(cedula)==true) {
    		return "YAEXISTELACEDULA";
    	}
    	
    	this.facha.getCdao().agregarCandidato(nombre.toUpperCase(), apellido.toUpperCase(), cedula, edad, cargo.toUpperCase());
    	
    	int ldos = this.facha.getCdao().getCandidato().size();
		System.out.println(ldos+"ldos");
	    
		boolean a = this.facha.getCf().escribirCandidato(this.facha.getCdao().getCandidato());
    
	    return "USUARIOAGREGADOCORRECTAMENTE";
    }
    
    
    public String leerArchivo() {
		return this.facha.getCf().leerCandidatos();
    }
    
    
    public String buscarCandidato(long cedula_aux){
    	String texto = "NOSEENCONTRO";
		for (int i = 0; i<this.facha.getCdao().getCandidato().size();i++) {
			if(this.facha.getCdao().getCandidato().get(i).getCedula() == cedula_aux) {
				texto = "\n"+"El usuario es:"+"\n"+
				"Nombre: "+this.facha.getCdao().getCandidato().get(i).getNombre()+"\n"+
				"Apellido: "+this.facha.getCdao().getCandidato().get(i).getApellido()+"\n"+
				"Cedula: "+this.facha.getCdao().getCandidato().get(i).getCedula()+"\n"+
				"Edad: "+this.facha.getCdao().getCandidato().get(i).getEdad()+"\n"+
				"Cargo: "+this.facha.getCdao().getCandidato().get(i).getCargo()+"\n";
				return texto;
			}
		}
		return texto;
    }
    public String borrarUsuario(long cedula) {
		if(comprobarExistencia(cedula)==false) {
			return "USUARIONOREGISTRADO";
		}else {
			this.facha.getCdao().deleteUser(cedula, this.facha.getCdao().getCandidato());
			boolean a = this.facha.getCf().escribirCandidato(this.facha.getCdao().getCandidato());
			if(a) {
				return "USUARIOBORRADO";
			}else {
				return "USUARIONOBORRADO";
			}
		}
	}
    public boolean comprobarExistencia(long cedula) {
    	leerArchivo();
		boolean aux = false;
		for (int i = 0; i < this.facha.getCdao().getCandidato().size();i++) {
			if (this.facha.getCdao().getCandidato().get(i).getCedula()==cedula) {
				aux = true;
				return aux;
			}else {
				aux = false;
			}
		}
		
		return aux;
	}
    
    public String modificarUsuario(long cedula_modificar, String datos_escribir) {
		if(comprobarExistencia(cedula_modificar)==false) {
			
			return "CEDULAINVALIDA";
		}else {
			for(int i = 0; i<this.facha.getCdao().getCandidato().size(); i++) {
				if(this.facha.getCdao().getCandidato().get(i).getCedula() == cedula_modificar) {
					this.facha.getCdao().deleteUser(cedula_modificar, this.facha.getCdao().getCandidato());
					boolean a = this.facha.getCf().escribirCandidato(this.facha.getCdao().getCandidato());
				}
			}
			escribirArchivo(datos_escribir);
		    return "MODIFICADOBIEN";
		}
	}
}
