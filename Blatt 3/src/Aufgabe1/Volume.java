/**
 * 
 */
package Aufgabe1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author admin
 *
 */
public class Volume extends Geometry implements Comparable{
	
	private Point p1;
	private Point p2;
	/*
	 * Ein Volume setzt sich aus zwei n-dimensionalen Punkten zusammen
	 */
	public Volume(Point p1, Point p2) {
		super(p1.dimensions());
		this.p1 = p1;
		this.p2 = p2;
	}
	/*
	 * (non-Javadoc)
	 * @see Aufgabe1.Comparable#compareTo(java.lang.Object)
	 */
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
	/*
	 * (non-Javadoc)
	 * Das Volumen wird dadurch berechnet, dass die die einzelnen Wege von einem Punkt weg berechnet werden und miteinander
	 * multipliziert werden.
	 * @see Aufgabe1.Geometry#volume()
	 */
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
	/*
	 * (non-Javadoc)
	 * @see Aufgabe1.Geometry#encapsulate(Aufgabe1.Geometry)
	 * Die einzelnen Koordinaten jeder Dimension werden in einer Liste sortiert, wodurch Maximum und Minimum ermittelt werden.
	 * Aus den maximalen und minimalen Koordinaten setzen sich dann zwei Punkte zusammen, welche ein neues Volume generieren.
	 */
	@Override
	public Geometry encapsulate(Geometry other) {
		if(other.dimensions() == this.dimensions()) {
			ArrayList<Double> dimensionsP1 = p1.getDimensions();
			ArrayList<Double> dimensionsP2 = p2.getDimensions();
			ArrayList<Double> maxList = new ArrayList<Double>();
			ArrayList<Double> minList = new ArrayList<Double>();
			if(other.volume() == 0) {
				ArrayList<Double> dimensionsOther = ((Point) other).getDimensions();
				for(int i = 0; i < this.dimensions(); i++) {
					ArrayList<Double> dimensionToSort = new ArrayList<Double>();
					dimensionToSort.add(dimensionsP1.get(i));
					dimensionToSort.add(dimensionsP2.get(i));
					dimensionToSort.add(dimensionsOther.get(i));
					Collections.sort(dimensionToSort);
					maxList.add(dimensionToSort.get(dimensionToSort.size()-1));
					minList.add(dimensionToSort.get(0));
				}
				return new Volume(new Point(maxList), new Point(minList));
			}else {
				ArrayList<Double> dimensionsOtherP1 = ((Volume) other).getP1().getDimensions();
				ArrayList<Double> dimensionsOtherP2 = ((Volume) other).getP2().getDimensions();
				for(int i = 0; i < this.dimensions(); i++) {
					ArrayList<Double> dimensionToSort = new ArrayList<Double>();
					dimensionToSort.add(dimensionsP1.get(i));
					dimensionToSort.add(dimensionsP2.get(i));
					dimensionToSort.add(dimensionsOtherP1.get(i));
					dimensionToSort.add(dimensionsOtherP2.get(i));
					Collections.sort(dimensionToSort);
					maxList.add(dimensionToSort.get(dimensionToSort.size()-1));
					minList.add(dimensionToSort.get(0));
				}
				return new Volume(new Point(maxList), new Point(minList));
				
			}
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
