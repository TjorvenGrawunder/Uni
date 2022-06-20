package Aufgabe1;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Compares Integer instances in reverse order.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class IntegerReverseComparator implements Comparator<Integer>, Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = -5176343848824731231L;

@Override
   public int compare(Integer o1, Integer o2) {
      return o2.compareTo(o1);
   }

}
