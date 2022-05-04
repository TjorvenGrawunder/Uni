package Aufgabe3;

import util.List;

/**
 * Die Klasse LibraryTest ueberprueft, ob die Klasse Library wie geplant 
 * funktioniert
 * 
 * @author ajeme
 *
 */
public class LibraryTest {
	
	/**
	 * Anzahl der Fehler in der Implementierung der Klasse Library
	 */
	private static int fehlerZahl = 0;
	
	/**
	 * ueberprueft, ob die Bibliothek bei ihrer Erzeugung leer ist; wenn nicht,
	 * wird eine Fehlermeldung ausgegeben und die Fehleranzahl um eins erhoeht
	 */
	public void leereBibliothek() {
		Library bib = new Library();
		List suchErgebnisse = bib.search(" ");
		if (suchErgebnisse.empty() == false) {
			System.out.println("Bibliotek sollte bei Erzeugung leer sein!");
			fehlerZahl++;
		}
	}
	
	/**
	 * Es werden eine BluRay und ein Buch erzeugt und zur Bibliotek hinzugefuegt,
	 * dann werden die Beschreibungen der Bibliotheksartikel nach "schein" 
	 * durchsucht und wenn das erste Listen-Objekt der Suchergebnis-Liste nicht
	 * die gleiche Beschreibung wie der erste Bibliotheksartikel aufweist oder
	 * das zweite Listen-Objekt der Suchergebnis-Liste nicht die gleiche 
	 * Beschreibung wie der zweite Biblioteksartikel, wird eine Fehlermeldung 
	 * ausgegeben und die Fehleranzahl um eins erhoeht (Suche nach mehreren
	 * Elementen gleichzeitig).
	 * 
	 * Bei der Suche nach einem spezifischen Element wird nach "Sonnenschein",
	 * also dem Titel der BluRay, gesucht; dann wird ueberprueft, ob NUR
	 * dieser Bibliotheksartikel gefunden wurde.
	 * 
	 * Werden mehr Elemente der Suchergebnis-Liste hinzugefuegt als gewollt,
	 * wird ebenfalls eine entsprechende Fehlermeldung ausgegeben
	 */
	public void EinfuegenundSuchenTest() {
		Library bib = new Library();
		LibraryItem br = new BluRay("Sonnenschein", "Hans Mustermann");
		LibraryItem buch = new Book("Mondschein", "Chris Schustermann");
		bib.addItem(br);
		bib.addItem(buch);
		
		List suchErgebnisse = bib.search("schein");
		suchErgebnisse.reset();
		
		if (!"Sonnenschein Hans Mustermann".equals(((LibraryItem) suchErgebnisse.elem()).getDescription() )) {
			fehlerZahl++;
			System.out.println("Fehler bei Suche 1 (Sonnenschein)");
		}
		suchErgebnisse.advance();
		if (!"Mondschein Chris Schustermann".equals(((LibraryItem) suchErgebnisse.elem()).getDescription())) {
			fehlerZahl++;
			System.out.println("Fehler bei Suche 2 (Mondschein)");
		}
		suchErgebnisse.advance();
		if (suchErgebnisse.endpos() == false) {
			fehlerZahl++;
			System.out.println("Fehler! Mehr Suchergebnisse als beabsichtigt!");
		}
		
		List suchErgebnisse2 = bib.search("Sonnenschein");
		suchErgebnisse2.reset();
		
		if (!"Sonnenschein Hans Mustermann".equals(((LibraryItem) suchErgebnisse2.elem()).getDescription() )) {
			fehlerZahl++;
			System.out.println("Fehler bei Suche 2 (Sonnenschein)");
		}
		suchErgebnisse2.advance();
		if (suchErgebnisse.endpos() == false) {
			fehlerZahl++;
			System.out.println("Fehler! Mehr Suchergebnisse als beabsichtigt!");
		}	
	}
	
	/**
	 * Es wird ueberprueft, ob ein Objekt, dass vor seiner Loeschung zur
	 * Suchergebnis-Liste gehoert haette, trotzdem noch auf dieser Liste 
	 * auftaucht, also ob das Loeschen fehlgeschlagen ist; bei Nicht-Loeschen
	 * wird eine Fehlermeldung ausgegeben und die Fehlerzahl um eins erhoeht
	 */
	public void LoeschenTest() {
		Library bib = new Library();
		LibraryItem br = new BluRay("Sonnenschein", "Hans Mustermann");
		LibraryItem buch = new Book("Mondschein", "Chris Schustermann");
		bib.addItem(br);
		bib.addItem(buch);
		
		bib.deleteItem(buch);
		List suchErgebnisse = bib.search("schein");
		suchErgebnisse.reset();
		
		if (!"Sonnenschein Hans Mustermann".equals(((LibraryItem) suchErgebnisse.elem()).getDescription() )) {
			fehlerZahl++;
			System.out.println("Fehler bei LoeschenTest (Sonnenschein)");
		}
		suchErgebnisse.advance();
		if (suchErgebnisse.endpos() == false) {
			fehlerZahl++;
			System.out.println("Fehler! Mehr Suchergebnisse als beabsichtigt bei LoeschenTest!");
		}	
	}
	
	/**
	 * Es wird ueberprueft, ob der Ausleihstatus von LibraryItems, was ja
	 * das einzige ueberpruefbare Klassenattribut der Klasse LibraryItem ist, 
	 * sich durch ungewuenscht aendert durch Anwendung von Methoden wie 
	 * search(), deleteItem() oder addItem().
	 * 
	 * Aendert sich der Status unbeabsichtigt, wird eine Fehlermeldung ausgegeben
	 * und die Fehleranzahl um eins erhoeht.
	 */
	public void seitenEffekteTest() {
		Library bib = new Library();
		LibraryItem br = new BluRay("Sonnenschein", "Hans Mustermann");
		LibraryItem buch = new Book("Mondschein", "Chris Schustermann");
		bib.addItem(br);
		bib.addItem(buch);
		
		buch.setBorrowed(true);
		
		bib.search("schein");
		bib.search("mann");
		bib.search("Mondschein");
		bib.deleteItem(buch);
		LibraryItem buch2 = new Book("Baum", "Gustav Birke");
		bib.addItem(buch2);
		
		if(buch.isBorrowed() == false) {
			fehlerZahl++;
			System.out.println("Seiteneffekt bei Mondschein");		
		}
		if (br.isBorrowed() == true) {
			fehlerZahl++;
			System.out.println("Seiteneffekt bei Sonnenschein");
		}
	}
	
	/**
	 * Main-Methode, in der eine Instanz der Klasse LibraryTest erzeugt wird;
	 * dann werden die verschiedenen Testmethoden ausgefuehrt und die Fehlerzahl
	 * wird danach ausgegeben
	 * 
	 * @param args vom Nutzer uebergebene Parameter (hier nicht benoetigt)
	 */
	public static void main(String[] args) {
		LibraryTest test = new LibraryTest();
		test.leereBibliothek();
		test.EinfuegenundSuchenTest();
		test.LoeschenTest();
		test.seitenEffekteTest();
		
		System.out.println("Fehlerzahl: " + fehlerZahl);
	}
}
