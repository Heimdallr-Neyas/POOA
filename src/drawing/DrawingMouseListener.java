package drawing;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTextField;

/**
 * Listener pour g�rer la souris dans la zone de dessin
 */
public class DrawingMouseListener implements MouseMotionListener, MouseListener {

	Drawing drawing;
	Shape currentShape = null;
	JTextField text;
	GroupComposite groupShapes = new GroupComposite();
	boolean moveGroup = false;
	
	public DrawingMouseListener(Drawing d, JTextField texte){
		drawing = d;
		text = texte;
	}
	
	/**
	 * Bouge la forme s�lectionn�e (si une forme est s�lectionn�e)
	 */
	public void mouseDragged(MouseEvent e) {
		if(moveGroup == true && drawing.getGrouped() && !groupShapes.empty() && groupShapes.contain(currentShape)){
			Point x = e.getPoint();
			x.x = x.x - currentShape.getPoint().x;
			x.y = x.y - currentShape.getPoint().y;
			for(GroupInterface s : groupShapes ){
				Point p = s.getPoint();
				p.y = x.y + s.getPoint().y;
				p.x = x.x + s.getPoint().x;
				s.setOrigin(p);
			}
			drawing.repaint();
		}
		if(currentShape != null){
			currentShape.setOrigin(e.getPoint());
			drawing.repaint();
		}
	}
	
	/**
	 * S�lectionne la forme sur laquelle l'utilisateur a cliqu�
	 */
	public void mousePressed(MouseEvent e) {
		moveGroup = false;
		if(!groupShapes.empty() && !drawing.getGrouped()){
			groupShapes.removeAll();
		}
		for(Shape s : drawing){
			if(s.isOn(e.getPoint())){
				currentShape = s;
				moveGroup = true;
				break;
			}
		}
	}
	
	/**
	 * D�s�lectionne la forme
	 */
	public void mouseReleased(MouseEvent e) {
		currentShape = null;
		moveGroup = false;

	}

	public void mouseMoved(MouseEvent e) {
		text.setText(drawing.getNumber());
		
	}

	public void mouseClicked(MouseEvent e) {
		for(Shape s : drawing){
			if( s.isOn(e.getPoint())) {
				if(drawing.getDuplicate()){
					drawing.cloneShape(s);
					drawing.razDuplicate();
					break;
				} else if(drawing.getGrouped() && !groupShapes.contain(s)){
					System.out.println("Figure Ajoutée au groupe");
					groupShapes.add(s);
					break;
				}
			}
			
		}
		
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
