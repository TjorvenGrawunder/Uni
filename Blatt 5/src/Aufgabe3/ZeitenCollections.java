package Aufgabe3;

import java.util.Collection;

/** 
 * Eine abstrakte Klasse, die eine Methode vererbt, in der die durchschnittlichen Laufzeiten der Collections ArrayList, 
 * LinkedList und HashSet in Bezug auf die Methoden add(), remove() und contains()
 * ermittelt werden; auch wird getInstance() als zu implementierende Methode in den
 * Subklassen vorgeschrieben, da dadurch die Methode performanceTest() fuer einer
 * bestimmten Collection(ArrayList, LinkedList oder HashSet) durchgefuehrt werden kann
 * 
 * 
 * @author ajeme
 *
 */

public abstract class ZeitenCollections {

	/**
	 * Die Methode performanceTest() misst fuer eine bestimmte mit Integern gefuellte
	 * Collection die durchschnittliche Laufzeit der Methoden add(), remove() und
	 * contains(); die Collections werden mit 10000 Integern gefuellt und es werden
	 * 1000 Durchlaeufe gemacht; die einzelnen Zeiten in den Durchlaeufen werden
	 * addiert und dann durch die Anzahl der gesamten Aufrufe der Methode (also add(),
	 * remove(), contains()) geteilt
	 * (Man kann auch anstatt Integern Objects nehmen, die man dann vorher in einem Array angelegt hat)
	 * 
	 * @return drei Durchschnittszeiten der Methoden fuer die jeweilige Collection
	 */
	public Zeitensammlung performanceTest() {
		
		long addTime = 0;
		long removeTime = 0;
		long containsTime = 0;
		
			
		for (int durchlaufAnzahl = 0; durchlaufAnzahl < 1000; durchlaufAnzahl++) {
				
			Collection<Integer> testCollection = getInstance();				//in Erfahrung bringen, in welcher Collection 
																			//Methode durchgefuehrt werden soll
				
			long start = System.nanoTime();
				for (int i = 0; i < 10000; i++) {
				testCollection.add(i);
			}
			long end = System.nanoTime();
			addTime += (end - start);
				
			start = System.nanoTime();
			for (int i = 0; i < 10000/2; i++) {								
				testCollection.remove(i);								
			}																
			end = System.nanoTime();
			removeTime += (end - start);
			
			start = System.nanoTime();
			for (int i = 0; i < 10000; i++) {
				testCollection.contains(i);
			}
			end = System.nanoTime();
			containsTime += (end - start);
		}
		
	
		return new Zeitensammlung(((double)addTime/ (double) 5000000),((double) removeTime/ (double) 10000000),((double) containsTime/ (double) 10000000));
	}
	/**
	 * gibt eine leere Collection vom Typ zurueck, der als naechstes getestet werden soll
	 * 
	 * @return leere Collection vom zu testenden Typ
	 */
	protected abstract Collection<Integer> getInstance();
}