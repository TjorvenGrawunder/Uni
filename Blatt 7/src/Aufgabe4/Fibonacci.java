package Aufgabe4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Class to calculate the Fibonacci number. Uses a HashMap to reduce the
 * calculation cost.
 *
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 */
public class Fibonacci {

   private static HashMap<Integer, Long> fibonacciHash;
   private static final String nameFile = "FibonacciHashMap.ser";

  

   /**
    * Calculates the fibonacci value of n. 
    *
    * @param n a natural number >= 0 to calculate the fibonacci value of
    * @return fibonacci value of n
    */
   public static long fibonacci(int n) {
      if (n < 0) {
         throw new IllegalArgumentException("n = " + n);
      }
      deserialize();
      serialize(n);
      return (serialize(n));
   }
   
   /**
    * Liest die HashMap aus einer Datei, sofern eine solche existiert; sonst wird eine neue HashMap angelegt;
    * bei auftretenden Exceptions wird ein StackTrace ausgegeben
    * 
    */
   private static void deserialize() {
	   if (fibonacciHash == null) {								
		   File fib = new File(nameFile);						
		   		if (!fib.exists()) {
	    		  fibonacciHash = new HashMap<>();
	    	      fibonacciHash.put(0, 0L);
	    	      fibonacciHash.put(1, 1L);
	    	  } else {
	    		  ObjectInputStream inputObj = null;
	    		  try {
	    			  FileInputStream inputFile = new FileInputStream(nameFile);
	    			  inputObj = new ObjectInputStream(inputFile);
	    			  fibonacciHash = (HashMap<Integer, Long>) inputObj.readObject();
	    		  } catch (ClassNotFoundException e) {
	    			  e.printStackTrace();
	    		  } catch (IOException e) {
	    			  e.printStackTrace();
	    		  } finally {
	    			  try {
						inputObj.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
	    		  }
	    	  }
	    }
   	
   }
   /**
    * Wenn sich die Groesse der HashMap durch die Methode getFibonacci() veraendert haben sollte, wird die 
    * neue, groessere HashMap in die Datei zurueckgeschrieben; bei Exceptions wird ein StackTrace ausgegeben
    * 
    * @param n vom Benutzer eingegebene Zahl
    * @return n-te Fibonacci-Zahl
    */
   private static long serialize(int n) {
	   int groesseVorher = fibonacciHash.size();
	      long fibonacci = getFibonacci(n);
	      if (fibonacciHash.size() != groesseVorher) {
	    	  ObjectOutputStream outputObj = null;
	    	  try {
	    		  File fib = new File(nameFile);
	    		  if (!fib.exists()) {
	    			  fib.createNewFile();
	    		  }
	    		  FileOutputStream outputFile = new FileOutputStream(nameFile);
	    		  outputObj = new ObjectOutputStream(outputFile);
	    		  outputObj.writeObject(fibonacciHash);
	    	  } catch (IOException e) {
	    		  e.printStackTrace();
	    	  } finally {
	    		  try {
					outputObj.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	  }
	      }
	      return fibonacci;
   }
   
   /**
    * Berechung und Ausgabe der n-ten Fibonacci-Zahl
    * 
    * @param n vom Nutzer eingegebene Zahl
    * @return n-te Fibonacci-Zahl
    */
   private static long getFibonacci(int n) {
      if (fibonacciHash.containsKey(n)) {
         return fibonacciHash.get(n);
      } else {
         long nMinus1 = getFibonacci(n - 1);
         long nMinus2 = getFibonacci(n - 2);
         long fibonacci = nMinus1 + nMinus2;

         fibonacciHash.put(n, fibonacci);
         return fibonacci;
      }
   }

   /**
    * Main-Methode; prueft, ob nur eine Zahl uebergeben wurde und ruft, wenn dem so ist, die fibonacci()-
    * Methode auf, die die n-te Fibonacci-Zahl zurueckgibt
    * 
    * @param args vom Nutzer uebergebene Zahl
    */
   public static void main(String[] args) {
      if (args.length != 1) {
         printUsage();
      } else {
         try {
            System.out.println(fibonacci(Integer.parseInt(args[0])));

         } catch (IllegalArgumentException ex) {
            printUsage();
         }
      }
   }

   private static void printUsage() {
      System.out.println("java calc/Fiboncci n");
      System.out.println("n must be a natural number >= 0");
   }

}
