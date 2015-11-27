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
			  c = new CommandClearButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  break;        
		  case "Group":
			  c = new CommandGroupButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  break; 
		  case "Degroup":
			  c = new CommandDegroupButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  break; 
		  case "Duplicate":
			  c = new CommandDuplicateButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  break; 
		  case "Circle":
			  c = new CommandCircleButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  break;
		  case "Rectangle":
			  c = new CommandRectangleButton(_drawing);
			  _history.addElement(c);
			  i = 1;
			  break; 
		  case "Undo":
			  if(i > _history.size()){
				  i = 1;
			  }
			  c = new CommandUndoButton(_drawing, _history.elementAt(_history.size() - i));
			  i++;
			  break;
		  case "Redo":
			  if(i > _history.size()){
				  i = 1;
			  }
			  c = new CommandRedoButton(_drawing, _history.elementAt(_history.size() - i));
			  i++;
			  break; 
		  default: 
			  System.out.println("Erreur Patern Command (Invoker.java)");
		}
		
		c.execute();
	}
}
