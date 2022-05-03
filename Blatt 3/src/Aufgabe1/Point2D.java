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
	
	/*
	 * 2D-Punkt. Der Super Konstruktor wird immer mit 2 aufgerufen, da keine andere Dimension
	 * möglich ist. Die Koordinaten x und y werden in Variablen gespeichert.
	 * @param x, y "Koordinaten des Point"
	 */
	public Point2D(double x, double y) {
		super(2);
		this.x = x;
		this.y = y;
	}
	/*
	 * Volumen eines Punktes ist immer 0.
	 */
	@Override
	public double volume() {
		return 0;
	}
	
	/*
	 * Ein Geometry wird übergeben und eine neue Flaeche, die den Punkt und das Geometrie Objekt 
	 * umfasst soll erzeugt werden. Im Falle eines Rechtecks kann die bereits beim Rechteck genutzte
	 * Methode benutzt werden, da dort bereits der Fall zwischen Rechteck und Punkt bearbeitet wurde.
	 * Falls ein Punkt uebergeben wird, wird ein neues Rechteck mit den beiden Punkten erzeugt.
	 * Die Art des Geometry Objekts wird durch das Volumen bestimmt. Falls das Volumen 0 ist handelt
	 * es sich um einen Punkt.
	 * 
	 * @param other Geometry mit der verglichen wird.
	 * @return Rectangle neues Rechteck, welches beide Objekte umfasst.
	 */
	@Override
	public Geometry encapsulate(Geometry other) {
		if(other.dimensions() != 2) {
			return null;
		}else {
			if(other.volume() != 0) {
				return ((Rectangle)other).encapsulate(this);
			}else {
				return new Rectangle(this, (Point2D)other);
			}
		}
		
	}
	/*
	 * Vergleich zwischen einem Punkt und einem Objekt. Da der Punkt Volumen 0 hat und ein Volumen
	 * nicht negativ sein kann wird nur auf gleich und groesser überprueft.
	 * @return 0: gleichgroß; 1: groesser
	 */
	@Override
	public int compareTo(Object o) {
		if(((Geometry) o).volume() == 0) {
			return 0;
		}else {
			return 1;
		}
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
