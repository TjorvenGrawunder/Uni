package Aufgabe1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Die Klasse ListeIterator ermoeglicht das Durchlaufen einer Instanz der Klasse
 * MyList sowie das Loeschen von Elementen aus dieser Instanz
 * 
 * @author ajeme
 *
 * @param <E>
 */
public class ListeIterator<E> implements Iterator<E> {
	
	/**
	 * Anzahl an Veraenderungen an der Liste, die zum Iterator gehoert; sollte
	 * mit entsprechendem Wert in der Klasse MyList uebereinstimmen
	 */
	private int aenderungenListe;
	
	/**
	 * Listeneintrag, der beim letzten Aufruf von next() zurueckgegeben wurde
	 */
	private MyEntry<E> last;
	
	/**
	 * Listeneintrag, der beim naechsten Aufruf von next() zurueckgegeben wird
	 */
	private MyEntry<E> next;
	
	/**
	 * Listeneintrag, der vor last bei next() zurueckgegeben wurde; wird bei Aufruf
	 * von remove() auf null gesetzt, bis das naechste Mal next() aufgerufen
	 * wird
	 */
	private MyEntry<E> previousLast;
	
	/**
	 * Liste, die der Iterator durchlaeuft
	 */
	private MyList<E> liste;

	/**
	 * Konstruktor fuer einen neuen ListeIterator, der die uebergebene Liste von
	 * vorne nach hinten durchlaeuft
	 * 
	 * @param liste zu durchlaufende Liste
	 * @param begin Beginn der zu durchlaufenden Liste
	 */
	ListeIterator(MyList<E> liste, MyEntry<E> begin){
		this.next = begin.next;
		this.last = begin;
		this.liste = liste;
		this.aenderungenListe = liste.getAenderungenListe();
		this.previousLast = null;
	}
	
	/**
	 * Methode gibt an, ob der Iterator beim letzten Listenelement angegekommen
	 * ist oder ob es noch weitere gibt
	 * 
	 * @return Antwort darauf, ob Iterator am Ende der Liste angekommen ist
	 */
	@Override
	public boolean hasNext() {
		if (this.next != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Gibt das naechste Element der uebergebenen Liste zurueck und geht einen
	 * Schritt in der Liste weiter
	 * 
	 * @return naechstes Element in der Liste
	 * @throws ConcurrentModificationException, falls die Liste nach Erzeugung
	 * des Iterators nochmal veraendert wurde
	 * @throws NoSuchElementException, falls der Iterator scho beim letzten 
	 * Element der Liste angekommen ist
	 */
	@Override
	public E next() {
		if (aenderungenListe != liste.getAenderungenListe()) {
			throw new ConcurrentModificationException();
		}
		if (next == null) {
			throw new NoSuchElementException();
		}
		previousLast = last;
		last = next;
		next = next.next;
		
		return last.o;
		
	}
	
	/**
	 * Loescht das Element der Liste, das bei der Methode next() zurueckgegeben 
	 * wurde 
	 * 
	 * @throws ConcurrentModificationException, falls die Liste nach Erzeugung
	 * des Iterators nochmal veraendert wurde
	 * @throws IllegalStateException, falls die next()- Methode vorher noch nicht 
	 * aufgerufen wurde
	 */
	@Override
	public void remove() {
		if (aenderungenListe != liste.getAenderungenListe()) {
			throw new ConcurrentModificationException();
		}
		if (previousLast == null) {
			throw new IllegalStateException();
		}
		aenderungenListe++;
		liste.erhoeheAenderungenListe();
		
		previousLast.next = next;
		last = previousLast;
		previousLast = null;
	}
}
