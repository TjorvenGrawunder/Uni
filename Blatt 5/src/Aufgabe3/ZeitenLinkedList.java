package Aufgabe3;

import java.util.Collection;
import java.util.LinkedList;

/**
 * siehe ZeitenArrayList fuer naehere Ausfuehrungen
 * 
 * @author ajeme
 *
 */

public class ZeitenLinkedList extends ZeitenCollections {

	@Override
	protected Collection<Integer> getInstance() {
		return new LinkedList<Integer>();
	}

}
