/**
 * 
 */
package Aufgabe1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TimerTask;

/**
 * @author admin
 *
 */
public class FileTimeTask extends TimerTask {
	
	File f;
	long length;
	/**
	 * Konstruktor der ein File Objekt bekommt. Existiert das File nicht wird eine Exception geworfen, ansonsten werden Groesse und Datei 
	 * gespeichert
	 * @param f
	 * @throws FileNotFoundException
	 */
	public FileTimeTask(File f) throws FileNotFoundException {
		if(!f.exists()) {
			throw new FileNotFoundException("Zu ueberpruefende Datei existiert nicht");
		}else {
			this.f = f;
			this.length = getSize(f);
		}
	}
	/**
	 * Wird vom Thread ausgefuehrt
	 */
	@Override
	public void run() {
		checkLength();
	}
	/**
	 * Laenge der Datei wird ueberprueft. Aendert sich die Laenge wird die neue Laeneg ausgegeben.
	 */
	private void checkLength() {
		long newSize = getSize(f);
		if(this.length != newSize) {
			this.length = f.length();
			System.out.println("Neue Laenge: " + newSize);
		}
	}
	/**
	 * Groesse der Datei wird rekursiv berechnet
	 * @param f
	 * @return size Groesse der Datei/ des Verzeichnisses
	 */
	private long getSize(File f) {
		long size = 0;
		if(!f.isDirectory()) {
			size = f.length();
		}else {
			File[] files = f.listFiles();
			for(File file: files) {
				size += getSize(file);
			}
		}
		return size;
	}

}
