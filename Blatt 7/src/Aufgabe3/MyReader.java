package Aufgabe3;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Die Klasse MyReader erbt von der LineNumberReader-Klasse und ergaenzt diese um die Moeglichkeit,
 * die Zeilen nach Uebereinstimmungen mit einem bestimmten vom Benutzer gewaehlten regulaeren Ausdruck
 * zu durchsuchen und die Uebereinstimmungen pro Zeile zu zaehlen
 * 
 * @author ajeme
 *
 */
public class MyReader extends LineNumberReader {
	
	/**
	 * Objekt der Klasse Pattern zum uebergebenen regulaeren Ausdruck; mit diesem Objekt sollen 
	 * Uebereinstimmungen gefunden werden
	 */
	private final Pattern suchBegriffpat;
	
	/**
	 * Anzahl der Uebereinstimmungen mit dem uebergebenen regulaeren Ausdruck pro Zeile
	 */
	private int anzahlMatches;
	
	/**
	 * Konstruktor, der ein Objekt von MyReader erzeugt; die Anzahl der Uebereinstimmungen wird mit 0 
	 * initialisiert, der uebergebene String wird zu einem Pattern umgewandelt und in suchBegriffpat gespeichert
	 * 
	 * @param in Reader, der durch MyReader ergaenzt werden soll
	 * @param suchBegriff String, mit uebergebenem regulaeren Ausdruck
	 * @throws PatternSyntaxException falls String kein regulaerer Ausdruck sein sollte und nicht zu einem Pattern
	 * umgewandelt werden kann
	 */
	public MyReader(Reader in, String suchBegriff) {
		super(in);
		this.suchBegriffpat = Pattern.compile(suchBegriff);
		this.anzahlMatches = 0;
	}
	
	/**
	 * readLine()-Methode von LineNumberReader, ergaenzt um die Zaehlung der Uebereinstimmungen in der Zeile
	 * mit dem vorgegebenen regulaeren Ausdruck; diese Zahl wird in anzahlMatches gespeichert
	 * 
	 * @return line gelesene und auf Uebereinstimmungen abgesuchte Zeile
	 * @throws IOException wegen readLine() von LineNumberReader (siehe API)
	 */
	@Override
	public String readLine() throws IOException {
		
		String line = super.readLine();
		anzahlMatches = 0;
		
		if (line != null) {
			Matcher m = this.suchBegriffpat.matcher(line);
			while (m.find() == true) {
				anzahlMatches++;
			}
		}
		
		return line;
	}
	
	/**
	 * gibt Anzahl an Uebereinstimmungen mit regulaerem Ausdruck in jeweiliger Zeile zurueck
	 * 
	 * @return anzahlMatches Anzahl der Uebereinstimmungen mit regulaerem Ausdruck in jeweiliger Zeile
	 */
	public int getAmountOfMatches() {
		return this.anzahlMatches;
	}
	
	
}
