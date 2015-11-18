package drawing;

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
	
	public DrawingMouseListener(Drawing d, JTextField texte){
		drawing = d;
		text = texte;
	}
	
	/**
	 * Bouge la forme s�lectionn�e (si une forme est s�lectionn�e)
	 */
	public void mouseDragged(MouseEvent e) {
		if(currentShape != null){
			currentShape.setOrigin(e.getPoint());
			drawing.repaint();
		}
	}
	
	/**
	 * S�lectionne la forme sur laquelle l'utilisateur a cliqu�
	 */
	public void mousePressed(MouseEvent e) {
		for(Shape s : drawing){
			if(s.isOn(e.getPoint())){
				currentShape = s;
				break;
			}
		}
	}
	
	/**
	 * D�s�lectionne la forme
	 */
	public void mouseReleased(MouseEvent e) {
		currentShape = null;

	}

	public void mouseMoved(MouseEvent e) {
		text.setText(drawing.getNumber());
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
