package Aufgabe3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.PatternSyntaxException;

/**
 * Kommandozeilenprogramm zum Durchsuchen einer uebergebenen Datei auf Uebereinstimmungen mit dem uebergebenen
 * regulaeren Ausdruck; jede Zeile der Datei, die den regulaeren Ausruck mindestens einmal enthaelt, wird
 * zusammen mit der Zeilennummer und der Anzahl der Uebereinstimmungen ausgegeben
 * 
 * @author ajeme
 *
 */
public class Durchsuchen {

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("Fehler! Es soll ein ein regulaerer Ausdruck uebergeben werden!");
			System.out.println("Geben Sie ein: java Durchsuchen RegulaererAusdruck < Name, der zu durchsuchenden Datei");
			System.exit(-1);
		}
		
		String regAusdruck = args[0];
		
		MyReader reader = null;
		try {
			reader = new MyReader(new InputStreamReader(System.in), regAusdruck);
		} catch (PatternSyntaxException e) {
			System.out.println("Fehler! Eingabe ist kein regulaerer Ausdruck!");
			System.exit(-1);
		}
		
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				if (reader.getAmountOfMatches() > 0) {
					System.out.printf("Zeile %d, %d Matches: %s %n", reader.getLineNumber(),reader.getAmountOfMatches(), line); 
				}
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
}
