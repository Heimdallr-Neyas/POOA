package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class CounterTextListener implements ActionListener {

	JTextField texte;
	Drawing drawing;
	public CounterTextListener(JTextField texte, Drawing drawing){
		System.out.println("RAZ compteur");
		this.texte = texte;
		this.drawing = drawing;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		texte.setText(drawing.getNumber());
	}

}
