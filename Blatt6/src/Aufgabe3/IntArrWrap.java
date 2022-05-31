package Aufgabe3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Wrapper Klasse, die ein Array umgibt und diese durchlaufen, veraendern und abspeichern kann.
 */

public class IntArrWrap {
	String path;
	RandomAccessFile accFile;
	
	public IntArrWrap(int[] a, String p) {
		this.path = p;
		createFile(a);
	}
	/**
	 * Zugriff auf ein bereits existierendes Array. Sollte es nicht existieren wird eine Exception ausgeworfen.
	 * @param p
	 * @throws IOException
	 */
	public IntArrWrap(String p) throws IOException{
		File file = new File(p);
		if(!file.exists()) {
			throw new IOException(p + "not found");
		}
		accFile = new RandomAccessFile(file, "rw");
	}
	/**
	 * Neues File wird erstellt. Sollte die Datei nicht existieren wird sie angelegt. Wenn sie existiert wird das RandomAccesFile
	 * mit dem existierenden File erstellt und dieses wird geloescht und neu beschrieben.
	 */
	public void createFile(int[] arr) {
		File file = new File(path);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			accFile = new RandomAccessFile(file, "rw");
			accFile.setLength(0);
			for(Integer i: arr) {
				accFile.writeInt(i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 *Die Datei wird an der angegeben Stelle des Arrays ueberschrieben. Index*4, da Integer in vier Byte gespeichert werden.
	 * @param index
	 * @param number
	 */
	public void change(int index, int number) {
		try {
			if(index >= 0 && index < getLength() ) {
				accFile.seek(index*4);
				accFile.writeInt(number);
			}else{
				throw new ArrayIndexOutOfBoundsException(index + " is too big or too small!");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Integer an der Stelle des Indexes wird zurueckgegeben.
	 * @param index
	 * @return
	 */
	public int getAt(int index) {
		if(index >= 0 && index < getLength() ) {
			try {
				accFile.seek(index*4);
				return accFile.readInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			throw new ArrayIndexOutOfBoundsException(index + " is too big or too small!");
		}
		return 0;
	}
	/**
	 * Laenge der Datei geteilt durch vier ergibt die Laenge des Arrays(vier Byte pro Integer)
	 * @return
	 */
	public int getLength() {
		try {
			return (int) (accFile.length()/4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * manuelles Schliessen.
	 */
	public void close() {
		try {
			this.accFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
