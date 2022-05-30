package Aufgabe1;

/**
 * Classes that implement the interface Visitor assure that the implement the
 * method {@link #visit(Object)}. The method {@link #visit(Object)} will be
 * called by a {@link Visitable} instance for every Object it visits during one
 * call of the method {@link Visitable#accept(Visitor)}.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 * @param <E>
 *           type of the elements which can be visited by this Visitor
 * 
 * @see Visitable
 */
public interface Visitor<E> {

   /**
    * Called by the method {@link Visitable#accept(Visitor)} for every element it
    * visits. The visiting can be stopped by returning <code>false</code>.
    * 
    * @param o
    *           the element that has just been visited by
    *           {@link Visitable#accept(Visitor)}
    * @return <code>true</code> if the visit should be continued until every
    *         element in a {@link Visitable} has been visited once, else
    *         <code>false</code>
    */
	/**
	 * Aktionen, die ausgefuehrt werden sollen bevor visit aufgerufen wird. Hier besteht die Moeglichkeit bei SKIP als Result das Directory
	 * zu ueberspringen und mit dem naechsten Teil fortzufahren.
	 * @param o >File
	 * @return CONTINUE, SKIP, END
	 */
   public VisitResult preVisit(E o);
   /**
	 * Aktionen, die ausgefuehrt werden sollen nachdem visit aufgerufen wird. Hier besteht nicht die Moeglichkeit bei SKIP als Result das Directory
	 * zu ueberspringen und mit dem naechsten Teil fortzufahren, sondern SKIP verhaelt sich wie CONTINUE.
	 * @param o >File
	 * @return CONTINUE, SKIP, END
	 */
   public VisitResult postVisit(E o);
   /**
    * Wird aufgerufen um ein File zu besuchen. SKIP wirkt hier wie CONTINUE.
    * @param o >File
    * @return CONTINUE, SKIP, END
    */
   public VisitResult visit(E o);
   /**
    * Wird aufgerufen wenn das Lesen eines Verzeichnisses oder einer Datei fehlschlaegt. SKIP wirkt hier wie CONTINUE
    * @param o >File
    * @return CONTINUE,SKIP,END
    */
   public VisitResult visitFailed(E o);


}
