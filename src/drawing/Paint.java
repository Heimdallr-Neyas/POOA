package drawing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint {

	private JFrame frame;
	
	private JButton clearButton;
	private JButton circleButton;
	private JButton rectangleButton;
	private JButton groupButton;
	private JButton degroupButton;
	private JButton duplicateButton;
	private JButton UndoButton;
	private JButton RedoButton;
	private JButton addTextButton;
	private JLabel counter;
	
	private JPanel mainPanel;
	private Box buttonPanel;
	private Box infoPanel;
	private Box PanelBas;
	private Box PanelGroup;
	
	private Drawing drawing;
	private JTextField texte;
	
	public void run(){
		frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		
		drawing = new Drawing();
		drawing.setBackground(Color.WHITE);
		
		
		// Les boutons
		clearButton = new JButton("Clear");
		circleButton = new JButton("Circle");
		rectangleButton = new JButton("Rectangle");
		groupButton = new JButton("Group");
		degroupButton = new JButton("Degroup");
		duplicateButton = new JButton("Duplicate");
		UndoButton = new JButton("Undo");
		RedoButton = new JButton("Redo");
		addTextButton = new JButton("add Text");
		
		counter = new JLabel("Nombre de figures : ");
		
		//listeners pour les boutons
		//clearButton.addActionListener(new ClearButtonListener(drawing));
		Invoker inv = new Invoker(drawing);
		
		clearButton.addActionListener(inv);
		circleButton.addActionListener(inv);
		rectangleButton.addActionListener(inv);
		groupButton.addActionListener(inv);
		degroupButton.addActionListener(inv);
		duplicateButton.addActionListener(inv);
		UndoButton.addActionListener(inv);
		RedoButton.addActionListener(inv);
		addTextButton.addActionListener(inv);
	

		
		// Gestion des Panels 
		mainPanel = new JPanel(new BorderLayout());
		PanelBas = Box.createVerticalBox();
		PanelGroup = Box.createHorizontalBox();
		buttonPanel = Box.createHorizontalBox();
		infoPanel = Box.createHorizontalBox();
		
		mainPanel.add(PanelBas, BorderLayout.SOUTH);
		mainPanel.add(drawing, BorderLayout.CENTER);
		
		
		buttonPanel.add(clearButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(rectangleButton);
		
		texte = new JTextField(drawing.getNumber());
		texte.addActionListener(new CounterTextListener(texte, drawing));
		infoPanel.add(counter);
		infoPanel.add(texte);
		
		PanelGroup.add(groupButton);
		PanelGroup.add(degroupButton);
		PanelGroup.add(duplicateButton);
		PanelGroup.add(UndoButton);
		PanelGroup.add(RedoButton);
		PanelGroup.add(addTextButton);
		
		PanelBas.add(buttonPanel);
		PanelBas.add(infoPanel);
		PanelBas.add(PanelGroup);
		

		//listeners pour la zone de dessin
		DrawingMouseListener l = new DrawingMouseListener(drawing, texte);
		drawing.addMouseListener(l);
		drawing.addMouseMotionListener(l);		

		frame.getContentPane().add(mainPanel);
		frame.setSize(640,580);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args){
		Paint app = new Paint();
		app.run();
	}
}
