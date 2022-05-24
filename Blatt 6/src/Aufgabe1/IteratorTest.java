package Aufgabe1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Testklasse, um zu ueberpruefen, ob der Iterator die MyList durchlaufen und ein oder mehrere
 * Elemente loeschen kann; auch wird ueberprueft, ob die richtigen Exceptions geworfen werden
 * 
 * @author ajeme
 *
 */
public class IteratorTest {

	/**
	 * Main-Methode, in der alle notwendigen Tests durchgefuehrt werden
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		IteratorTest test = new IteratorTest();
		
		test.testAlleDurchlaufen();
		test.testLoescheEinElement();
		test.testLoescheMehrereElemente();
		
		test.testFailFastNextAdd();
		test.testFailFastRemoveDelete();
		test.testNoSuchElementExceptionNext();
		test.testIllegalStateExceptionRemove();
	}

	/**
	 * Alle Elemente der Liste werden durchlaufen und mit den Integer-Werten, die dabei zurueckgegeben 
	 * werden sollten, verglichen
	 */
	public void testAlleDurchlaufen() {
		MyList<Integer> liste1 = this.erstelleTestListe();
		Integer[] array1 = {9,8,7,6,5,4,3,2,1,0};
		Iterator<Integer> it = liste1.iterator();
		int i =0;
		while(it.hasNext() && i < array1.length) {
			if (array1[i] != it.next()) {
				System.out.println("Fehler bei testAlleDurchlaufen!");
			}
			i++;
		}
		if ((i != array1.length) != it.hasNext()) {
			System.out.println("Fehler bei testAlleDurchlaufen! Liste hat nicht die erwartete Laenge!");
			
		}
		
		
	}
	
	/**
	 * Es wird eine Liste erzeugt, die die Zahlen von 0 bis 9 (oder viel mehr 9 bis 0) enthaelt
	 * 
	 * @return mit Integern gefuellte Liste
	 */
	private MyList<Integer> erstelleTestListe() {
		MyList<Integer> liste = new MyList<Integer>();
		for (int i = 0; i < 10; i++) {
			liste.add(i);
		}
		return liste;
	}
	
	/**
	 * Es wird dreimal die next()-Methode aufgerufen und dann das dritte Element geloescht, dann
	 * wird ueberprueft, ob die sich ergebende Liste der durch Loeschen des dritten Elements entstandenen 
	 * Liste entspricht
	 */
	public void testLoescheEinElement() {
		MyList<Integer> liste2 = this.erstelleTestListe();
		Iterator<Integer> it1 = liste2.iterator();
		it1.next();
		it1.next();
		it1.next();
		it1.remove();
		Integer[] array2 = {9,8,6,5,4,3,2,1,0};
		int i =0;
		Iterator<Integer> it2 = liste2.iterator();
		while(it2.hasNext() && i < array2.length) {
			if (array2[i] != it2.next()) {
				System.out.println("Fehler bei testLoescheEinElement!");
			}
			i++;
		}
		if ((i != array2.length) != it2.hasNext()) {
			System.out.println("Fehler bei testLoescheEinElement! Liste hat nicht die erwartete Laenge!");
			
		}
		
	}
	
	/**
	 * Alle Elemente der Liste werden geloescht und dann wird ueberprueft, ob die Liste nun leer ist.
	 */
	public void testLoescheMehrereElemente() {
		MyList<Integer> liste3 = this.erstelleTestListe();
		Iterator<Integer> it1 = liste3.iterator();
		for (int i = 0; i < 10; i++) {
			it1.next();
			it1.remove();
		}
		if (!liste3.empty()) {
			System.out.println("Fehler bei testLoescheMehrereElemente!");
		}
	}
	
	/**
	 * Es wird ueberprueft, ob nach Aufruf der add()-Methode auf der Liste, also nach Erhoehung der Anzahl
	 * an Veraenderungen an der Liste nach Erzeugung des Iterators, beim Aufruf der next()-Methode des Iterators
	 * eine ConcurrentModificationException geworfen wird.
	 */
	public void testFailFastNextAdd() {
		MyList<Integer> liste4 = this.erstelleTestListe();
		try {
			Iterator<Integer> it = liste4.iterator();
			liste4.add(7);
			it.next();
			System.out.println("Fehler bei testFailFastNextAdd!");
		}catch (ConcurrentModificationException e) {

		}
	}
	
	/**
	 * Es wird ueberprueft, ob nach Aufruf der delete()-Methode auf der Liste, also nach Erhoehung der Anzahl
	 * an Veraenderungen an der Liste nach Erzeugung des Iterators, beim Aufruf der remove()-Methode des Iterators
	 * eine ConcurrentModificationException geworfen wird.
	 */
	public void testFailFastRemoveDelete() {
		MyList<Integer> liste5 = this.erstelleTestListe();
		try {
			Iterator<Integer> it = liste5.iterator();
			liste5.delete();
			it.remove();
			System.out.println("Fehler bei testFailFastRemoveDelete!");
		}catch (ConcurrentModificationException e) {

		}
	}
	
	/**
	 * Es wird ueberprueft, ob eine NoSuchElementException geworfen wird, wenn man die next()-Methode aufruft 
	 * und der Iterator bereits das Ende der Liste erreicht hat.
	 */
	public void testNoSuchElementExceptionNext() {
		MyList<Integer> liste6 = this.erstelleTestListe();
		try {
			Iterator<Integer> it = liste6.iterator();
			while (it.hasNext()) {
				it.next();
			}
			it.next();
			System.out.println("Fehler bei testNoSuchElementException!");
		} catch (NoSuchElementException e) {
			
		}
	}
	
	/**
	 * Es wird ueberprueft, ob eine IllegalStateException geworfen wird, wenn die remove()-Methode aufgerufen
	 * wird, ohne vorher die next()-Methode aufgerufen zu haben.
	 */
	public void testIllegalStateExceptionRemove() {
		MyList<Integer> liste7 = this.erstelleTestListe();
		try {
			Iterator<Integer> it = liste7.iterator();
			it.remove();
			System.out.println("Fehler bei testIllegalStateExceptionRemove!");
		}catch (IllegalStateException e) {

		}
	}
	
}
