/**
 * 
 */
package Aufgabe1;

/**
 * @author admin
 *
 */
public class Point2D extends Geometry implements Comparable{
	
	private double x;
	private double y;

	public Point2D(double x, double y) {
		super(2);
		this.x = x;
		this.y = y;
	}

	@Override
	public double volume() {
		return 0;
	}

	@Override
	public Geometry encapsulate(Geometry other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

}
