package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.unbosque.controller.Controller;
/**
 * Clase que se encargará de mostrar la ventana principal del usuario
 * @author AndresLinares y SebastianCastañeda
 *
 */
public class View extends JFrame{
	/**
	 * serial de la clase
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * atributo para llamar la clase inscripcion
	 */
	private Inscripcion p1;
	/**
	 * atributo para llamar la clase busqueda
	 */
	private Busqueda p2;
	/**
	 * atributo para llamar la clase modificar
	 */
	private Modificar p3;
	/**
	 * atributo para llamar la clase modificar
	 */
	private Borrador p4;
	/**
	 * Metodo constructor para inicializar las variables, asignarles los oyentes y crear la ventana con paneles
	 * @param control Controller
	 */
	public View(Controller control) {
		setSize(600,700);
		setResizable(false);
		setTitle("CANDIDATOS");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		p1 = new Inscripcion();
		p2 = new Busqueda();
		p3 = new Modificar();
		p4 = new Borrador();
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		
		p1.getBuscar().addActionListener(control);
		p1.getEnviar().addActionListener(control);
		p1.getModificar().addActionListener(control);
		p1.getEliminar().addActionListener(control);
		p2.getBuscar01().addActionListener(control);
		p2.getAtras().addActionListener(control);
		p2.getLista().addActionListener(control);
		p3.getAtras().addActionListener(control);
		p3.getModificar().addActionListener(control);
		p4.getAtras().addActionListener(control);
		p4.getEliminar().addActionListener(control);
		
	}
	/**
	 * Metodo para mostrarle una ventana de informacion al usuario
	 * @param dato String
	 */
	public void mostrar(String dato) {
		JOptionPane.showMessageDialog(null, dato);
	}
	/**
	 * Metodo para retornar un dato de tipo Inscripcion
	 * @return inscripcion
	 */
	public Inscripcion getP1() {
		return p1;
	}
	/**
	 * Metodo para setear un dato de tipo inscripcion
	 * @param p1 inscripcion
	 */
	public void setP1(Inscripcion p1) {
		this.p1 = p1;
	}
	/**
	 * Metodo para retornar un dato de tipo Busqueda
	 * @return busqueda
	 */
	public Busqueda getP2() {
		return p2;
	}
	/**
	 * Metodo para setear un dato de tipo busqueda
	 * @param p2 busqueda
	 */
	public void setP2(Busqueda p2) {
		this.p2 = p2;
	}
	/**
	 * Metodo para retornar un dato de tipo Modificar
	 * @return modificar
	 */
	public Modificar getP3() {
		return p3;
	}
	/**
	 * Metodo para setear un dato de tipo modidifcar
	 * @param p3 modidifcar
	 */
	public void setP3(Modificar p3) {
		this.p3 = p3;
	}
	/**
	 * Metodo para retornar un dato de tipo Borrador
	 * @return borrador
	 */
	public Borrador getP4() {
		return p4;
	}
	/**
	 * Metodo para setear un dato de tipo borrador
	 * @param p4 borrador
	 */
	public void setP4(Borrador p4) {
		this.p4 = p4;
	}
	
}
