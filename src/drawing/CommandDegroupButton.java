package drawing;

public class CommandDegroupButton implements CommandInterface {


	Drawing drawing;
	public CommandDegroupButton(Drawing _drawing){
		drawing = _drawing;
	}
	
	public void execute() {
		drawing.degroup();
		System.out.println("Groupe supprimé");
	}
	public String name(){
		return "Degroup";
	}
}
