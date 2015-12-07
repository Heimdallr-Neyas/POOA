package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {

	int width;
	int height;
	Color color;
	
	public Rectangle(){
		Point _origin = new Point((int)20, (int)20);
		int _width = 50;
		int _height = 50;
		Color _color = Color.BLUE;
		this.origin = _origin;
		this.width = _width;
		this.height = _height;
		this.color = _color;
	}
	
	public Rectangle(Point origin, int width, int height, Color color){
		this.origin = new Point(origin.x + ( width / 2 ), origin.y + ( height / 2 ));
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public boolean isOn(Point p) {
		return(p.x > origin.x-(width/2) && p.x < origin.x+(width/2) && p.y > origin.y-(height/2) && p.y < origin.y+(height/2));
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(origin.x-(width/2), origin.y-(height/2), width, height);
		g.setColor(Color.BLACK);
		g.drawRect(origin.x-(width/2), origin.y-(height/2), width, height);
	}
	
	public Shape clone(){
		Point o = origin;
		o.x = origin.x-(width/2);
		o.y = origin.y-(height/2);
		return new Rectangle(this.origin, this.width, this.height, this.color);
	}
}
