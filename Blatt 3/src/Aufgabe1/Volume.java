/**
 * 
 */
package Aufgabe1;

/**
 * @author admin
 *
 */
public class Volume extends Geometry implements Comparable{
	
	private Point p1;
	private Point p2;
	
	public Volume(Point p1, Point p2) {
		super(p1.dimensions());
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Geometry encapsulate(Geometry other) {
		// TODO Auto-generated method stub
		return null;
	}

}
