package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Invoker implements ActionListener{
	
	Drawing _drawing;
	Vector<CommandInterface> _history;
	int i;
	
	public Invoker(Drawing drawing){
		this._drawing = drawing;
		this._history = new Vector<CommandInterface>();
		i = 1;
	}
	
	public void fct(CommandInterface c){
		_history.addElement(c);
		  i = 1; 
		  c.execute();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		switch (arg0.getActionCommand()){
		  case "Clear":;
			  fct(new CommandClearButton(_drawing));
			  _history.clear();
			  break;        
		  case "Group":
			  fct(new CommandGroupButton(_drawing));
			  break; 
		  case "Degroup":
			  fct(new CommandDegroupButton(_drawing));
			  break; 
		  case "Duplicate":
			  fct(new CommandDuplicateButton(_drawing));
			  break; 
		  case "Circle":
			  fct(new CommandCircleButton(_drawing));
			  break;
		  case "Rectangle":
			  fct(new CommandRectangleButton(_drawing));
			  break; 
		  case "add Text":
			  fct(new CommandAddTextButton(_drawing));
			  break; 
		  case "Undo":
			 if(i > _history.size()){
			 } else {
				  _drawing.clear();
				 for(int k = 0; k < _history.size() - i; k ++){
					 _history.elementAt(k).execute();
				 }
				 i++;				 
			 }
			 break;
		  case "Redo":
			  if(i <= 1){
				  i = 1;
			  } else {
				  i--;
				  _history.elementAt(_history.size() - i).execute();
			  }
			  break; 
		  default: 
			  System.out.println("Erreur Patern Command (Invoker.java)");
		}
		
	}
}
