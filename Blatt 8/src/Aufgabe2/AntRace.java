package Aufgabe2;


public class AntRace implements AntFields {

	public static void main(String[] args) {

		AntField field = new AntField(FIELD1);

		Ant ant = new Ant(field, 2, 4, 1);

		new Thread(ant).start();
		while(field.getAntCount() > 0) {
			System.out.print("");		
			}
		

		System.out.println(field.toString());
	}
}
