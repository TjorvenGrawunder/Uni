package Aufgabe3;

import java.util.Collection;
import java.util.HashSet;

/**
 * siehe ZeitenArrayList fuer naehere Ausfuehrungen
 * 
 * @author ajeme
 *
 */
public class ZeitenHashSet extends ZeitenCollections {

	@Override
	protected Collection<Integer> getInstance() {
		return new HashSet<Integer>();
	}

}
