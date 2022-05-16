package Aufgabe1;
/**
 * List with two Pointer on the first and last element.
 * Every ListElem has two Pointers for the next and previous ListElem, so you can go through the whole List.
 * 
 * @author admin
 *
 * @param <E>
 */

public class MyList2<E> {
	
	ListElem<E> first;
	ListElem<E> last;
	int size = 0;
	/**
	 * first and last are null at the init
	 */
	MyList2(){
		first = null;
		last = null;
	}
	/**
	 * If the length of the list is equal to zero the list is empty.
	 * @return true/false if list is empty
	 */
	public boolean isEmpty() {
		return this.length() == 0;
	}
	/**
	 * new content will be added at the end of the list. New ListElem is last and the previous last will be his previous.
	 * @param content to add
	 */
	public void add(E content) {
		ListElem<E> e = new ListElem<E>(content);
		if(this.isEmpty()) {
			first = e;
			last = e;
		}else {
			last.setNext(e);
			e.setPrevious(last);
			last = e;
			e.setNext(null);
			
		}
		size++;
	}
	
	/**
	 * Skips through the whole List to the right number.
	 * @param n Number of the element
	 * @return content of the ListElem at n
	 */
	
	public E at(int n) {
		ListElem<E> result = first;
		for(int i = 1; i <= n; i++) {
			result = result.getNext();
		}
		return result.getContent();
	}
	/**
	 * Same as at but returns an ListElem
	 * @param n
	 * @return
	 */
	public ListElem<E> ElemAt(int n) {
		ListElem<E> result = first;
		for(int i = 1; i <= n; i++) {
			result = result.getNext();
		}
		return result;
	}
	
	/**
	 * removes the elem in place n. The previous of this elem and the next will point of each other. The Garbage Collector will remove
	 * this ListElem.
	 * @param n
	 */
	public void remove(int n) {
		ListElem<E> remove = this.ElemAt(n);
		ListElem<E> previous = remove.getPrevious();
		ListElem<E> next = remove.getNext();
		previous.setNext(next);
		next.setPrevious(previous);
		size--;
	}
	
	public void insertAt(E content, int n) {
		ListElem<E> next = this.ElemAt(n);
		ListElem<E> previous = next.getPrevious();
		ListElem<E> e = new ListElem<E>(content);
		e.setNext(next);
		e.setPrevious(previous);
		previous.setNext(e);
		next.setPrevious(e);
		size++;
		
	}
	
	public int length() {
		return size;
	}
}
