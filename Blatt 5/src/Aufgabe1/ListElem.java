package Aufgabe1;

public class ListElem<T> extends Entry{
	private ListElem<T> next;
	private ListElem<T> previous;
	
	ListElem(){
		
	}

	public ListElem<T> getNext() {
		return next;
	}

	public void setNext(ListElem<T> next) {
		this.next = next;
	}

	public ListElem<T> getPrevious() {
		return previous;
	}

	public void setPrevious(ListElem<T> previous) {
		this.previous = previous;
	}

}
