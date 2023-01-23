	package geometry;
	
	import java.awt.Color;
	import java.awt.Graphics;
	
	public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public void setSelected(boolean sel) {
		this.selected=sel;
	}
	
	public boolean isSelected() {
	return selected;
	}
	public Line(Point startPoint, Point endPoint)
	{
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		setSelected(selected);
	
	}
	public Line (Point startPoint, Point endPoint, boolean selected, Color col )
	{
		this(startPoint,endPoint,selected);
		setColor(col);
	}
	
	
	public double Length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public Point middlePoint() {
		int middleByX=( (this.startPoint.getX() + this.endPoint.getX() ) / 2);
		int middleByY=( (this.startPoint.getY() + this.endPoint.getY() ) / 2);
		Point middlePoint= new Point(middleByX, middleByY, false);
		return middlePoint;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		this.startPoint.moveBy(byX, byY);
		this.endPoint.moveBy(byX, byY);
		
	}
	
	@Override
	public boolean contains(int x, int y) {
		if ((startPoint.distance(x, y) + endPoint.distance(x, y)) - Length() <= 0.05) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
		
		if (isSelected()) {
			g.setColor(Color.RED);
			g.drawRect(this.startPoint.getX() - 3, this.startPoint.getY() - 3, 6, 6);
			g.drawRect(this.endPoint.getX() - 3, this.endPoint.getY() - 3, 6, 6);
			g.drawRect(middlePoint().getX() - 3, middlePoint().getY() - 3, 6, 6);
		}
		
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line pomocna = (Line) obj;
			if (this.startPoint.equals(pomocna.getStartPoint()) &&
					this.endPoint.equals(pomocna.getEndPoint())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public String toString() {
		return startPoint + "-->" + endPoint; 
	}
	
	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int) (this.Length() - ((Line) o).Length()); 
		}
		return 0;
	}
	
	}
