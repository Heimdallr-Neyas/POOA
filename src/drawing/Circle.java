package drawing;

import java.awt.*;

public class Circle extends Shape{
	private Color color;
	
	private double radius;
	
	public Circle(){
		Point _origin = new Point((int)20, (int)20);
		double _radius = 50.0;
		Color _color = Color.RED;
		this.origin = _origin;
		this.radius = _radius;
		this.color = _color;
	}
	
	public Circle(Point origin, double radius, Color color){
		this.origin = origin;
		this.radius = radius;
		this.color = color;
	}
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval((int)(origin.getX()-radius), (int)(origin.getY()-radius), (int)(2*radius), (int)(2*radius));
		g.setColor(Color.BLACK);
		g.drawOval((int)(origin.getX()-radius), (int)(origin.getY()-radius), (int)(2*radius), (int)(2*radius));
	}
	
	public boolean isOn(Point p) {
		return distanceToCenter(p)<radius;		
	}
	
	private double distanceToCenter(Point p){
		return this.origin.distance(p);
	}
	
	public Shape clone(){
		return new Circle(this.origin, this.radius, this.color);
	}

}
