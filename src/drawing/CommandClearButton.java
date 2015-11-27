package drawing;

public class CommandClearButton implements CommandInterface {

	Drawing drawing;
	
	public CommandClearButton(Drawing drawing){
		this.drawing = drawing;
	}
	
	public void execute() {
		drawing.clear();
		System.out.println("Zone de dessin nettoyée");
	}

	public String name(){
		return "Clear";
	}
}
