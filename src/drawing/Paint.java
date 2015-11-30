package drawing;

import java.awt.BorderLayout;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box;

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
	private JPanel buttonPanel;
	private JPanel mainPanel;
	private JPanel infoPanel;
	private Box PanelBas;
	private Box PanelGroup;
	private Box PanelDuplicate;
	private Box PanelRedo;
	private Box PanelText;
	private Drawing drawing;
	private JTextField texte;
	private JTextField texteForme;
	
	public void run(){
		frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		PanelBas = Box.createVerticalBox();
		PanelGroup = Box.createHorizontalBox();
		PanelDuplicate = Box.createHorizontalBox();
		PanelRedo = Box.createHorizontalBox();
		PanelText = Box.createHorizontalBox();
		
		drawing = new Drawing();
		drawing.setBackground(Color.WHITE);
		
		
		clearButton = new JButton("Clear");
		circleButton = new JButton("Circle");
		rectangleButton = new JButton("Rectangle");
		groupButton = new JButton("Group");
		degroupButton = new JButton("Degroup");
		duplicateButton = new JButton("Duplicate");
		UndoButton = new JButton("Undo");
		RedoButton = new JButton("Redo");
		addTextButton = new JButton("add Text");
		
		buttonPanel = new JPanel();
		buttonPanel.add(clearButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(rectangleButton);
		
		PanelGroup.add(groupButton);
		PanelGroup.add(degroupButton);
		
		PanelDuplicate.add(duplicateButton);
		
		PanelRedo.add(UndoButton);
		PanelRedo.add(RedoButton);
		
		texteForme = new JTextField("Saisir le texte");

		PanelText.add(addTextButton);
		PanelText.add(texteForme);
		
		
		texte = new JTextField(drawing.getNumber());
		
		mainPanel.add(PanelBas, BorderLayout.SOUTH);
		mainPanel.add(drawing, BorderLayout.CENTER);
		
		infoPanel = new JPanel();
		infoPanel.add(texte);
		
		PanelBas.add(buttonPanel);
		PanelBas.add(infoPanel);
		PanelBas.add(PanelGroup);
		PanelBas.add(PanelDuplicate);
		PanelBas.add(PanelRedo);
		PanelBas.add(PanelText);
		
		texte.addActionListener(new CounterTextListener(texte, drawing));
		
		
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
