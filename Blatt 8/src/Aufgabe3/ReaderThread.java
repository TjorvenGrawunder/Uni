package Aufgabe3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.Writer;
/**
 * Die Klasse ReaderThread erbt von PipedReader und implementiert das Interface
 * Runnable.
 * 
 * @author ajeme
 *
 */
public class ReaderThread extends PipedReader implements Runnable{
	
	/**
	 * Writer, der Gelesenes schreibt; im Konstruktor uebergeben
	 */
	private Writer output;
	
	/**
	 * Konstruktor
	 * 
	 * @param output Writer
	 */
	public ReaderThread(Writer output) {
		this.output = output;
	}
	
	/**
	 * Vom Reader(zu BufferedReader umgewandelt, da dieser die readLine()-Methode hat)
	 * Gelesenes wird vom im Konstruktor uebergebenen Writer aufgeschrieben.
	 */
	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(this);
		while(true) {
			try{
				String line;
				while((line = reader.readLine()) != null) {
					this.output.write(line + "\n");
					this.output.flush();
				}
			
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
