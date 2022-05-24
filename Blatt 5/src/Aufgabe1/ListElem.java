package Aufgabe1;


public class ListElem<T> extends EntryNew{
	private ListElem<T> next;
	private ListElem<T> previous;
	T content;
	
	ListElem(T c){
		this.content = c;
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

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

}
