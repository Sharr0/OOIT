	package geometry;
	
	import java.awt.Color;
	import java.awt.Graphics;
	
	public class Point extends Shape {
	
	private int x;
	private int y;	
	private boolean selected;
	private double x1;
	private double y2;
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Point (int x , int y)
	{
		this.x=x;
		this.y=y;
	}
	public Point(int x, int y, boolean sel, Color col) {
		this(x,y,sel);
		setColor(col);
	}
	public Point (int x, int y, boolean sel) {
		this.x=x;
		this.y=y;
		setSelected(sel);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	 public double getX1() {
		return x1;
	}
	
	public void setX1(double x1) {
		this.x1 = x1;
	}
	
	public double getY2() {
		return y2;
	}
	
	public void setY2(double x2) {
		this.y2 = x2;
	}
	
	public double distance(int x, int y) {
		 double dx= this.x - x;
		 double dy= this.y - y;
		 double d= Math.sqrt(dx*dx + dy* dy);
		 return d; 
	 }
	 
	 public double distance (Point a)
	 {
		 double dx= a.getX1()-this.getX1();
		 double dy= a.getY2()-this.getY2();
		 return Math.sqrt(dx*dx + dy*dy);
	 }
	 
	 public boolean equals (Object obj) {
		 if (obj instanceof Point)
		 {
			 Point pomocna = (Point) obj;
			 if(this.x == pomocna.getX() && this.y == pomocna.getY())
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
		 }
		 else {
			 return false;
		 }
		 
	 }
	
	 public String toString() {
			return "(" + x + ", " + y + ")";
		}
	
	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y += byY;
		
	}
	
	@Override
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 3;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.x - 2, this.y, this.x + 2, this.y);
		g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
		
		if (isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect(this.x - 3, this.y - 3, 6, 6);
		}
		
	}
	public int compareTo(Object o) {
		if (o instanceof Point) {
			Point p = new Point(0, 0);
			return (int) (this.distance(p.getX(), p.getY()) - ((Point) o).distance(p.getX(), p.getY()));
		}
		return 0;
	}
	
	}
