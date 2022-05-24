/**
 * 
 */
package Aufgabe3;

import java.io.IOException;

/**
 * @author admin
 *
 */
public class Test {
	static int[] testArray = new int[15];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testArray = fillArray(testArray);
		IntArrWrap toTest = new IntArrWrap(testArray, "TestArray.txt");
		System.out.println("Ergebnis des Fill und Get Tests: " + testFillAndGet(toTest));
		System.out.println("Ergebnis des Change Tests: " + testChange(toTest));
		System.out.println("Ergebnis des Länge Tests: " + testLength(toTest));
		try {
			IntArrWrap testByFile = new IntArrWrap("TestArray.txt");
			System.out.println("Ergebnis des Pfad Konstruktor Tests: " +  testGetFileConstructor(toTest, testByFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Das Array wird befuellt mit zufälligen Zahlen
	 * @param a
	 * @return Test erfolgreich?
	 */
	public static int[] fillArray(int[] a) {
		for(int i = 0; i< a.length; i++) {
			a[i] = (int) (Math.random()*255 +1);
		}
		return a;
	}
	/**
	 * Sollten beide Objekte nicht die gleiche Laenge besitzen ist der Test direkt fehlgeschlagen.
	 * Ansonsten muss getestet werden ob alle Eintraege beim gleichen Index auch identisch sind. Sollte
	 * ein Eintrag abweichen bricht die Schleife ab und false wird ausgegeben.
	 * @param a Normales WrapperArray
	 * @param b Objekt wurde durch Konstruktor nur mit Dateiname erzeugt
	 * @return Test erfolgreich?
	 */
	public static boolean testGetFileConstructor(IntArrWrap a, IntArrWrap b) {
		boolean success = true;
		int i = 0;
		if(a.getLength() != b.getLength()) {
			return false;
		}
		while(i < a.getLength() && success == true) {
			success = a.getAt(i) == b.getAt(i);
			i++;
		}
		return success;
	}
	/**
	 * Es wird ein temporaeres Array erzeugt, in dem alle Eintraege aus der Datei abgespeichert werden.
	 * Dieses Array wird dann mit dem OriginalArray abgeglichen. Dadurch testet man zum einen, ob das Array richtig
	 * befuellt wurde und zum anderen ob die get-Methode richtig implementiert wurde.
	 * @param a
	 * @return Test erfolgreich?
	 */
	public static boolean testFillAndGet(IntArrWrap a) {
		boolean success = true;
		int[] tmp = new int[15];
		for(int i = 0; i< tmp.length; i++) {
			tmp[i] = a.getAt(i);
		}
		int i = 0;
		while(i < testArray.length && success == true) {
			success = tmp[i] == testArray[i];
			i++;
		}
		return success;
	}
	/**
	 * Es wird ein Element sowohl in dem Originalen Array, als auch in der Datei geaendert. Danach wird abgeglichen,
	 * ob beide Einträge immer noch gleich sind. Falls dies der Fall ist war der test erfolgreich.
	 * @param a
	 * @return Test erfolgreich?
	 */
	public static boolean testChange(IntArrWrap a) {
		boolean success = false;
		testArray[12] = 512;
		a.change(12, 512);
		if(testArray[12] == a.getAt(12)) {
			success = true;
		}
		return success;
	}
	/**
	 * Die Laenge des originalen Arrays wird mit der Länge der Datei abgeglichen
	 * @param a
	 * @return Test erfolgreich?
	 */
	public static boolean testLength(IntArrWrap a) {
		boolean success = false;
		if(testArray.length == a.getLength()) {
			success = true;
		}
		return success;
	}

}
