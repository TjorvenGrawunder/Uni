/**
 * 
 */
package Aufgabe1;

import java.util.ArrayList;

/**
 * @author admin
 *
 */
public class Point extends Geometry implements Comparable{
	
	private ArrayList<Double> dimensions = new ArrayList<Double>();
	/*
	 * Ein neuer n-dimensionaler Punkt wird erzeugt. Der Super Konstruktor wird mit der Anzahl der
	 * Dimensionen aufgerufen und die übergebende Liste wird in einer Liste der Klasse gespeichert.
	 */
	public Point(ArrayList<Double> dimensions) {
		super(dimensions.size());
		for(int i = 0; i < dimensions.size(); i++) {
			this.dimensions.add(dimensions.get(i));
		}
		
	}
	/*
	 * Volumen der Geometry wird ausgegeben. Bei einem Point immer 0.
	 */
	@Override
	public double volume() {
		return 0;
	}

	@Override
	public Geometry encapsulate(Geometry other) {
		if(other.dimensions() != this.dimensions()) {
			return null;
		}
		return null;
	}
	/*
	 * Das Volumen des Punktes wird mit einem anderen Objekt verglichen. Falls das Volumen des 
	 * anderen Objekts nicht 0 ist wird 1 für groeßer ausgegeben. Ansonsten 0.
	 * -1: kleiner
	 * 0: gleich
	 * 1: groeßer
	 */
	@Override
	public int compareTo(Object o) {
		if(((Geometry) o).volume() == 0) {
			return 0;
		}else {
			return 1;
		}
	}

	public ArrayList<Double> getDimensions() {
		return dimensions;
	}

	public void setDimensions(ArrayList<Double> dimensions) {
		this.dimensions = dimensions;
	}

}
