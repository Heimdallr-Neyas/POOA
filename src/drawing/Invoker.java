package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Invoker implements ActionListener{
	
	Drawing _drawing;
	CommandInterface c;
	Vector<CommandInterface> _history;
	int i;
	
	public Invoker(Drawing drawing){
		this._drawing = drawing;
		this._history = new Vector<CommandInterface>();
		i = 1;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		switch (arg0.getActionCommand()){
		  case "Clear":
			  System.out.println("78945600");
			  c = new CommandClearButton(_drawing);
			  System.out.println("741852963");
			  _history.addElement(c);
			  System.out.println("123456789");
			  i = 1;
			  System.out.println("123456789");
			  c.execute();
			  break;        
		  case "Group":
			  c = new CommandGroupButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  c.execute();
			  break; 
		  case "Degroup":
			  c = new CommandDegroupButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  c.execute();
			  break; 
		  case "Duplicate":
			  c = new CommandDuplicateButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  c.execute();
			  break; 
		  case "Circle":
			  c = new CommandCircleButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  c.execute();
			  break;
		  case "Rectangle":
			  c = new CommandRectangleButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  c.execute();
			  break; 
		  case "add Text":
			  c = new CommandAddTextButton(_drawing, "");
			  _history.addElement(c);
			  i = 1;
			  c.execute();
			  break; 
		  case "Undo":
			  if(i > _history.size()){
				  //i = 1;
				  System.out.println("Plus rien à annuler ");
			  }else{
				  c = new CommandUndoButton(_drawing, _history.elementAt(_history.size() - i));
				  i++;  
				  c.execute();
			  }
			  break;
		  case "Redo":
			  if(i <= 0){
				  System.out.println("Plus rien à rejouer ");
			  }else{
				  c = new CommandRedoButton(_drawing, _history.elementAt(_history.size() - i));
				  i--;				  
				  c.execute();
			  }
			  break; 
		  default: 
			  System.out.println("Erreur Patern Command (Invoker.java)");
		}
		
	}
}
