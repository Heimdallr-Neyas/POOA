package drawing;

import java.awt.Color;

public class CommandRectangleButton extends ShapeButtonListener {

	public CommandRectangleButton(Drawing drawing){
		super(drawing);
	}
	
	@Override
	protected Shape createShape() {
		double width = Math.abs(destination.getX()-origin.getX());
		double height = Math.abs(destination.getY()-origin.getY());
		Rectangle r = new Rectangle(origin, (int)width, (int)height, Color.BLUE);
		return r;
	}
	
	public String name(){
		return "Rectangle";
	}
}
