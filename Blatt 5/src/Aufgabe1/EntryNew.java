package Aufgabe1;

/**
 * An Entry holds an Object <code>o</code> and a reference <code>next</code> to
 * the next Entry such that a linked List of Entry elements is generated.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 */
class EntryNew<T> {

   T o;
   EntryNew<T> next;

   EntryNew() {
      this(null, null);
   }

   EntryNew(T o) {
      this(o, null);
   }

   EntryNew(T o, EntryNew<T> e) {
      this.o = o;
      this.next = e;
   }

}
