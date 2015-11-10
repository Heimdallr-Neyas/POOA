package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * JPanel pouvant afficher des objets de type Shape
 */
public class Drawing extends JPanel implements Iterable<Shape> {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Shape> shapes;
	int number;
	
	public Drawing(){
		super();
		number = 0;
		shapes = new ArrayList<Shape>();
	}
	
	/**
	 * Impl�mentation de l'interface Iterable<Shape>
	 */
	public Iterator<Shape> iterator(){
		return shapes.iterator();
	}
	
	/**
	 * Ajoute une forme au dessin et redessine
	 */
	public void addShape(Shape s){
		shapes.add(s);
		number++;
		this.repaint();
	}
	
	/** 
	 * Red�finition de la m�thode paintComponent() de JComponent
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : shapes){
			s.paint(g);
		}
		
	}
	
	/**
	 * Enl�ve toutes les formes et redessine
	 */
	public void clear(){
		number = 0;
		shapes.clear();
		this.repaint();
	}
	
	/**
	 * Enl�ve toutes les formes et redessine
	 */
	public String getNumber(){
		return new String(Integer.toString(number));
	}
	
}
