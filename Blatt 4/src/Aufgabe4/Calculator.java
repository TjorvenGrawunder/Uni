/**
 * 
 */
package Aufgabe4;

import java.util.Scanner;

/**
 * @author admin
 *
 */
public class Calculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.startCalculator();

	}

	private void startCalculator() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter first Fraction");
		String first = s.nextLine();
		Fraction firstFrac = Fraction.parseFraction(first);
		System.out.println("Enter second Fraction");
		String second = s.nextLine();
		Fraction secondFrac = Fraction.parseFraction(second);
		System.out.println("Enter Operator (+,-,*,/)");
		String operator = s.nextLine();
		System.out.println(calculate(operator, firstFrac, secondFrac).toString());
	}
	
	private Fraction calculate(String operator, Fraction frac1, Fraction frac2) {
		Fraction result;
		if(operator.equals("+")) {
			
			result = frac1.add(frac2);
			
		}else if(operator.equals("-")) {
			
			result = frac1.substract(frac2);
			
		}else if(operator.equals("*")) {
			
			result = frac1.multiply(frac2);
			
		}else if(operator.equals("/")) {
			
			result = frac1.divide(frac2);
			
		}else {
			System.err.println("Error. Please enter a valid operator");
			return null;
		}
		return result;
	}

}
