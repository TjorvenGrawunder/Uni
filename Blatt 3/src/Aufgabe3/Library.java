package Aufgabe3;

import util.List;

/**
 * Die Klasse Library repreasentiert eine Bibliothek. Die enthaltenen LibraryItems
 * werden in einer Liste gespeichert.
 * 
 * @author ajeme
 *
 */

public class Library {
	
	/**
	 * Liste der LibraryItem-Instanzen, die das Inventar der Bibliothek 
	 * repraesentieren
	 */
	List liste;
	
	/**
	 * Konstruktor der Library; eine neue Inventar-Liste wird erzeugt
	 */
	
	public Library() {
		liste = new List();
	}
	
	/**
	 * Fuegt der Bibliothek einen neuen Artikel/ein neues Item hinzu
	 * 
	 * @param item LibraryItem(/Bibliotheks-Artikel), das(/der) hinzugefuegt
	 * werden soll
	 */
	public void addItem(LibraryItem item) {
		liste.add(item);
	}
	
	/**
	 * Loescht ein ausgewaehltes LibraryItem(/einen ausgewaehlten Artikel)
	 * aus der Bibliothek, wenn vorhanden
	 * 
	 * @param item zu loeschendes LibraryItem(/zu loeschender Artikel)
	 */
	public void deleteItem(LibraryItem item) {
		liste.reset();
		while(liste.endpos() == false) {
			LibraryItem vergleichsObjekt = (LibraryItem) liste.elem();
			if (vergleichsObjekt.equals(item)) {
				liste.delete();
			} else {
				liste.advance();
			}
			
		}
	}
	/**
	 * Ausgabe der getDescription()-Methode jedes LibraryItem-Objekts in der Library
	 * wird daraufhin untersucht, ob sie den uebergebenen String enthaelt; alle 
	 * LibraryItem-Objekte, auf die das zutrifft, werden in einer Liste gesammelt
	 * und zurueckgegeben
	 * 
	 * @param text String, nach dem in den Beschreibungen der LibraryItem-Objekte
	 * gesucht wird
	 * @return Liste mit LibraryItem-Objekten, die den gewuenschten String enthalten
	 */
	public List search(String text) {
		List passendeErgebnisse = new List();
		liste.reset();
		
		while (liste.endpos() == false) {
			LibraryItem vergleichsObjekt = (LibraryItem) liste.elem();
			String beschreibung = vergleichsObjekt.getDescription();
			if(beschreibung.contains(text)) {
				passendeErgebnisse.add(vergleichsObjekt);
			}
			liste.advance();
		}
		
		passendeErgebnisse.reset();
		
		return passendeErgebnisse;
	}
	

}
