package drawing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CommandAddTextButton implements CommandInterface, ActionListener, MouseListener {

	Drawing drawing;
	String value;
	JTextField texte;
	JDialog dialog;
	
	public CommandAddTextButton(Drawing drawing){
		this.drawing = drawing;
		this.value ="";	
	}
	
	private void createWindows(){
		dialog = new JDialog();
		dialog.setTitle("Texte à saisir");
		dialog.setSize(300, 100);//On lui donne une taille
		dialog.setVisible(true);//On la rend visible
		
		
		texte = new JTextField();
		texte.setSize(300, 100);
		
		JPanel Panel = new JPanel(new BorderLayout());
		Panel.add(texte, BorderLayout.CENTER);
		
		dialog.getContentPane().add(Panel);
	
		JButton ok = new JButton("OK");
		Panel.add(ok, BorderLayout.SOUTH);
		
		ok.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		value = texte.getText();
		dialog.dispose();
		drawing.addMouseListener(this);
		
	}
	
	public void execute() {
		createWindows();
	}
	
	public void execute(Shape s) {
		drawing.addText(value, s);
		System.out.println("Texte ajouté");
	}

	public String name(){
		return "add Text";
	}
	
	

	public void mousePressed(MouseEvent arg0) {
		for(Shape s : drawing){
			if(s.isOn(arg0.getPoint())){
				execute(s);
				break;
			}
		}
		drawing.removeMouseListener(this);
	}
	
	public void mouseReleased(MouseEvent arg0) {
	}
	
	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}
	
	

}