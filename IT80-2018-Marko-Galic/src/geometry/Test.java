package geometry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Point p= new Point(5, 7, false);
      Point p1= new Point(7, 12, true);
      Circle c = new Circle(25,p1);
      Circle c1 = new Circle(25,p1);
      boolean a;
      a= c.equals(p);
      System.out.println(a);
      System.out.println(c.equals(c1));
      System.out.println(c.area());
     
      
	}

}
