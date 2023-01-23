	package geometry;
	
	import java.awt.Color;
	import java.awt.Graphics;
	
	public class Circle extends SurfaceShape{
	private int radius;
	private Point center;
	private boolean selected;
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	public Circle() {
		
	}
	
	public Circle (int radius, Point p)
	{
		this.radius = radius;
		this.center = p;
	}
	
	public Circle(int radius, Point p , boolean selected) {
		this.radius = radius;
		this.center = p;
		this.selected = selected;
	}
	public Circle(int radius, Point p , boolean selected, Color col) {
		this(radius,p,selected);
		setColor(col);
	}
	public Circle(int radius, Point p , boolean selected, Color col,Color innerColor) {
		this(radius,p,selected,col);
		setColor(innerColor);
	}
	public boolean equals (Object obj) {
		if(obj instanceof Circle) {
		Circle pomocna = (Circle) obj;
		if(this.radius == pomocna.getRadius() && this.center.equals(pomocna.getCenter()))
		{
			return true;
		}
		else {
			return false;
		}
	}
		else {
		return false;
	}
	}
	
	public double area() {
		return this.radius * this.radius * Math.PI;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		this.center.moveBy(byX, byY);
	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(this.center.getX() - radius	 + 1, this.center.getY() - radius + 1, radius*2 - 2, radius*2 - 2);
		
	}
	
	@Override
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius;
	}
	
	public boolean contains(Point p) {
		return center.distance(p.getX(), p.getY()) <= radius;
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(this.center.getX() - radius	, this.center.getY() - radius, radius*2, radius*2); 
		this.fill(g);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.center.getX() - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() - radius - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() + radius - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() - 3, this.center.getY() - radius - 3, 6, 6);
			g.drawRect(this.center.getX() - 3, this.center.getY() + radius - 3, 6, 6);
		}
		
	}
	
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (this.radius - ((Circle) o).radius);
		}
		return 0;
	}
			
	public String toString() {
		return "Radius = " + radius + ", Point = " + center.getX()  + ' ' + center.getY();
	}
	
	
	
	
	}
