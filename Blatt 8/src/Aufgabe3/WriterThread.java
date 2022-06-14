package Aufgabe3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedWriter;

/**
 * Die Klasse WriterThread erbt von PipedWriter und implementiert das Interface
 * Runnable.
 * 
 * @author ajeme
 *
 */
public class WriterThread extends PipedWriter implements Runnable {
	
	/**
	 * InputStream, von dem abgelesen wird, was der Writer dann schreibt
	 */
	private InputStream input;
	
	/**
	 * Konstruktor
	 * 
	 * @param input Stream, von dem abgelesen wird, was der Writer dann schreibt
	 */
	public WriterThread(InputStream input) {
		this.input = input;
	}
	
	/**
	 * BufferedReader liest stetig zeilenweise vom uebergebenen InputStream ab. 
	 * WriterThread schreibt die gelesene Zeile sofort auf.
	 */
	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(this.input));
		try{
			String line;
			while((line = reader.readLine()) != null) {
				this.write(line + "\n");
				this.flush();
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
