package drawing;

public class CommandRedoButton implements CommandInterface{
	Drawing drawing;
	CommandInterface c;
	
	public CommandRedoButton(Drawing _drawing, CommandInterface t){
		drawing = _drawing;
		c = t;
	}
	
	public void execute() {
		switch (c.name()){
		  case "Clear":
			  drawing.clear();
			  break;        
		  case "Group":
			  drawing.group();
			  break; 
		  case "Degroup":
			  drawing.degroup();
			  break; 
		  case "Duplicate":
			  drawing.duplicate();
			  break; 
		  case "Circle":
			  drawing.addShape(new Circle());
			  break;
		  case "Rectangle":
			  drawing.addShape(new Rectangle());
			  break; 
		  case "Undo":
			  //Nothing
			  break;
		  case "Redo":
			  //Nothing
			  break; 
		  default: 
			  System.out.println("Erreur Patern Command (Redo)");
		}
		//c.execute();
	}
	
	public String name(){
		return "Redo";
	}
}
