package drawing;

public class CommandGroupButton implements CommandInterface {
	
	Drawing drawing;
	
	public CommandGroupButton(Drawing _drawing){
		drawing = _drawing;
	}
	
	public void execute() {
		drawing.group();
		System.out.println("Groupe crée");
	}

	public String name(){
		return "Group";
	}
}
