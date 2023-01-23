package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public Drawing() {
		setBackground(Color.WHITE);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		
		Point p = new Point(50, 60, false, Color.RED);
		// p.draw(g);
		
		Line l = new Line(new Point(300, 250), new Point(340, 210), true, Color.MAGENTA);
		// l.draw(g);
		
		Circle c = new Circle(40, new Point(450, 120), true, Color.BLACK, Color.RED);
		// c.draw(g);
		
		Rectangle r = new Rectangle(new Point(300, 300), 120, 170, true, Color.RED, Color.YELLOW);
		// r.draw(g);
		
		Donut d = new Donut(new Point(520, 400), 50, 30, false, Color.RED, Color.GREEN);
		// d.draw(g);
		
		// ArrayList
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p);
		shapes.add(l);
		shapes.add(c);
		shapes.add(r);
		shapes.add(d);
		
		Iterator<Shape> it = shapes.iterator();
		// selektovanost svakog oblika
		while(it.hasNext()) {
			System.out.println("Selected: " + it.next().isSelected());
		}
		
		// iscrtati treci element iz liste shapes
		// shapes.get(2).draw(g);
		
		// iscrtati poslednji element iz liste
		// shapes.get(shapes.size() - 1).draw(g);
		
		// dodati i iscrtati novu liniju l1 u listu tako da ona bude 4. element u listi
		Line l1 = new Line(new Point(30, 30), new Point(60, 60), false, Color.BLACK);
		shapes.add(3, l1);
		// shapes.get(3).draw(g);
		
		// ukloniti drugi element liste
		shapes.remove(1);
		
		// setovati svaki oblik iz liste shapes kao selektovan pomocu iteratora it
		while (it.hasNext()) {
			it.next().setSelected(true);
		}
		
		// iscrtati svaki oblik iz shapes liste pomocu for each petlje
		for(Shape s : shapes) {
			s.draw(g);
	}
		
		// setujemo kao selektovane samo povrsinske oblike
		for(Shape s : shapes) {
			s.setSelected(true);
		}
		
		for(Shape s : shapes) {
			s.draw(g);
		}
		
	}
	
}
