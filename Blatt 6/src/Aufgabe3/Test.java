/**
 * 
 */
package Aufgabe3;

import java.io.IOException;

/**
 * @author admin
 *
 */
public class Test {
	static int[] testArray = new int[15];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testArray = fillArray(testArray);
		IntArrWrap toTest = new IntArrWrap(testArray, "TestArray.txt");
		System.out.println(testFillAndGet(toTest));
		System.out.println(testChange(toTest));
		System.out.println(testLength(toTest));
		try {
			IntArrWrap testByFile = new IntArrWrap("TestArray.txt");
			System.out.println(testGetFileConstructor(toTest, testByFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int[] fillArray(int[] a) {
		for(int i = 0; i< a.length; i++) {
			a[i] = (int) (Math.random()*255 +1);
		}
		return a;
	}
	
	public static boolean testGetFileConstructor(IntArrWrap a, IntArrWrap b) {
		boolean success = true;
		int i = 0;
		if(a.getLength() != b.getLength()) {
			return false;
		}
		while(i < a.getLength() && success == true) {
			success = a.getAt(i) == b.getAt(i);
			i++;
		}
		return success;
	}
	
	public static boolean testFillAndGet(IntArrWrap a) {
		boolean success = true;
		int[] tmp = new int[15];
		for(int i = 0; i< tmp.length; i++) {
			tmp[i] = a.getAt(i);
		}
		int i = 0;
		while(i < testArray.length && success == true) {
			success = tmp[i] == testArray[i];
			i++;
		}
		return success;
	}
	
	public static boolean testChange(IntArrWrap a) {
		boolean success = false;
		testArray[12] = 512;
		a.change(12, 512);
		if(testArray[12] == a.getAt(12)) {
			success = true;
		}
		return success;
	}
	
	public static boolean testLength(IntArrWrap a) {
		boolean success = false;
		if(testArray.length == a.getLength()) {
			success = true;
		}
		return success;
	}

}
