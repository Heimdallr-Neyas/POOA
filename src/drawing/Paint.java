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
	private JPanel buttonPanel;
	private JPanel mainPanel;
	private JPanel infoPanel;
	private Box PanelBas;
	private Drawing drawing;
	private JTextField texte;
	
	public void run(){
		frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		PanelBas = Box.createVerticalBox();
		
				
		drawing = new Drawing();
		drawing.setBackground(Color.WHITE);
		clearButton = new JButton("Clear");
		circleButton = new JButton("Circle");
		rectangleButton = new JButton("Rectangle");
		
		buttonPanel = new JPanel();
		buttonPanel.add(clearButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(rectangleButton);
		
		texte = new JTextField("0");
		
		mainPanel.add(PanelBas, BorderLayout.SOUTH);
		mainPanel.add(drawing, BorderLayout.CENTER);
		
		infoPanel = new JPanel();
		infoPanel.add(texte);
		
		PanelBas.add(buttonPanel);
		PanelBas.add(infoPanel);
		
		texte.addActionListener(new CounterTextListener(texte, drawing));
//		clearButton.addActionListener(new ClearButtonListener(drawing));
		
		
		//listeners pour les boutons
		clearButton.addActionListener(new ClearButtonListener(drawing));
		circleButton.addActionListener(new CircleButtonListener(drawing));
		rectangleButton.addActionListener(new RectangleButtonListener(drawing));
		
		//listeners pour la zone de dessin
		DrawingMouseListener l = new DrawingMouseListener(drawing, texte);
		drawing.addMouseListener(l);
		drawing.addMouseMotionListener(l);
		
		

		frame.getContentPane().add(mainPanel);
		frame.setSize(640,480);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args){
		Paint app = new Paint();
		app.run();
	}
}
