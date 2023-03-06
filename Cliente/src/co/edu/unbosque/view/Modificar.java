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
 * Clase que se encarga de mostrar la ventana de modificacion de usuario 
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class Modificar extends JPanel{
	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributos para crea los espacios de texto
	 */
	private JLabel nombre,apellido,cedula,edad,cargo,infatras,infmodificar;
	/**
	 * atributos para crear los espacios de ingreso de texto
	 */
	private JTextField txnombre,txapellido,txcedula,txedad,txcargo;
	/**
	 * atributos para generar los botones
	 */
	private JButton atras,modificar; 
	/**
	 * atributos para generar las imagenes
	 */
	private ImageIcon icon1,icon2;
	/**
	 * atributo constante para el llamado del boton
	 */
	public static final String ATRAS="ATRAS";
	/**
	 *atributo constante para el llamado del boton
	 */
	public static final String MODIFICAR01="MODIFICAR01";
	/**
	 * Metodo constructor para inicializar las variables, asignarles los oyentes y crear la ventana con paneles
	 */
	public Modificar() {
		
		setSize(600,700);
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		nombre = new JLabel("Nombre:");
		nombre.setForeground(Color.white);
		nombre.setBounds(150,130,300,25);
		nombre.setFont(new Font("Courier New",Font.CENTER_BASELINE,30));
		
		txnombre = new JTextField();
		txnombre.setBounds(150,170,300,30);
		txnombre.setFont(new Font("Courier New",Font.CENTER_BASELINE,28));
		
		apellido = new JLabel("Apellido:");
		apellido.setForeground(Color.white);
		apellido.setBounds(150,210,300,25);
		apellido.setFont(new Font("Courier New",Font.CENTER_BASELINE,30));
		
		txapellido = new JTextField();
		txapellido.setBounds(150,250,300,30);
		txapellido.setFont(new Font("Courier New",Font.CENTER_BASELINE,28));
		
		cedula = new JLabel("Cedula de persona a modificar:");
		cedula.setForeground(Color.white);
		cedula.setBounds(70,50,500,25);
		cedula.setFont(new Font("Courier New",Font.CENTER_BASELINE,25));
		
		txcedula = new JTextField();
		txcedula.setBounds(150,90,300,30);
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
		
		atras = new JButton();
		atras.setActionCommand(ATRAS);
		atras.setBounds(170, 500, 70, 70);
		atras.setOpaque(false);
		atras.setContentAreaFilled(false);
		atras.setBorderPainted(false);
		icon1 = new ImageIcon("media/atras.png");
		atras.setIcon(new ImageIcon(icon1.getImage().getScaledInstance(atras.getWidth(),  atras.getHeight(), Image.SCALE_SMOOTH)));
		
		infatras = new JLabel("ATRAS");
		infatras.setForeground(Color.white);
		infatras.setBounds(180,570,100,50);
		infatras.setFont(new Font("Courier New",Font.CENTER_BASELINE,18));
		
		modificar = new JButton();
		modificar.setActionCommand(MODIFICAR01);
		modificar.setBounds(370, 500, 70, 70);
		modificar.setOpaque(false);
		modificar.setContentAreaFilled(false);
		modificar.setBorderPainted(false);
		icon2 = new ImageIcon("media/modificar.png");
		modificar.setIcon(new ImageIcon(icon2.getImage().getScaledInstance(modificar.getWidth(),  modificar.getHeight(), Image.SCALE_SMOOTH)));
		
		infmodificar = new JLabel("MODIFICAR");
		infmodificar.setForeground(Color.white);
		infmodificar.setBounds(360,570,130,50);
		infmodificar.setFont(new Font("Courier New",Font.CENTER_BASELINE,18));
		
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
		
		add(atras);
		add(infatras);
		
		add(modificar);
		add(infmodificar);
		
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
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getInfatras() {
		return infatras;
	}
	/**
	 * metodo para setear un dato de tipo jlabel
	 * @param infatras jlabel
	 */
	public void setInfatras(JLabel infatras) {
		this.infatras = infatras;
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
	public JButton getAtras() {
		return atras;
	}
	/**
	 * metodo para setear un dato de tipo jbutton
	 * @param atras jbutton
	 */
	public void setAtras(JButton atras) {
		this.atras = atras;
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
	

}
