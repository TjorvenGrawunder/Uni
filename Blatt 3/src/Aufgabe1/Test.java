/**
 * 
 */
package Aufgabe1;

import java.util.ArrayList;

/**
 * @author admin
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point2D p1 = new Point2D(4, 8);
		Point2D p2 = new Point2D(2, 4);
		Rectangle rec1 = new Rectangle(p1, p2);
		Point2D p3 = new Point2D(10, 15);
		Point2D p4 = new Point2D(5, 10);
		Rectangle rec2 = new Rectangle(p3, p4);
		System.out.println("2D:");
		testVolume(rec1, 8);
		testCompare(rec2, p4);
		testEncapsulate(rec1, rec2, p2, p3);
		System.out.println("nD:");
		ArrayList<Double> dimensionsP5 = new ArrayList<Double>();
		dimensionsP5.add(2.0);
		dimensionsP5.add(4.0);
		dimensionsP5.add(2.0);
		ArrayList<Double> dimensionsP6 = new ArrayList<Double>();
		dimensionsP6.add(4.0);
		dimensionsP6.add(2.0);
		dimensionsP6.add(4.0);
		Point p5 = new Point(dimensionsP5);
		Point p6 = new Point(dimensionsP6);
		Volume vol1 = new Volume(p5, p6);
		ArrayList<Double> dimensionsP7 = new ArrayList<Double>();
		dimensionsP7.add(4.0);
		dimensionsP7.add(8.0);
		dimensionsP7.add(4.0);
		ArrayList<Double> dimensionsP8 = new ArrayList<Double>();
		dimensionsP8.add(8.0);
		dimensionsP8.add(4.0);
		dimensionsP8.add(8.0);
		Point p7 = new Point(dimensionsP7);
		Point p8 = new Point(dimensionsP8);
		Volume vol2 = new Volume(p7, p8);
		testVolume(vol1, 8);
		testVolumeCompare(vol2, vol1);
		testVolumeEncapsulate(vol1, p6);
	}
	
	public static void testVolume(Geometry object, double expected) {
		if(object.volume() == expected) {
			System.out.println("Volume Test erfolgreich");
		}else {
			System.out.println("Fehler im Volume Test");
		}
	}
	
	public static void testCompare(Rectangle object1, Geometry object2) {
		if(object1.compareTo(object2) == 1) {
			System.out.println("Compare Test erfolgreich");
		}else {
			System.out.println("Fehler im Compare Test");
		}
	}
	public static void testVolumeCompare(Volume object1, Geometry object2) {
		if(object1.compareTo(object2) == 1) {
			System.out.println("Compare Test erfolgreich");
		}else {
			System.out.println("Fehler im Compare Test");
		}
	}
	
	public static void testEncapsulate(Rectangle object1, Rectangle object2, Point2D p1, Point2D p2) {
		Geometry rec = object1.encapsulate(object2);
		if((((Rectangle) rec).getP1().getX() == p1.getX() || ((Rectangle) rec).getP2().getX() == p1.getX()) && (((Rectangle) rec).getP1().getY() == p1.getY() || ((Rectangle) rec).getP2().getY() == p1.getY())) {
			if((((Rectangle) rec).getP1().getX() == p2.getX() || ((Rectangle) rec).getP2().getX() == p2.getX()) && (((Rectangle) rec).getP1().getY() == p2.getY() || ((Rectangle) rec).getP2().getY() == p2.getY())) {
				System.out.println("Test Encapsulate erfolgreich");
			}
		}else {
			System.out.println("Test Encapsulate fehlgeschlagen");
		}
		
	}
	
	public static void testVolumeEncapsulate(Volume object1, Point object2) {
		Geometry vol = object1.encapsulate(object2);
		ArrayList<Double> dimensionsP1 = ((Volume) vol).getP1().getDimensions();
		ArrayList<Double> dimensionsP2 = ((Volume) vol).getP2().getDimensions();
		ArrayList<Double> dimensionsObject2 = object2.getDimensions();
		for(int i = 0; i < vol.dimensions(); i++) {
			System.out.println("P1: " + dimensionsP1.get(i));
			System.out.println("P2: " + dimensionsP2.get(i));
		}
		if((object1.getP1().getDimensions().equals(dimensionsP1) || object1.getP1().getDimensions().equals(dimensionsP2)) && (dimensionsObject2.equals(dimensionsP1) || dimensionsObject2.equals(dimensionsP2))) {
			System.out.println("Test Encapsulate erfolgreich");
		}else {
			System.out.println("Test Encapsulate fehlgeschlagen");
		}
		
	}
}
