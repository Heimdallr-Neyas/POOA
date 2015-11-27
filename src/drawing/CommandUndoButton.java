package drawing;

public class CommandUndoButton implements CommandInterface{
	Drawing drawing;
	CommandInterface c;
	
	public CommandUndoButton(Drawing _drawing, CommandInterface t){
		drawing = _drawing;
		c = t;
	}
	
	public void execute() {
		switch (c.name()){
		  case "Clear":
			  //TODO
			  break;        
		  case "Group":
			  drawing.degroup();
			  break; 
		  case "Degroup":
			  drawing.group();
			  break; 
		  case "Duplicate":
			  drawing.duplicate();
			  break; 
		  case "Circle":
			  
			  break;
		  case "Rectangle":
			  break; 
		  case "Undo":
			  break;
		  case "Redo":
			  break; 
		  default: 
			  System.out.println("Erreur Patern Command (Undo)");
		}
	}
	
	public String name(){
		return "Redo";
	}
}
