package Aufgabe1;

public class MyList<E> {
	ListElem<E> first;
	ListElem<E> last;
	
	MyList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return this.length() == 0;
	}
	public void add(ListElem<E> e) {
		if(this.isEmpty()) {
			first = e;
			last = e;
		}else {
			last.setNext(e);
			e.setPrevious(last);
			last = e;
			e.setNext(null);
			
		}
	}
	
	public ListElem<E> at(int n) {
		ListElem<E> result = first;
		for(int i = 1; i <= n; i++) {
			result = result.getNext();
		}
		return result;
	}
	
	public int length() {
		int size = 0;
		ListElem<E> current = first;
		while(current != null) {
			current = current.getNext();
			size++;
		}
		return size;
	}
	
	public void remove(int n) {
		ListElem<E> remove = this.at(n);
		ListElem<E> previous = remove.getPrevious();
		ListElem<E> next = remove.getNext();
		previous.setNext(next);
		next.setPrevious(previous);
		remove = null;
	}
	
	public void insertAt(E e, int n) {
		ListElem<E> next = this.at(n);
		
	}
}
