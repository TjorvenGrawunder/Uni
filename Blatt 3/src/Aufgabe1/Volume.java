/**
 * 
 */
package Aufgabe1;

import java.util.ArrayList;

/**
 * @author admin
 *
 */
public class Volume extends Geometry implements Comparable{
	
	private Point p1;
	private Point p2;
	
	public Volume(Point p1, Point p2) {
		super(p1.dimensions());
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public int compareTo(Object o) {
		int value = -10;
		if(this.volume() < ((Geometry) o).volume()) {
			value = -1;
		}else if(this.volume() == ((Geometry) o).volume()) {
			value = 0;
		}else if(this.volume() > ((Geometry) o).volume()) {
			value = 1;
		}
		return value;
	}

	@Override
	public double volume() {
		ArrayList<Double> dimensionsP1 = p1.getDimensions();
		ArrayList<Double> dimensionsP2 = p2.getDimensions();
		double product = 0;
		for(int i = 0; i < this.dimensions(); i++) {
			if(product == 0) {
				product += Math.abs(dimensionsP1.get(i)-dimensionsP2.get(i));
			}else {
				product *= Math.abs(dimensionsP1.get(i)-dimensionsP2.get(i));
			}
		}
		return product;
	}

	@Override
	public Geometry encapsulate(Geometry other) {
		ArrayList<Double> dimensionsP1Rec1 = p1.getDimensions();
		ArrayList<Double> dimensionsP2Rec1 = p2.getDimensions();
		ArrayList<Double> dimensionsP1Rec2 = ((Volume) other).getP1().getDimensions();
		ArrayList<Double> dimensionsP2Rec2 = ((Volume) other).getP2().getDimensions();
		ArrayList<Double> dimensionsLowCoords = new ArrayList<Double>();
		ArrayList<Double> dimensionsHighCoords = new ArrayList<Double>();
		Point p1 = this.p1;
		Point p2 = this.p2;
		if(other.dimensions() == this.dimensions()) {
			//Punkt und Volumen
			if(other.volume() != 0) {
				for(int i = 0; i < this.dimensions(); i++) {
					double min = dimensionsP1Rec1.get(i);
					if(min > dimensionsP2Rec1.get(i)) {
						min = dimensionsP2Rec1.get(i);
						if(min > dimensionsP1Rec2.get(i)) {
							min = dimensionsP1Rec2.get(i);
							if(min > dimensionsP2Rec2.get(i)) {
								min = dimensionsP2Rec2.get(i);
							}
						}
					}
					dimensionsLowCoords.add(min);
				}
				for(int i = 0; i < this.dimensions(); i++) {
					double max = dimensionsP1Rec1.get(i);
					if(max < dimensionsP2Rec1.get(i)) {
						max = dimensionsP2Rec1.get(i);
						if(max < dimensionsP1Rec2.get(i)) {
							max = dimensionsP1Rec2.get(i);
							if(max < dimensionsP2Rec2.get(i)) {
								max = dimensionsP2Rec2.get(i);
							}
						}
					}
					dimensionsHighCoords.add(max);
				}
				p1.setDimensions(dimensionsHighCoords);
				p2.setDimensions(dimensionsLowCoords);
			}else {
				
			}
			Volume vol = new Volume(p1, p2);
			return vol;
		}else {
			return null;
		}
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

}
