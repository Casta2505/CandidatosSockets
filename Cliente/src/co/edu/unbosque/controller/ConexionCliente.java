package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class ConexionCliente extends Thread{
	private Socket socket;
    private ServerSocket server; 
    private Scanner sn;
    private ObjectOutputStream out;
    private DataInputStream in; //Input stream from server
    private String address, line, recibido, guardar;
    private int port;
  
    // constructor to put ip address and port 
    public ConexionCliente(String address, int port){ 
    	// initialize socket and input output streams 
        this.socket= null;
        this.server=null;
        this.sn=new Scanner(System.in);
        this.out= null;
        this.address=address;
        this.port=port;
        this.line = "";
        this.recibido = "";
    }
    
    @Override
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
                        Thread.sleep(1000);
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
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    	
    }
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getRecibido() {
		return recibido;
	}

	public void setRecibido(String recibido) {
		this.recibido = recibido;
	}

	public String getGuardar() {
		return guardar;
	}

	public void setGuardar(String guardar) {
		this.guardar = guardar;
	}
	
	
    
}
