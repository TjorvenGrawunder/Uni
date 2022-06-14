package Aufgabe3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Die Klasse ReplaceWordWriter erbt von BufferedWriter. Sie ersetzt jedes grossgeschriebene Wort mit
 * einem im Konstruktor uebergebenen anderen Wort.
 * 
 * @author ajeme
 *
 */
public class ReplaceWordWriter extends BufferedWriter {

	/**
	 * Wort, durch das jedes grossgeschriebene Wort ersetzt wird
	 */
	private String replacement;
	
	/**
	 * Konstruktor
	 * 
	 * @param out uebergebener Writer
	 * @param replacement Wort, durch das jedes grossgeschriebene Wort ersetzt wird
	 */
	public ReplaceWordWriter(Writer out, String replacement) {
		super(out);
		this.replacement = replacement;
	}
	
	/**
	 * Jedes grossgeschriebene Wort wird durch replacement ersetzt
	 * 
	 * @param str String, in dem Woerter geaendert werden
	 */
	@Override
	public void write(String str) {
		try {
			super.write(str.replaceAll("\\b[A-Z]([a-z]|[A-Z])*", this.replacement));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
