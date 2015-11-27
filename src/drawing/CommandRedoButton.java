package drawing;

public class CommandRedoButton implements CommandInterface{
	Drawing drawing;
	CommandInterface c;
	
	public CommandRedoButton(Drawing _drawing, CommandInterface t){
		drawing = _drawing;
		c = t;
	}
	
	public void execute() {
		c.execute();
	}
	
	public String name(){
		return "Redo";
	}
}
