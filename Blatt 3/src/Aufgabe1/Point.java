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

	public Point(ArrayList<Double> dimensions) {
		super(dimensions.size());
		for(int i = 0; i < dimensions.size(); i++) {
			this.dimensions.add(dimensions.get(i));
		}
		
	}

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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
