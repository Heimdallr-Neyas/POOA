package drawing;

public class CommandAddTextButton implements CommandInterface {

	Drawing drawing;
	String value;
	
	public CommandAddTextButton(Drawing drawing, String value){
		this.drawing = drawing;
		this.value = value;		
	}
	
	public void execute() {
		drawing.clear();
		System.out.println("Texte ajouté");
	}

	public String name(){
		return "add Text";
	}
}