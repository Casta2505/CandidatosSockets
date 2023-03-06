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
 * Clase que se encargará de mostrar la ventana de borrar usuario
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class Borrador extends JPanel{
	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributos de tipo jlabel
	 */
	private JLabel cedula,infeliminar,infatras;
	/**
	 * atributo de tipo textfield
	 */
	private JTextField txcedula;
	/**
	 * atributo de tipo jbutton
	 */
	private JButton atras,eliminar; 
	/**
	 * atributo de tipo imageicon
	 */
	private ImageIcon icon1,icon2;
	/**
	 * atributo que sirve como constante para los botones
	 */
	public static final String ATRAS="ATRAS";
	/**
	 * atributo que sirve como constante para los botones
	 */
	public static final String ELIMINAR01="ELIMINAR01";
	/**
	 * Metodo constructor para inicializar las variables, asignarles los oyentes y crear la ventana con paneles
	 */
	public Borrador() {
		setSize(600,700);
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		cedula = new JLabel("Cedula de la persona que se eliminar:");
		cedula.setForeground(Color.white);
		cedula.setBounds(30,210,550,25);
		cedula.setFont(new Font("Courier New",Font.CENTER_BASELINE,24));
		
		txcedula = new JTextField();
		txcedula.setBounds(150,250,300,30);
		txcedula.setFont(new Font("Courier New",Font.CENTER_BASELINE,28));
		
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
		
		eliminar = new JButton();
		eliminar.setActionCommand(ELIMINAR01);
		eliminar.setBounds(360, 500, 70, 70);
		eliminar.setOpaque(false);
		eliminar.setContentAreaFilled(false);
		eliminar.setBorderPainted(false);
		icon2 = new ImageIcon("media/borrar.png");
		eliminar.setIcon(new ImageIcon(icon2.getImage().getScaledInstance(eliminar.getWidth(),  eliminar.getHeight(), Image.SCALE_SMOOTH)));
		
		infeliminar = new JLabel("ELIMINAR");
		infeliminar.setForeground(Color.white);
		infeliminar.setBounds(360,570,100,50);
		infeliminar.setFont(new Font("Courier New",Font.CENTER_BASELINE,18));
		
		add(cedula);
		add(txcedula);
		add(atras);
		add(infatras);
		add(eliminar);
		add(infeliminar);
		
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getCedula() {
		return cedula;
	}
	/**
	 * Metodo para setear jlabel
	 * @param cedula jlabel
	 */
	public void setCedula(JLabel cedula) {
		this.cedula = cedula;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getInfeliminar() {
		return infeliminar;
	}
	/**
	 * Metodo para setear jlabel
	 * @param infeliminar jlabel
	 */
	public void setInfeliminar(JLabel infeliminar) {
		this.infeliminar = infeliminar;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getInfatras() {
		return infatras;
	}
	/**
	 * Metodo para setear jlabel
	 * @param infatras jlabel
	 */
	public void setInfatras(JLabel infatras) {
		this.infatras = infatras;
	}
	/**
	 * Metodo para retornar un dato de tipo JTextField
	 * @return jtextfield
	 */
	public JTextField getTxcedula() {
		return txcedula;
	}
	/**
	 * Metodo para setear jtextfield
	 * @param txcedula jtextfield
	 */
	public void setTxcedula(JTextField txcedula) {
		this.txcedula = txcedula;
	}
	/**
	 * Metodo para retornar un dato de tipo JButton
	 * @return jbutton
	 */
	public JButton getAtras() {
		return atras;
	}
	/**
	 * Metodo para setear jbutton
	 * @param atras jbutton
	 */
	public void setAtras(JButton atras) {
		this.atras = atras;
	}
	/**
	 * Metodo para retornar un dato de tipo JButton
	 * @return jbutton
	 */
	public JButton getEliminar() {
		return eliminar;
	}
	/**
	 * Metodo para setear jbutton
	 * @param eliminar jbutton
	 */
	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}
	/**
	 * Metodo para retornar un dato de tipo ImageIcon
	 * @return imageicon
	 */
	public ImageIcon getIcon1() {
		return icon1;
	}
	/**
	 * Metodo para setear imageicon
	 * @param icon1 imageicon
	 */
	public void setIcon1(ImageIcon icon1) {
		this.icon1 = icon1;
	}
	/**
	 * Metodo para retornar un dato de tipo ImagenIcon
	 * @return imgeicon
	 */
	public ImageIcon getIcon2() {
		return icon2;
	}
	/**
	 * Metodo para setear imageicon
	 * @param icon2 imageicon 
	 */
	public void setIcon2(ImageIcon icon2) {
		this.icon2 = icon2;
	}
	
}
