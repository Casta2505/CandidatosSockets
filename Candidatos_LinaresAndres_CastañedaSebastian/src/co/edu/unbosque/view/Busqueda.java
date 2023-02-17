package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Clase que permite la visualizacion de la interfaz de busqueda
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class Busqueda extends JPanel{
	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributo para el listado
	 */
	private JTextArea listado;
	/**
	 * atributo para el scroll en el listado
	 */
	private JScrollPane barra;
	/**
	 * atributo para los botones
	 */
	private JButton buscar01,lista,atras;
	/**
	 * atributo para las imagenes
	 */
	private ImageIcon icon1,icon2,icon3;
	/**
	 * atributo para el espacio de ingreso de cedula
	 */
	private JTextField numcedula;
	/**
	 * atributo para los espacios en blancos
	 */
	private JLabel cedula, buscar,listar,retroceder;
	/**
	 * atributo para la constante de reconocimiento del boton
	 */
	public static final String BUSCAR01="BUSCAR01";
	/**
	 * atributo para la constante de reconocimiento del boton
	 */
	public static final String LISTA="LISTA";
	/**
	 * atributo para la constante de reconocimiento del boton
	 */
	public static final String ATRAS="ATRAS";
	/**
	 * Metodo constructor para inicializar las variables, asignarles los oyentes y crear la ventana con paneles
	 */
	public Busqueda() {
		setSize(600,700);
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		cedula = new JLabel("Cedula:");
		cedula.setForeground(Color.white);
		cedula.setBounds(50,50,300,25);
		cedula.setFont(new Font("Courier New",Font.CENTER_BASELINE,30));
		
		numcedula = new JTextField();
		numcedula.setBounds(204,50,330,30);
		numcedula.setFont(new Font("Courier New",Font.CENTER_BASELINE,28));
		
		listado = new JTextArea(" ");
		barra = new JScrollPane(listado,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barra.setBounds(50,90,485,450);
		
		buscar01 = new JButton();
		buscar01.setActionCommand(BUSCAR01);
		buscar01.setBounds(250, 570, 50, 50);
		buscar01.setOpaque(false);
		buscar01.setContentAreaFilled(false);
		buscar01.setBorderPainted(false);
		icon1 = new ImageIcon("media/buscar.png");
		buscar01.setIcon(new ImageIcon(icon1.getImage().getScaledInstance(buscar01.getWidth(),  buscar01.getHeight(), Image.SCALE_SMOOTH)));
		
		buscar = new JLabel("BUSCAR");
		buscar.setForeground(Color.white);
		buscar.setBounds(250,605,60,50);
		buscar.setFont(new Font("Courier New",Font.CENTER_BASELINE,12));
		
		lista = new JButton();
		lista.setActionCommand(LISTA);
		lista.setBounds(350, 570, 50, 50);
		lista.setOpaque(false);
		lista.setContentAreaFilled(false);
		lista.setBorderPainted(false);
		icon2 = new ImageIcon("media/lista.png");
		lista.setIcon(new ImageIcon(icon2.getImage().getScaledInstance(lista.getWidth(),  lista.getHeight(), Image.SCALE_SMOOTH)));
		
		listar = new JLabel("LISTAR");
		listar.setForeground(Color.white);
		listar.setBounds(355,605,60,50);
		listar.setFont(new Font("Courier New",Font.CENTER_BASELINE,12));
		
		atras = new JButton();
		atras.setActionCommand(ATRAS);
		atras.setBounds(150, 570, 50, 50);
		atras.setOpaque(false);
		atras.setContentAreaFilled(false);
		atras.setBorderPainted(false);
		icon3 = new ImageIcon("media/atras.png");
		atras.setIcon(new ImageIcon(icon3.getImage().getScaledInstance(atras.getWidth(),  atras.getHeight(), Image.SCALE_SMOOTH)));
		
		retroceder = new JLabel("ATRAS");
		retroceder.setForeground(Color.white);
		retroceder.setBounds(155,605,60,50);
		retroceder.setFont(new Font("Courier New",Font.CENTER_BASELINE,12));
		
		add(barra);
		add(buscar01);
		add(buscar);
		add(lista);
		add(listar);
		add(atras);
		add(retroceder);
		add(cedula);
		add(numcedula);
	}
	/**
	 * Metodo para retornar un dato de tipo JTextArea
	 * @return jtextarea
	 */
	public JTextArea getListado() {
		return listado;
	}
	/**
	 * Metodo para setear un dato tipo jtextarea
	 * @param listado jtextarea
	 */
	public void setListado(JTextArea listado) {
		this.listado = listado;
	}
	/**
	 * Metodo para retornar un dato de tipo JButton
	 * @return jbutton
	 */
	public JButton getBuscar01() {
		return buscar01;
	}
	/**
	 * Metodo para setear un dato tipo jbutton
	 * @param buscar01 jbutton
	 */
	public void setBuscar01(JButton buscar01) {
		this.buscar01 = buscar01;
	}
	/**
	 * Metodo para retornar un dato de tipo ImageIcon
	 * @return image icon
	 */
	public ImageIcon getIcon1() {
		return icon1;
	}
	/**
	 * Metodo para setear un dato tipo imageicon
	 * @param icon1 imageicon
	 */
	public void setIcon1(ImageIcon icon1) {
		this.icon1 = icon1;
	}
	/**
	 * Metodo para retornar un dato de tipo JScrollPane
	 * @return jscrollpane
	 */
	public JScrollPane getBarra() {
		return barra;
	}
	/**
	 * Metodo para setear un dato tipo jscrollpane
	 * @param barra jscrollpane
	 */
	public void setBarra(JScrollPane barra) {
		this.barra = barra;
	}
	/**
	 * Metodo para retornar un dato de tipo JButton
	 * @return jbutton
	 */
	public JButton getLista() {
		return lista;
	}
	/**
	 * Metodo para setear un dato tipo jbutton
	 * @param lista jbutton
	 */
	public void setLista(JButton lista) {
		this.lista = lista;
	}
	/**
	 * Metodo para retornar un dato de tipo JButton
	 * @return jbutton
	 */
	public JButton getAtras() {
		return atras;
	}
	/**
	 * Metodo para setear un dato tipo jbutton
	 * @param atras jbutton
	 */
	public void setAtras(JButton atras) {
		this.atras = atras;
	}
	/**
	 * Metodo para retornar un dato de tipo ImageIcon
	 * @return imageicon
	 */
	public ImageIcon getIcon2() {
		return icon2;
	}
	/**
	 * Metodo para setear un dato tipo imageicon
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
	 * Metodo para setear un dato tipo imageicon
	 * @param icon3 imageicon
	 */
	public void setIcon3(ImageIcon icon3) {
		this.icon3 = icon3;
	}
	/**
	 * Metodo para retornar un dato de tipo JTextField
	 * @return jtextfield
	 */
	public JTextField getNumcedula() {
		return numcedula;
	}
	/**
	 * Metodo para setear un dato tipo jtextfield
	 * @param numcedula jtextfield
	 */
	public void setNumcedula(JTextField numcedula) {
		this.numcedula = numcedula;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getCedula() {
		return cedula;
	}
	/**
	 * Metodo para setear un dato tipo jlabel
	 * @param cedula jlabel
	 */
	public void setCedula(JLabel cedula) {
		this.cedula = cedula;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getBuscar() {
		return buscar;
	}
	/**
	 * Metodo para setear un dato tipo jlabel
	 * @param buscar jlabel
	 */
	public void setBuscar(JLabel buscar) {
		this.buscar = buscar;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getListar() {
		return listar;
	}
	/**
	 * Metodo para setear un dato tipo jlabel
	 * @param listar jlabel
	 */
	public void setListar(JLabel listar) {
		this.listar = listar;
	}
	/**
	 * Metodo para retornar un dato de tipo JLabel
	 * @return jlabel
	 */
	public JLabel getRetroceder() {
		return retroceder;
	}
	/**
	 * Metodo para setear un dato tipo jlabel
	 * @param retroceder jlabel
	 */
	public void setRetroceder(JLabel retroceder) {
		this.retroceder = retroceder;
	}

}
