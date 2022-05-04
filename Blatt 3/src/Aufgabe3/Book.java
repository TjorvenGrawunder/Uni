package Aufgabe3;

/**
 * Die Klasse Book stellt ein Buch in der Bibliothek dar.
 * 
 * @author ajeme
 *
 */
public class Book extends LibraryItem{
	
	/**
	 * Buchtitel
	 */
	private String title;
	
	/**
	 * Name des Buchautors
	 */
	private String author;
	
	/**
	 * Konstruktor zur Erzeugung eines neuen Buches
	 * 
	 * @param title Buchtitel
	 * @param author Name des Buchautors
	 */
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	/**
	 * gibt Buchtitel zurueck
	 * 
	 * @return Buchtitel
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * gibt Namen des Buchautors zurueck
	 * 
	 * @return Name des Buchautors
	 */
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * gibt Beschreibung des Buches zurueck, bestehend aus Buchtitel und Name
	 * des Autors
	 * 
	 * @return Buchtitel und Name des Buchautors getrennt durch ein Leerzeichen
	 */
	public String getDescription() {
		return this.getTitle() + " " + this.getAuthor();
	}
}
