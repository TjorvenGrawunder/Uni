package Aufgabe1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Heap Test
 * 
 * @author Tjorven
 *
 */
public class HeapTest {

	public static void main(String[] args) {
		
		System.out.println("Serialisierung gestartet!");
		
		Heap<Integer> write = new Heap<Integer>(new IntegerReverseComparator());
		Heap<Integer> read = null;
		
		int[] ints = { 64, 2, 5, 76, 6, 13, 9, 43 };
		for(Integer i : ints) {
			write.insert(i);
		}
		
		File file = new File("Heap.ser");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			System.exit(1);
		}
		
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file))) {
			os.writeObject(write);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
			read = (Heap<Integer>) is.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(write.size() == read.size()) {
			for(int i = 0; i < write.size(); i++) {
				Assert.assertEquals(write.deleteFirst(), read.deleteFirst());
			}
		} else {
			System.out.println("Laenge ist nicht gleich");
		}
		
		System.out.println("Serialisierung beendet!");
		
	}
	


}
