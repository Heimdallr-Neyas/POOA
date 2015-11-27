package drawing;


public class CommandDuplicateButton implements CommandInterface {
	
	Drawing drawing;
	
	public CommandDuplicateButton(Drawing _drawing){
		drawing = _drawing;
	}
	
	public void execute() {
		drawing.duplicate();
	}

	public String name(){
		return "Duplicate";
	}
}
