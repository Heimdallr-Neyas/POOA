package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
/**
 * JPanel pouvant afficher des objets de type Shape
 */
public class Drawing extends JPanel implements Iterable<Shape> {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Shape> shapes; // Les formes
	ArrayList<String> shapesText; // Les textes liés aux formes. 
	int number; // Nombre de formes 
	boolean grouped; // Groupé, utile pour les déplacement
	boolean duplicate; // Dupliqué, utile pour dupliquer
	
	public Drawing(){
		super();
		number = 0;
		shapes = new ArrayList<Shape>();
		shapesText = new ArrayList<String>();
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
		shapesText.add("");
		number++;
		this.repaint();
	}
	
	/** 
	 * Red�finition de la m�thode paintComponent() de JComponent
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//for(Shape s : shapes){
			//s.paint(g);
		for(int i = 0; i< number; i++){
			shapes.get(i).paint(g);
			g.setColor(Color.BLACK);
			g.drawString(shapesText.get(i), shapes.get(i).origin.x, shapes.get(i).origin.y);
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
		shapesText.add(shapesText.get(shapes.indexOf(s)));
		number++;
		this.repaint();
	}
	
	public void addText(String value, Shape s){
		int i = shapes.indexOf(s);
		shapesText.set(i, value); 
		this.repaint();
	}

}
