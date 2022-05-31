/**
 * 
 */
package Aufgabe2;

/**
 * @author admin
 *
 */
public class Test {

	/**
	 * 
	 * Es werden zwei Visitors erstellt, einer durchlaeuft die ganze Liste, waehrend der andere bei 34 abbricht.
	 * Beide geben die besuchten Elemente aus.
	 * @param args
	 */
	public static void main(String[] args) {
		MyList<Integer> list = new MyList<Integer>();
		for(int i = 0; i < (int) (Math.random()*25 + 1); i++) {
			int addInt = (int) (Math.random()*500 + 1);
			list.add(addInt);
		}
		list.add(34);
		for(int i = 0; i < (int) (Math.random()*25 + 1); i++) {
			int addInt = (int) (Math.random()*500 + 1);
			list.add(addInt);
		}
		//innere Klassen
		Visitor<Integer> MyVisitor = new Visitor<Integer>() {
			
			@Override
			public boolean visit(Integer o) {
				System.out.println(o);
				return true;
			}
		};
		Visitor<Integer> cancelVisit = new Visitor<Integer>() {
			
			@Override
			public boolean visit(Integer o) {
				if(o == 34) {
					System.out.println(o);
					return false;
				}else {
					System.out.println(o);
					return true;
				}
				
			}
		};
		
		list.accept(MyVisitor);
		
		System.out.println("CancelVisitor: ");
		
		list.accept(cancelVisit);
	}

}
