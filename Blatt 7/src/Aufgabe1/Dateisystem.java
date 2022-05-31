package Aufgabe1;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.util.ArrayList;
import java.util.Arrays;

public class Dateisystem implements Visitable<File> {
	
	File root;
	/**
	 * Die WUrzel wird festgelegt. Falls die Wurzel nicht existiert wird eine Exception ausgegeben
	 * @param root
	 * @throws IllegalArgumentException Falls root nicht existiert
	 */
	public Dateisystem(File root) {
		this.root = root;
		if(!this.root.exists()) {
			throw new IllegalArgumentException(root.getPath() + "existiert nicht");
		}
		//this.root = root;

		System.out.println();
	}
	
	/**
	 * Existiert nur ein File wird dieses besucht, ansonsten wird jedes File des Verzeichnisses besucht
	 */
	@Override
	public void accept(Visitor<File> v) {
		if(root.isDirectory()) {
			for(File file : root.listFiles()) {
				nextFile(file, v);
			}
		}else {
			v.visit(root);
		}
		
	}
	/**
	 * Wenn das File nicht gelesen werden kann wird visitFailed aufgerufen.
	 * Ansonsten wird fuer ein Verzeichnis jedes File besucht falls CONTINUE als VisitResult
	 * ausgegeben wurde. ALle anderen VisitResults wuerden einfach nur ausgegeben werden.
	 * Handelt es sich um kein Verzeichnis, sondern ein File wird dieses nur besucht.
	 * @param current aktuelles File
	 * @param v Visitor
	 * @return VisitResult
	 */
	public VisitResult nextFile(File current, Visitor<File> v) {
		if(!current.canRead()) {
			return v.visitFailed(current);
		}
		if(current.isDirectory()) {
			VisitResult tmp = v.preVisit(current);
			switch(tmp) {
			case CONTINUE:
				File[] files = current.listFiles();
				Arrays.sort(files);
				for(File f : files) {
					if(nextFile(f, v) == VisitResult.END) {
						return VisitResult.END;
					}
					
				}
				tmp = v.postVisit(current);
			default:
				return tmp;
			}
		}else {
			return v.visit(current);
		}
		
	}

}
