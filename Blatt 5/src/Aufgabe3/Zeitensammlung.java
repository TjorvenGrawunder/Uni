package Aufgabe3;

/**
 * Diese Klasse enthaelt nur die drei Ergebnisse/Durchschnittszeiten der Methoden
 * fuer die jeweilige Collection, die in performanceTest() der Klasse CollectionsZeiten
 * berechnet wurden
 * 
 * @author ajeme
 *
 */
public class Zeitensammlung {

	/**
	 * durchschnittliche Laufzeit der Methode add()
	 */
	double addTime;
	
	/**
	 * durchschnittliche Laufzeit der Methode remove()
	 */
	double removeTime;
	
	/**
	 * durchschnittliche Laufzeit der Methode contains()
	 */
	double containsTime;
	
	/**
	 * Konstruktor, der in performanceTest() aufgerufen wird, um die Ergebnisse
	 * in einer Zeitensammlung zu speichern
	 * 
	 * @param addTime
	 * @param removeTime
	 * @param containsTime
	 */
	Zeitensammlung (double addTime, double removeTime, double containsTime) {
		this.addTime = addTime;
		this.removeTime = removeTime;
		this.containsTime = containsTime;
	}
}
