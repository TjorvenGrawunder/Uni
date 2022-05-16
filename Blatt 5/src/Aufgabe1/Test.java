/**
 * 
 */
package Aufgabe1;

/**
 * @author admin
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyList<String> originalList = new MyList<String>();
		

		
		assert(originalList.clone() != originalList) : "Kopie hat die gleiche Referenz";
		assert(originalList.clone().getClass() == originalList.getClass()) : "Klasse vom Original und dem Klon sind nicht gleich";
		assert(originalList.clone().equals(originalList)) : "Das Original und die Kopie sind nicht gleich";
		
		/*
		 * Werden Elemente kopiert?
		 */
		for(int i = 0; i < 12; i++) {
			originalList.add("A");
		}
		System.out.println("Liste 1:");
		while(!originalList.endpos()) {
			try {
				originalList.advance();
				System.out.println(originalList.elem());
			}catch(RuntimeException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Kopie: ");
		MyList<String> copyList = originalList.clone();
		while(!copyList.endpos()) {
			copyList.advance();
			System.out.println(copyList.elem());
		}	
		
	}

}
