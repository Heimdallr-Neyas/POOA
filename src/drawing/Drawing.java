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
	ArrayList<Shape> shapesSauv;	
	int number;
	boolean grouped;
	boolean duplicate;
	boolean duplicateGroup;
	
	public Drawing(){
		super();
		number = 0;
		shapes = new ArrayList<Shape>();
		grouped = false;
		duplicate = false;
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
		shapesSauv = shapes;
		shapes.clear();
		this.repaint();
	}
	
	/**
	 * Recup number
	 */
	public String getNumber(){
		return new String(Integer.toString(number));
	}
	
	/**
	 * Group the shapes 
	 */
	public void group(){
		grouped = true;
	}
	
	/**
	 * Ungroup the shapes 
	 */
	public void degroup(){
		grouped = false;
	}
	
	public boolean getGrouped(){
		return grouped;
	}
	
	/**
	 * Duplicate a Shape
	 */
	public void duplicate(){
		duplicate = true;
	}
	
	public boolean getDuplicate(){
		return duplicate;
	}
	
	
	public void razDuplicate(){
		duplicate = false;
	}
	
	public void cloneShape(Shape s){
		shapes.add(s.clone());
		number++;
		this.repaint();
	}
	
	public void unClear(){
		number = shapesSauv.size();
		shapes = shapesSauv;
		shapesSauv.clear();
		this.repaint();
		
	}
	
	public void unDuplicate(){
		shapes.remove(number - 1);
		number --;
		duplicate = false;
	}
	
	public void unCreate(){
		shapes.remove(number - 1);
		number --;
		duplicate = false;
	}
}
