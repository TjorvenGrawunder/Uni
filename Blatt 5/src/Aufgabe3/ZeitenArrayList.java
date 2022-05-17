package Aufgabe3;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Die Klasse ZeitenArrayList erbt von CollectionsZeiten die Methoden performanceTest()
 * und getInstance(), wobei letztere in ZeitenArrayList noch zu implementieren war;
 * in der main-Methode der Klasse printTabelle wird ein Objekt der Klasse
 * ZeitenArrayList erzeugt, auf dem dann performanceTest() ausgefuehrt wird, um die
 * Zeiten zu nehmen; getInstance() uebergibt die Information, um was fuer
 * eine Collection es sich handelt
 * 
 * 
 * @author ajeme
 *
 */

public class ZeitenArrayList extends ZeitenCollections {

	@Override
	protected Collection<Integer> getInstance() {
		return new ArrayList<Integer>();
	}

}
