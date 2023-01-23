	package geometry;
	
	import java.awt.Color;
	import java.awt.Graphics;
	
	public class Rectangle extends SurfaceShape{
	private int sirina;
	private int visina;
	private Point upperLeftPoint;
	private boolean selected;
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public int getSirina() {
		return sirina;
	}
	public void setSirina(int sirina) {
		this.sirina = sirina;
	}
	public int getVisina() {
		return visina;
	}
	public void setVisina(int visina) {
		this.visina = visina;
	}
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	
	public double area() {
		return visina*sirina;
	}
	public Rectangle(Point p, int a, int b, boolean selected, Color color) {
		this(p, a, b, selected);
		setColor(color);
	}
	public Rectangle(Point p, int a, int b, boolean selected, Color col , Color innerCol) {
		this(p,a,b,selected,col);
		setInnerColor(innerCol);
	}
	public Rectangle (Point p, int a, int b, boolean selected) {
		this.upperLeftPoint=p;
		this.sirina=a;
		this.visina=b;
		setSelected(selected);
	}
	public Rectangle (Point p, int a, int b) {
		this.upperLeftPoint=p;
		this.sirina=a;
		this.visina=b;
	}
	public boolean equals (Object obj) {
		if(obj instanceof Rectangle){
			Rectangle pomocna = (Rectangle) obj;
			if(this.upperLeftPoint.equals(pomocna.getUpperLeftPoint())
					&& this.visina == pomocna.getVisina()
					&& this.sirina == pomocna.getSirina())
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
	@Override
	public void moveBy(int byX, int byY) {
		this.upperLeftPoint.moveBy(byX, byY);
		
	}
	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.upperLeftPoint.getX()+1, this.getUpperLeftPoint().getY()+1, sirina-1, visina-1);
	}
	
	@Override
	public boolean contains(int x, int y) {
		if (this.getUpperLeftPoint().getX() <= x &&
				this.getUpperLeftPoint().getY() <= y &&
				x <= this.getUpperLeftPoint().getX() + visina &&
				y <= this.getUpperLeftPoint().getY() + sirina) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(Point p) {
		if (this.getUpperLeftPoint().getX() <= p.getX() &&
				this.getUpperLeftPoint().getY() <= p.getY() &&
				p.getX() <= this.getUpperLeftPoint().getX() + sirina &&
				p.getY() <= this.getUpperLeftPoint().getY() + visina) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), this.sirina, this.visina);
		
		this.fill(g);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() + getSirina() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() + getVisina() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() + getSirina() - 3, getUpperLeftPoint().getY() + getVisina() - 3, 6, 6);
		}
		
	}
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (int) (this.area() - ((Rectangle) o).area());
		}
		return 0;
	}
	
	public String toString() {
		return "Upper left point=" + upperLeftPoint + ", width=" + sirina + ", height=" + visina;
	}
	
	
	}
