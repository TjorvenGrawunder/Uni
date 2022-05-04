package Aufgabe3;

/**
 * Die Klasse LibraryItem repraesentiert ein ausleihbaren Bibliotheksartikel.
 * 
 * @author ajeme
 *
 */
public abstract class LibraryItem {
	
	/**
	 * Ausleihstatus (true: verliehen, false: nicht verliehen)
	 */
	private boolean isBorrowed;
	
	/**
	 * Konstruktor zur Erzeugung eines nicht-ausgeliehenen Bibliothekartikels
	 */
	public LibraryItem() {
		isBorrowed = false;
	}
	
	/**
	 * gibt Ausleihstatus zurueck
	 * 
	 * @return Ausleihstatus(Artikel verliehen oder nicht)
	 */
	public boolean isBorrowed() {
		return isBorrowed;
	}
	
	/**
	 * Aenderung des Ausleihstatus
	 * 
	 * @param isBorrowed wenn true, wird der Status auf isBorrowed bzw.
	 * "ausgeliehen" gesetzt; wenn false, wird der Status auf "nicht ausgeliehen" 
	 * gesetzt
	 */
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
	/**
	 * gibt die Beschreibung des Bibliotheksartikels zurueck
	 * 
	 * @return Beschreibung des Bibliotheksartikel
	 */
	public abstract String getDescription();
}
