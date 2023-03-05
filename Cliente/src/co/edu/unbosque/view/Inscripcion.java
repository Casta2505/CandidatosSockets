package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Clase que se encargará de mostrar la ventana de inscripcion de usuario
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class Inscripcion extends JPanel{
	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributos para crear espacios donde el usuario va a sescribir
	 */
	private JLabel nombre,apellido,cedula,edad,cargo,infbuscar,infenviar,infmodificar,infeliminar;
	/**
	 * atributos para generar cuadros de texto
	 */
	private JTextField txnombre,txapellido,txcedula,txedad,txcargo;
	/**
	 * atributos para generar botones
	 */
	private JButton enviar,buscar,modificar,eliminar; 
	/**
	 * atrivutos para crear las imagenes
	 */
	private ImageIcon icon1,icon2,icon3,icon4;
	/**
	 * atributos constante para reconocimiento de un boton
	 */
	public static final String ENVIAR="ENVIAR";
	/**
	 * atributos constante para reconocimiento de un boton
	 */
	public static final String BUSCAR="BUSCAR";
	/**
	 * atributos constante para reconocimiento de un boton
	 */
	public static final String MODIFICAR="MODIFICAR";
	/**
	 * atributos constante para reconocimiento de un boton
	 */
	public static final String ELIMINAR="ELIMINAR";
	/**
	 * Metodo constructor para inicializar las variables, asignarles los oyentes y crear la ventana con paneles
	 */
	public Inscripcion() {
		
		setSize(600,700);
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		nombre = new JLabel("Nombre:");
		nombre.setForeground(Color.white);
		nombre.setBounds(150,50,300,25);
		nombre.setFont(new Font("Courier New",Font.CENTER_BASELINE,30));
		
		txnombre = new JTextField();
		txnombre.setBounds(150,90,300,30);
		txnombre.setFont(new Font("Courier New",Font.CENTER_BASELINE,28));
		
		apellido = new JLabel("Apellido:");
		apellido.setForeground(Color.white);
		apellido.setBounds(150,130,300,25);
		apellido.setFont(new Font("Courier New",Font.CENTER_BASELINE,30));
		
		txapellido = new JTextField();
		txapellido.setBounds(150,170,300,30);
		txapellido.setFont(new Font("Courier New",Font.CENTER_BASELINE,28));
		
		cedula = new JLabel("Cedula:");
		cedula.setForeground(Color.white);
		cedula.setBounds(150,210,300,25);
		cedula.setFont(new Font("Courier New",Font.CENTER_BASELINE,30));
		
		txcedula = new JTextField();
		txcedula.setBounds(150,250,300,30);
		txcedula.setFont(new Font("Courier New",Font.CENTER_BASELINE,28));
		
		edad = new JLabel("Edad:");
		edad.setForeground(Color.white);
		edad.setBounds(150,290,300,25);
		edad.setFont(new Font("Courier New",Font.CENTER_BASELINE,30));
		
		txedad = new JTextField();
		txedad.setBounds(150,330,300,30);
		txedad.setFont(new Font("Courier New",Font.CENTER_BASELINE,28));
		
		cargo = new JLabel("Cargo:");
		cargo.setForeground(Color.white);
		cargo.setBounds(150,370,300,25);
		cargo.setFont(new Font("Courier New",Font.CENTER_BASELINE,30));
		
		txcargo = new JTextField();
		txcargo.setBounds(150,410,300,30);
		txcargo.setFont(new Font("Courier New",Font.CENTER_BASELINE,28));
		
		buscar = new JButton();
		buscar.setActionCommand(BUSCAR);
		buscar.setBounds(100, 500, 70, 70);
		buscar.setOpaque(false);
		buscar.setContentAreaFilled(false);
		buscar.setBorderPainted(false);
		icon1 = new ImageIcon("media/buscar.png");
		buscar.setIcon(new ImageIcon(icon1.getImage().getScaledInstance(buscar.getWidth(),  buscar.getHeight(), Image.SCALE_SMOOTH)));
		
		infbuscar = new JLabel("BUSCAR");
		infbuscar.setForeground(Color.white);
		infbuscar.setBounds(100,570,100,50);
		infbuscar.setFont(new Font("Courier New",Font.CENTER_BASELINE,18));
		
		enviar = new JButton();
		enviar.setActionCommand(ENVIAR);
		enviar.setBounds(200, 500, 70, 70);
		enviar.setOpaque(false);
		enviar.setContentAreaFilled(false);
		enviar.setBorderPainted(false);
		icon2 = new ImageIcon("media/enviar.png");
		enviar.setIcon(new ImageIcon(icon2.getImage().getScaledInstance(enviar.getWidth(),  enviar.getHeight(), Image.SCALE_SMOOTH)));
		
		infenviar = new JLabel("ENVIAR");
		infenviar.setForeground(Color.white);
		infenviar.setBounds(200,570,100,50);
		infenviar.setFont(new Font("Courier New",Font.CENTER_BASELINE,18));
		
		modificar = new JButton();
		modificar.setActionCommand(MODIFICAR);
		modificar.setBounds(310, 500, 70, 70);
		modificar.setOpaque(false);
		modificar.setContentAreaFilled(false);
		modificar.setBorderPainted(false);
		icon3 = new ImageIcon("media/modificar.png");
		modificar.setIcon(new ImageIcon(icon3.getImage().getScaledInstance(modificar.getWidth(),  modificar.getHeight(), Image.SCALE_SMOOTH)));
		
		infmodificar = new JLabel("MODIFICAR");
		infmodificar.setForeground(Color.white);
		infmodificar.setBounds(300,570,130,50);
		infmodificar.setFont(new Font("Courier New",Font.CENTER_BASELINE,18));
		
		eliminar = new JButton();
		eliminar.setActionCommand(ELIMINAR);
		eliminar.setBounds(430, 500, 70, 70);
		eliminar.setOpaque(false);
		eliminar.setContentAreaFilled(false);
		eliminar.setBorderPainted(false);
		icon4 = new ImageIcon("media/borrar.png");
		eliminar.setIcon(new ImageIcon(icon4.getImage().getScaledInstance(eliminar.getWidth(),  eliminar.getHeight(), Image.SCALE_SMOOTH)));
		
		infeliminar = new JLabel("ELIMINAR");
		infeliminar.setForeground(Color.white);
		infeliminar.setBounds(425,570,130,50);
		infeliminar.setFont(new Font("Courier New",Font.CENTER_BASELINE,18));
		
		add(nombre);
		add(txnombre);
		
		add(apellido);
		add(txapellido);
		
		add(cedula);
		add(txcedula);
		
		add(edad);
		add(txedad);
		
		add(cargo);
		add(txcargo);
		
		add(buscar);
		add(infbuscar);
		
		add(enviar);
		add(infenviar);
		
		add(modificar);
		add(infmodificar);
		
		add(eliminar);
		add(infeliminar);
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getNombre() {
		return nombre;
	}
	/**
	 * metodo para setear un dato de tipo jlabel
	 * @param nombre jlabel
	 */
	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getApellido() {
		return apellido;
	}
	/**
	 * metodo para setear un dato de tipo jlabel
	 * @param apellido jlabel
	 */
	public void setApellido(JLabel apellido) {
		this.apellido = apellido;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getCedula() {
		return cedula;
	}
	/**
	 * metodo para setear un dato de tipo jlabel
	 * @param cedula jlabel
	 */
	public void setCedula(JLabel cedula) {
		this.cedula = cedula;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getEdad() {
		return edad;
	}
	/**
	 * metodo para setear un dato de tipo jlabel
	 * @param edad jlabel
	 */
	public void setEdad(JLabel edad) {
		this.edad = edad;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getCargo() {
		return cargo;
	}
	/**
	 * metodo para setear un dato de tipo jlabel
	 * @param cargo jlabel
	 */
	public void setCargo(JLabel cargo) {
		this.cargo = cargo;
	}
	/**
	 * Metodo para retornar un dato de tipo JTextField
	 * @return jtextfield
	 */
	public JTextField getTxnombre() {
		return txnombre;
	}
	/**
	 * metodo para setear un dato de tipo jtextfield
	 * @param txnombre jtextfield
	 */
	public void setTxnombre(JTextField txnombre) {
		this.txnombre = txnombre;
	}
	/**
	 * Metodo para retornar un dato de tipo JTextField
	 * @return jtextfield
	 */
	public JTextField getTxapellido() {
		return txapellido;
	}
	/**
	 * metodo para setear un dato de tipo jtextfield
	 * @param txapellido jtextfield
	 */
	public void setTxapellido(JTextField txapellido) {
		this.txapellido = txapellido;
	}
	/**
	 * Metodo para retornar un dato de tipo JTextField
	 * @return jtextfield
	 */
	public JTextField getTxcedula() {
		return txcedula;
	}
	/**
	 * metodo para setear un dato de tipo jtextfield
	 * @param txcedula jtextfield
	 */
	public void setTxcedula(JTextField txcedula) {
		this.txcedula = txcedula;
	}
	/**
	 * Metodo para retornar un dato de tipo JTextField
	 * @return jtextfield
	 */
	public JTextField getTxedad() {
		return txedad;
	}
	/**
	 * metodo para setear un dato de tipo jtextfield
	 * @param txedad jtextfield
	 */
	public void setTxedad(JTextField txedad) {
		this.txedad = txedad;
	}
	/**
	 * Metodo para retornar un dato de tipo JTextField
	 * @return jtextfield
	 */
	public JTextField getTxcargo() {
		return txcargo;
	}
	/**
	 * metodo para setear un dato de tipo jtextfield
	 * @param txcargo jtextfield
	 */

	public void setTxcargo(JTextField txcargo) {
		this.txcargo = txcargo;
	}
	/**
	 * Metodo para retornar un dato de tipo JButton
	 * @return jbutton
	 */
	public JButton getEnviar() {
		return enviar;
	}
	/**
	 * metodo para setear un dato de tipo jbutton
	 * @param enviar jbutton
	 */
	public void setEnviar(JButton enviar) {
		this.enviar = enviar;
	}
	/**
	 * Metodo para retornar un dato de tipo JButton
	 * @return jbutton
	 */
	public JButton getBuscar() {
		return buscar;
	}
	/**
	 * metodo para setear un dato de tipo jbutton
	 * @param buscar jbutton
	 */
	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}
	/**
	 * Metodo para retornar un dato de tipo JButton
	 * @return jbutton
	 */
	public JButton getModificar() {
		return modificar;
	}
	/**
	 * metodo para setear un dato de tipo jbutton
	 * @param modificar jbutton
	 */
	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}
	/**
	 * Metodo para retornar un dato de tipo ImageIcon
	 * @return imageicon
	 */
	public ImageIcon getIcon1() {
		return icon1;
	}
	/**
	 * metodo para setear un dato de tipo imageicon
	 * @param icon1 imageicon
	 */
	public void setIcon1(ImageIcon icon1) {
		this.icon1 = icon1;
	}
	/**
	 * Metodo para retornar un dato de tipo ImageIcon
	 * @return imageicon
	 */
	public ImageIcon getIcon2() {
		return icon2;
	}
	/**
	 * metodo para setear un dato de tipo imageicon
	 * @param icon2 imageicon
	 */
	public void setIcon2(ImageIcon icon2) {
		this.icon2 = icon2;
	}
	/**
	 * Metodo para retornar un dato de tipo ImageIcon
	 * @return imageicon
	 */
	public ImageIcon getIcon3() {
		return icon3;
	}
	/**
	 * metodo para setear un dato de tipo imageicon
	 * @param icon3 imageicon
	 */
	public void setIcon3(ImageIcon icon3) {
		this.icon3 = icon3;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getInfbuscar() {
		return infbuscar;
	}
	/**
	 * metodo para setear un dato de tipo jlabel
	 * @param infbuscar jlabel
	 */
	public void setInfbuscar(JLabel infbuscar) {
		this.infbuscar = infbuscar;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getInfenviar() {
		return infenviar;
	}
	/**
	 * metodo para setear un dato de tipo jlabel
	 * @param infenviar jlabel
	 */
	public void setInfenviar(JLabel infenviar) {
		this.infenviar = infenviar;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getInfmodificar() {
		return infmodificar;
	}
	/**
	 * metodo para setear un dato de tipo jlabel
	 * @param infmodificar jlabel
	 */
	public void setInfmodificar(JLabel infmodificar) {
		this.infmodificar = infmodificar;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getInfeliminar() {
		return infeliminar;
	}
	/**
	 * metodo para setear un dato de tipo jlabel
	 * @param infeliminar jlabel
	 */
	public void setInfeliminar(JLabel infeliminar) {
		this.infeliminar = infeliminar;
	}
	/**
	 * Metodo para retornar un dato de tipo JButton
	 * @return jbutton
	 */
	public JButton getEliminar() {
		return eliminar;
	}
	/**
	 * metodo para setear un dato de tipo jbutton
	 * @param eliminar jbutton
	 */
	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}
	/**
	 * Metodo para retornar un dato de tipo ImageIcon
	 * @return imageicon
	 */
	public ImageIcon getIcon4() {
		return icon4;
	}
	/**
	 * metodo para setear un dato de tipo ImageIcon
	 * @param icon4 ImageIcon
	 */
	public void setIcon4(ImageIcon icon4) {
		this.icon4 = icon4;
	}

}
