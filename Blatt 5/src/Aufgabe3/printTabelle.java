package Aufgabe3;

/**
 * Klasse gibt die Tabelle mit den durchschnittlichen Laufzeiten der Methoden add(), remove() und contains()
 * fuer die unterschiedlichen Collections aus
 * 
 * @author ajeme
 *
 */
public class printTabelle {
	
	public static void main(String[] args) {
		
		ZeitenArrayList arrayTime = new ZeitenArrayList();
		ZeitenLinkedList listTime = new ZeitenLinkedList();
		ZeitenHashSet hashTime = new ZeitenHashSet();
		
		System.out.printf("%10s | %12s %12s %12s %n", "Typ", "add()", "remove()", "contains()");
		System.out.println("-----------+-----------------------------------------");
		System.out.printf("%10s | %12s %12s %12s %n", "ArrayList", arrayTime.performanceTest().addTime, arrayTime.performanceTest().removeTime, arrayTime.performanceTest().containsTime);
		System.out.printf("%10s | %12s %12s %12s %n", "LinkedList", listTime.performanceTest().addTime, listTime.performanceTest().removeTime, listTime.performanceTest().containsTime);
		System.out.printf("%10s | %12s %12s %12s %n", "HashSet", hashTime.performanceTest().addTime, hashTime.performanceTest().removeTime, hashTime.performanceTest().containsTime);
	}

}
