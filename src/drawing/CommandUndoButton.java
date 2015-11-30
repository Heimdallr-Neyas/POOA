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
			  drawing.unClear();
			  break;        
		  case "Group":
			  drawing.degroup();
			  break; 
		  case "Degroup":
			  drawing.group();
			  break; 
		  case "Duplicate":
			  drawing.unDuplicate();
			  break; 
		  case "Circle":
			  drawing.unCreate();
			  break;
		  case "Rectangle":
			  drawing.unCreate();
			  break; 
		  case "Undo":
			  //Nothing
			  break;
		  case "Redo":
			  //Nothing
			  break; 
		  default: 
			  System.out.println("Erreur Patern Command (Undo)");
		}
	}
	
	public String name(){
		return "Redo";
	}
}
