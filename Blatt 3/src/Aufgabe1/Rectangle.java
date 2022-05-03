/**
 * 
 */
package Aufgabe1;

/**
 * @author admin
 *
 */
public class Rectangle extends Geometry implements Comparable{
	
	private Point2D p1;
	private Point2D p2;

	public Rectangle(Point2D p1, Point2D p2) {
		super(2);
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public int compareTo(Object o) {
		int compare = -10;
		if(this.volume() < ((Geometry) o).volume()) {
			compare = -1;
		}else if(this.volume() == ((Geometry) o).volume()) {
			compare = 0;
		}else if(this.volume() > ((Geometry) o).volume()) {
			compare = 1;
		}
		// TODO Auto-generated method stub
		return compare;
	}

	@Override
	public double volume() {
		double line1 = Math.abs(p1.getX() - p2.getX());
		double line2 = Math.abs(p1.getY() - p2.getY());
		return line1 * line2;
	}

	@Override
	public Geometry encapsulate(Geometry other) {
		Point2D p1 = null;
		Point2D p2 = null;
		if(other.dimensions() != 2) {
			return null;
		}else {
			if(other.volume() != 0) {
				Rectangle tempRec = (Rectangle) other;
				//unten links
				if(tempRec.getUpperRightCorner().getX() < this.getUpperRightCorner().getX() && tempRec.getUpperRightCorner().getY() < this.getUpperRightCorner().getY()) {
					p1 = this.getUpperRightCorner();
					p2 = tempRec.getLowerLeftCorner();
				//oben rechts
				}else if(tempRec.getUpperRightCorner().getX() > this.getUpperRightCorner().getX() && tempRec.getUpperRightCorner().getY() > this.getUpperRightCorner().getY()) {
					p1 = tempRec.getUpperRightCorner();
					p2 = this.getLowerLeftCorner();
				//unten rechts
				}else if(tempRec.getUpperRightCorner().getX() < this.getUpperRightCorner().getX() && tempRec.getUpperRightCorner().getY() > this.getUpperRightCorner().getY()) {
					p1 = tempRec.getLowerLeftCorner();
					p1.setX(tempRec.getUpperRightCorner().getX());
					p2 = this.getLowerLeftCorner();
					p2.setY(this.getUpperRightCorner().getY());
				//oben links
				}else if(tempRec.getUpperRightCorner().getX() > this.getUpperRightCorner().getX() && tempRec.getUpperRightCorner().getY() < this.getUpperRightCorner().getY()) {
					p1 = tempRec.getLowerLeftCorner();
					p1.setY(tempRec.getUpperRightCorner().getX());
					p2 = this.getLowerLeftCorner();
					p2.setX(this.getUpperRightCorner().getX());
				}
			}else {
				p1 = (Point2D) other;
				//Oberhalb
				if(p1.getY() < this.getUpperRightCorner().getY()) {
					//in der Mitte
					if(p1.getX() < this.getUpperRightCorner().getX() && p1.getX() > this.getLowerLeftCorner().getX()) {						
						p2 = this.getUpperRightCorner();
						p2.setY(p1.getY());
						p1 = this.getLowerLeftCorner();
					//links
					}else if(p1.getX() < this.getLowerLeftCorner().getX()) {
						p2 = this.getLowerLeftCorner();
						p2.setX(this.getUpperRightCorner().getX());
					//rechts
					}else if(p1.getX() > this.getUpperRightCorner().getX()) {
						p2 = this.getLowerLeftCorner();
					}
				//unterhalb
				}else if(p1.getY() < this.getLowerLeftCorner().getY()) {
					//in der Mitte
					if(p1.getX() < this.getUpperRightCorner().getX() && p1.getX() > this.getLowerLeftCorner().getX()) {						
						p2 = this.getLowerLeftCorner();
						p2.setY(p1.getY());
						p1 = this.getUpperRightCorner();
					//links
					}else if(p1.getX() < this.getLowerLeftCorner().getX()) {
						p2 = this.getUpperRightCorner();
					//rechts
					}else if(p1.getX() > this.getUpperRightCorner().getX()) {
						p2 = this.getLowerLeftCorner();
						p2.setY(this.getUpperRightCorner().getY());
					}
				//mittig
				}else {
					//in der Mitte
					if(p1.getX() < this.getUpperRightCorner().getX() && p1.getX() > this.getLowerLeftCorner().getX()) {						
						p2 = this.getLowerLeftCorner();
						p1 = this.getUpperRightCorner();
					//links
					}else if(p1.getX() < this.getLowerLeftCorner().getX()) {
						p2 = this.getUpperRightCorner();
						double tmpX = p1.getX();
						p1 = this.getLowerLeftCorner();
						p1.setX(tmpX);
					//rechts
					}else if(p1.getX() > this.getUpperRightCorner().getX()) {
						p2 = this.getLowerLeftCorner();
						double tmpX = p1.getX();
						p1 = this.getUpperRightCorner();
						p1.setX(tmpX);
					}
				}
			}
			Rectangle rec = new Rectangle(p1, p2);
			return rec;
		}
	}
	
	public Point2D getUpperRightCorner() {
		Point2D upperRight = new Point2D(0, 0);
		if(this.getP1().getY() < this.getP2().getY()) {
			if(this.getP1().getX() < this.getP2().getX()) {
				upperRight.setX(this.getP2().getX());
				upperRight.setY(this.getP2().getY());
			}else {
				upperRight.setX(this.getP1().getX());
				upperRight.setY(this.getP2().getY());
			}
		}
		if(this.getP1().getY() > this.getP2().getY()) {
			if(this.getP1().getX() > this.getP2().getX()) {
				upperRight.setX(this.getP1().getX());
				upperRight.setY(this.getP1().getY());
			}else {
				upperRight.setX(this.getP2().getX());
				upperRight.setY(this.getP1().getY());
			}
		}
		return upperRight;
		
	}
	
	public Point2D getLowerLeftCorner() {
		Point2D lowerLeft = new Point2D(0, 0);
		if(this.getP1().getY() < this.getP2().getY()) {
			if(this.getP1().getX() < this.getP2().getX()) {
				lowerLeft.setX(this.getP1().getX());
				lowerLeft.setY(this.getP1().getY());
			}else {
				lowerLeft.setX(this.getP2().getX());
				lowerLeft.setY(this.getP1().getY());
			}
		}
		if(this.getP1().getY() > this.getP2().getY()) {
			if(this.getP1().getX() > this.getP2().getX()) {
				lowerLeft.setX(this.getP2().getX());
				lowerLeft.setY(this.getP2().getY());
			}else {
				lowerLeft.setX(this.getP1().getX());
				lowerLeft.setY(this.getP2().getY());
			}
		}
		return lowerLeft;
		
	}

	/**
	 * @return the p1
	 */
	public Point2D getP1() {
		return p1;
	}

	/**
	 * @return the p2
	 */
	public Point2D getP2() {
		return p2;
	}

}
