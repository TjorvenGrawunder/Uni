package Aufgabe3;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * uebersetzt die deutsche Sprache in die Sprache der Marklar
 * 
 * @author ajeme
 *
 */
public class MarklarTranslator {
	
	/**
	 * Wort, durch das alle grossgeschriebenen Woerter ersetzt werden
	 */
	private static final String marklar = "Marklar";

	/**
	 * Erstellter WriterThread benutzt System.in als InputStream; erstellter ReaderThread bekommt 
	 * ReplaceWordWriter als Konstruktorparameter uebergeben; erstellter ReplaceWordWriter schreibt auf System.out
	 * und bekommt als replacement-Wort "Marklar" uebergeben. WriterThread und ReaderThread werden verbunden und die 
	 * Threads werden gestartet. Es gibt einen Shutdown-Hook, der Writer- und ReaderThread beim Programmende schlieﬂt.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		WriterThread output = new WriterThread(System.in);
		ReaderThread input = new ReaderThread(new ReplaceWordWriter(new OutputStreamWriter(System.out), marklar));
		
		try {
			input.connect(output);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		Thread writer = new Thread(output);
		Thread reader = new Thread(input);
		
		writer.start();
		reader.start();
		
		Thread hook = new Thread() {
			public void run() {
				try {
					output.close();
					input.close();
				} catch(IOException ex) {
					
				}
			}
		};
		
		Runtime.getRuntime().addShutdownHook(hook);
		
		
	}
}
