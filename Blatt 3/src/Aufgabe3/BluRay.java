package Aufgabe3;

/**
 * Die Klasse BluRay stellt eine BluRay in der Bibliothek dar.
 * 
 * @author ajeme
 *
 */

public class BluRay extends LibraryItem{
	/**
	 * Titel des Films auf der BluRay
	 */
	private String title;

	/**
	 * Name des Direktors des Films auf der BluRay
	 */
	private String director;
	
	/**
	 * Konstruktor zur Erzeugung einer neuen BluRay
	 * 
	 * @param title Titel des BluRay-Films
	 * @param director Name des Direktors des BluRay-Films
	 */
	public BluRay(String title, String director) {
		this.title = title;
		this.director = director;
	}
	
	/**
	 * gibt den Titel des BluRay-Films zurueck
	 * 
	 * @return Titel des BluRay-Films
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * gibt den Namen des Direktors des BluRay-Films zurueck
	 * 
	 * @return Name des Direktors des BluRay-Films
	 */
	public String getDirector() {
		return this.director;
	}
	
	/**
	 * gibt Beschreibung der BluRay zurueck, bestehend aus dem Titel
	 * des BluRay-Films und dem Namen des Direktors des BluRay-Films
	 * 
	 * @return Titel des BluRay-Films und Namen des Direktors des Films getrennt
	 * durch ein Leerzeichen
	 */
	public String getDescription() {
		return this.getTitle() + " " + this.getDirector();
	}
}

